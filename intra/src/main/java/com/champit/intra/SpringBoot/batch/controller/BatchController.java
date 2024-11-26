package com.champit.intra.SpringBoot.batch.controller;

import org.springframework.stereotype.Controller;
/*
import java.util.Date;
import java.util.HashMap;
import java.util.List;


import com.champit.intra.SpringBoot.batch.Discord.job.DiscordBatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
*/

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BatchController {
/*
    private JobLauncher jobLauncher;
    private List<Job> jobList;

    @Autowired
    private DiscordBatch discordJob;
    
    public void discordBatchController(HashMap<String, String> map) {
        System.out.println("1111111111111111111111");
        JobParameters jobParameters = new JobParametersBuilder()
            .addDate("workDate", new Date())
            .toJobParameters();

            System.out.println("2222222222222222222");
        int jobIndex = 0;
        int iLoop = 0;
        /*
        for (Job job : jobList) {
            log.info( "작업명 {}", job.getName() );
            if (job.getName().equals(map.get("jobName"))) {  
                jobIndex = iLoop;
                break;
            }
            iLoop++;
        }
            
        try {

            log.info( "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ Start Job {}", map.get("jobName") ); 
            //jobLauncher.run(jobList.get(jobIndex) , jobParameters);
            jobLauncher.run(jobList.get(jobIndex), jobParameters);

        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            e.printStackTrace();
        }

        log.info( "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ End Job  {}", map.get("jobName") );
         
    }
     */
}
