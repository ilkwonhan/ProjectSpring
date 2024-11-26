package com.champit.intra.JPA.controller;

import org.hibernate.mapping.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/news")
public class NewsController {
       
	//final NewsDAO dao;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ModelAndView mv;

	@GetMapping(value = "/newsList")
	public String getAll() {
		mv = new ModelAndView();
		logger.info("=================================== null ===================================");
		mv.setViewName("news/newsList");
    	return "/news/newsList";
	}
	

}
