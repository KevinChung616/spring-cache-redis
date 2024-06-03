package com.jtsp.springboot3redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBoot3RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3RedisApplication.class, args);
    }

}
