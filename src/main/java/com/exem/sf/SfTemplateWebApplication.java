package com.exem.sf;

import com.exem.sf.common.UserHandlerMethodArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by CHOI SUNG HOON on 2017. 6. 22..
 */
/**
 * The type Sf template web application.
 */
@SpringBootApplication
public class SfTemplateWebApplication extends WebMvcConfigurerAdapter {

    /**
     * The entry point of application.
     * Used when launching as an executable.jar or war
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
    	SpringApplication.run(SfTemplateWebApplication.class, args);
	}

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UserHandlerMethodArgumentResolver());
    }
}
