package com.champit.intra.SpringBoot.batch.Discord.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.champit.intra.SpringBoot.batch.Discord.service.WebHookService;

@Configuration
public class BotConfiguration {
    
    @Bean
    public WebHookService webHookService(){
        System.out.println("BotConfiguration");
        return new WebHookService();
    }

}
