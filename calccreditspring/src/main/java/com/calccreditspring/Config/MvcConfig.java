package com.calccreditspring.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*Ниже спринг уже представляет систему авторизации, создавать контроллер нет необходимости*/
@Configuration
public class MvcConfig implements WebMvcConfigurer
{

    public void addViewControllers(ViewControllerRegistry registry)
    {

        registry.addViewController("/login").setViewName("login");
    }

}

