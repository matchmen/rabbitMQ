package com.mt.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * author: liqm
 * 2020-02-26
 */
@EnableScheduling
@SpringBootApplication
public class RabbitMQApplication {

    public static void main(String[] args) {

        SpringApplication.run(RabbitMQApplication.class, args);


    }

}
