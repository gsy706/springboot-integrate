package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ImoocApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImoocApplication.class, args);
    }
}
