package com.champit.intra.SpringBoot.batch.Discord.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.champit.intra.SpringBoot.batch.Discord.service.WebHookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DiscordBatch {
    /*
    @Autowired
    private WebHookService webHookService;

    private JobRepository jobRepository;
    private Step discordStep1;
    private Tasklet Tasklet;
    private PlatformTransactionManager platformTransactionManager;
    
    @Bean
    public Job discordJob() {
        return new JobBuilder("discordJob", jobRepository)
                .start(discordStep1)
                .build();
    }

    public Step discordStep1(JobRepository jobRepository){
        return new StepBuilder("simpleStep", jobRepository)
                .tasklet(Tasklet, platformTransactionManager).build();
    }

    public Tasklet Tasklet(){
        return ((contribution, chunkContext) -> {
            webHookService.callEvent();
            return RepeatStatus.FINISHED;
        });
    }
         */

}