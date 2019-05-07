package com.gabrielleopoldino.simpleusercrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigurationProperties(UserProperties.class)
public class SimpleUserCrud {
    public static void main(String[] args) {
        SpringApplication.run(SimpleUserCrud.class, args);
    }
}