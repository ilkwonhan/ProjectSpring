package com.champit.intra.SpringBoot.batch.DiscordAlertJobConfig;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogSchedule {

    private final JobLauncher jobLauncher;
    private final JobExplorer jobExplorer;
    private final DiscordJobConfig discordJobConfig;
    /*
    @Scheduled(cron = "0/30 * * * * ?") // 10초마다 Job 실행, cron 표현식 활용 (초 분 시 일 월 요일)
    public void logRegister() throws Exception {
        jobLauncher.run(
            discordJobConfig.discordJob(),
                new JobParametersBuilder(jobExplorer)
                    .getNextJobParameters(discordJobConfig.discordJob())
                    .toJobParameters()
        );
    }
    */
}