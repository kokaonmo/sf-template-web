package com.exem.sf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * The type Sf template web application.
 */
@SpringBootApplication
public class SfTemplateWebApplication extends SpringBootServletInitializer {

    /**
     * The entry point of application.
     * Used when launching as an executable.jar or war
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		SpringApplication.run(SfTemplateWebApplication.class, args);
	}

	/**
     * Used when deploying to a standalone servlet container
     */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SfTemplateWebApplication.class);
	}
}
