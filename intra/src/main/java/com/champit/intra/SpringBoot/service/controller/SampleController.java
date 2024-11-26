package com.champit.intra.SpringBoot.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SampleController {

    @RequestMapping(value="/intra/sampleValue", method = RequestMethod.GET)
    public String getSampleValue(){

        log.info(" ■■■■■■■■ {} ■■■■■■■■", "/intra/sampleValue");
        return "{\"result\" : \"ok\"}";

    }

    @RequestMapping(value="/intra/sampleValue2", method = RequestMethod.POST)
    public String getSampleValue2(){

        log.info(" ■■■■■■■■ {} ■■■■■■■■", "/intra/sampleValue2");
        return "{\"result\" : \"ok\"}";
        
    }

}
