package com.champit.intra.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
    
    @SuppressWarnings("null")
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/","classpath:/static/");
        registry.addResourceHandler("/empImg/**")
                .addResourceLocations("file:///C:/Temp/upload/empImg/");
    }
}
