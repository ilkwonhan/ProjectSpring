package com.champit.intra.SpringBoot.service.controller.Main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;


@RestController
public class MainController {


    @Value("${file.root}")
    private String root;

    private ModelAndView mav;
    
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ModelAndView loginFormRoot() throws Exception {
      
      mav = new ModelAndView();

		  mav.setViewName("/index.html");
	
		  return mav;
    }

    public boolean loginChk(HttpServletRequest req) {
      System.out.println(req.getAttribute("loginChk"));
      if(req.getAttribute("loginChk") == null) {
        return false;
      }
      return true;
    }


}
