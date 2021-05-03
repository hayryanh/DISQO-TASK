package com.data.agent.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = "com.data.agent")
public class DataAgentStarter {

    public static void main(String[] args) {
        SpringApplication.run(DataAgentStarter.class, args);
    }
}