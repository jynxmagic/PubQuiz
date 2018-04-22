package com.auth0.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.auth0.samples.classes.BeanConfig;

@SpringBootApplication
@Import({BeanConfig.class})
@Configuration
@ComponentScan(basePackages = "com.auth0.samples")
@EnableAutoConfiguration
public class Main 
{
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Main.class);
	}


	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(Main.class, args);
	}
}
