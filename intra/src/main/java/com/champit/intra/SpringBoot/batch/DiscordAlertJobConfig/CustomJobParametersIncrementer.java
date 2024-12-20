package com.champit.intra.SpringBoot.batch.DiscordAlertJobConfig;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * incrementer 구현
 */
public class CustomJobParametersIncrementer implements JobParametersIncrementer {
    static final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

    /**
     * Date 를 incrementer 로 지정해보자.
     * @param jobParameters
     * @return
     */
    @Override
    public JobParameters getNext(JobParameters jobParameters) {
        String id = format.format(new Date());

        return new JobParametersBuilder().addString("run.id", id).toJobParameters();
    }
}