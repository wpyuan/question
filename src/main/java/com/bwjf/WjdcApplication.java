package com.bwjf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.bwjf.mapper")
@ComponentScan({"com.bwjf.controller","com.bwjf.service"})
public class WjdcApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjdcApplication.class, args);
    }
}
