package com.ohdoking.explain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
@EnableAutoConfiguration
public class ExplainServiceApplication {
	
	@Value("${test.hello}")
	private String greeting;
	
    @RequestMapping("/")
    public String home() {
    	System.out.println(greeting);
        return "";
    }

    public static void main(String[] args) {
        SpringApplication.run(ExplainServiceApplication.class, args);
    }

}