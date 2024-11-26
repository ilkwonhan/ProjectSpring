package com.champit.intra.SpringBoot.batch.DiscordAlertJobConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;


import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;
import com.champit.intra.SpringBoot.batch.Discord.service.WebHookService;
import com.champit.intra.vo.Log;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DiscordJobConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    private final WebHookService webHookService;

    
    private final PlatformTransactionManager platformTransactionManager;
    private final DataSource dataSource;

    private static final int chunkSize = 1000;

    
    @Value("${file.root}") //C:/champit/SpringBoot/intra/src/main/resources/static
    private String root;

    /**
     * 로그 등록을 위한 Job
     *
     * @return 로그 등록 Job
     * @throws Exception 
     */
    @Bean
    public Job discordJob() throws Exception {
        return new JobBuilder("discordJob", jobRepository)
                    .start(discordAlertStep()) // job이 처음 시작될 때 실행되는 step
                    .next(discordLogRegisterStep())
                    .preventRestart() // job 실행이 실패할 경우 재시작 막기
                    .incrementer(new CustomJobParametersIncrementer())
                    .build();
    }

    /**
     * contents가 입력된 로그 등록을 위한 Step
     *
     * @return contents 입력 로그 등록 Step
     */
    @Bean
    public Step discordAlertStep() {
        return new StepBuilder("contentsLogRegisterStep", jobRepository)
                    .tasklet(contentsLogRegisterTasklet(), transactionManager) // step에서 실행될 tasklet
                    .build();
    }

    /**
     * contents가 입력된 로그 등록을 위한 Tasklet
     *
     * @return contents 입력 로그 등록 Tasklet
     */
    @Bean
    public Tasklet contentsLogRegisterTasklet() {
        return (contribution, chunkContext) -> {
            // 로그 데이터 적재
            
            webHookService.callEvent();
            // 배치 종료
            return RepeatStatus.FINISHED;
        };
    }

    /**
     * date가 입력된 로그 등록을 위한 Step
     *
     * @return date 입력 로그 등록 Step
     * @throws Exception 
     */
    @Bean
    public Step discordLogRegisterStep() throws Exception {
        return new StepBuilder("discordLogRegisterStep", jobRepository)
                    .<Log, Log>chunk(chunkSize, platformTransactionManager)  // 1000개 단위 처리
                    .reader(jdbcCursorItemReader())    // 파일에서 정보를 읽기
                    // .processor(processor2())  // 처리
                    .writer(flatFileItemWriter())        // 처리된 정보를 저장
                    .build();
    }
    
    @Bean
    @StepScope
    public JdbcCursorItemReader<Log> jdbcCursorItemReader() {
        return new JdbcCursorItemReaderBuilder<Log>()
                    .fetchSize(chunkSize)
                    .dataSource(dataSource)
                    .rowMapper(new BeanPropertyRowMapper<>(Log.class))
                    .sql("SELECT a.job_instance_id" +
                        "     , a.job_name" +
                        "     , b.create_time" +
                        "     , b.start_time" +
                        "     , b.end_time" +
                        "     , b.status" +
                        "     , b.exit_code" +
                        "     , b.last_updated" +
                        "  FROM batch_job_instance a " +
                        "  JOIN batch_job_execution b " +
                        "    ON a.job_instance_id = b.job_instance_id" +
                        "  JOIN batch_job_execution_context c" +
                        "    ON b.job_execution_id = c.job_execution_id" +
                        "  JOIN batch_job_execution_params d" +
                        "    ON b.job_execution_id = d.job_execution_id" +
                        " WHERE a.job_name = 'discordJob'" +
                        "   AND a.job_instance_id = (SELECT MAX(job_instance_id) FROM batch_job_instance)")
                    .name("jdbcCursorItemReader")
                    .build();
    }

    /**
     * date가 입력된 로그 등록을 위한 Tasklet
     *
     * @return date 입력 로그 등록 Tasklet
     */
    @StepScope
    @Bean
    public FlatFileItemWriter<Log> flatFileItemWriter() throws Exception{
        
        BeanWrapperFieldExtractor<Log> extractor = new BeanWrapperFieldExtractor();
         //필드명 설정(vo.Log)
        extractor.setNames(new String[] {"job_instance_id", "job_name", "create_time", "start_time", "end_time", "status", "exit_code", "last_updated"});

        //line 구분값 설정
        DelimitedLineAggregator<Log> lineAggreator = new DelimitedLineAggregator<>();
        lineAggreator.setDelimiter(",");
        lineAggreator.setFieldExtractor(extractor);

        FlatFileItemWriter<Log> writer = new FlatFileItemWriterBuilder<Log>()
                .name("csvItemWriter")
                .encoding("UTF-8")
                .resource(new FileSystemResource( root + "/Log/csv/DiscordLog.csv")) //경로 지정_static에 지정하지 않으면 서버 재시작
                .lineAggregator(lineAggreator)
                .headerCallback(writer1 -> writer1.write("job_instance_id, job_name, create_time, start_time, end_time, status, exit_code, last_updated")) //header설정
                //.footerCallback(writer1 -> writer1.write("---------------\n")) //footer설정
                .append(true) //파일 밑에 이어서 쓰기
                .build();

        writer.afterPropertiesSet();

        return writer;
    }
}