package com.fackluckincoffee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fackluckincoffee.mapper")
public class FackLuckinCoffeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FackLuckinCoffeeApplication.class, args);
    }

}
