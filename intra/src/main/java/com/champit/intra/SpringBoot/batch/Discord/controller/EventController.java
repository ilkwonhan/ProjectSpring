package com.champit.intra.SpringBoot.batch.Discord.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.champit.intra.SpringBoot.batch.Discord.service.WebHookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/event")
public class EventController {

    private final WebHookService webHookService;
    
    @RequestMapping(value = "", method={RequestMethod.GET})
    public String postEvent(){
        System.out.println("EventController");

        webHookService.callEvent();
        return "Event alert!";
    }

}
