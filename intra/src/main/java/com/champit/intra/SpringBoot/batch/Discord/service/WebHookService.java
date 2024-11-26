package com.champit.intra.SpringBoot.batch.Discord.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.champit.intra.SpringBoot.batch.Discord.dao.DiscordDao;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class WebHookService {

    @Autowired
    private DiscordDao discordDao;

    @Value("${discord.webhookURL}")
    private String url;

    public void callEvent(){
        JSONObject data = new JSONObject();
        System.out.println("WebHookService");
        int vacationCount = discordDao.vacationCount();
        
        data.put("content", (vacationCount == 0 ? "" : "[알림] 이벤트가 발생하였습니다 : 현재 휴가신청 미승인 " + vacationCount + "건 존재합니다."));
        send(data);
    }

    private void send(JSONObject object){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(object.toString(), headers);
        restTemplate.postForObject(url, entity, String.class);
    }

}