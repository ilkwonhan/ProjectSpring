package com.champit.intra.SpringBoot.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/th/chat/*")
public class ChatController {
    
    @GetMapping(value = "chat")
    public ModelAndView chat() {
        log.info("시작");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("th/chat/chat.html");
        log.info("종료");
        return mv;
    }
}