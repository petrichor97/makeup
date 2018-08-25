package com.tianxuan.makeup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MakeupApplication {

    public static void main(String[] args) {
        SpringApplication.run(MakeupApplication.class, args);
    }
}
