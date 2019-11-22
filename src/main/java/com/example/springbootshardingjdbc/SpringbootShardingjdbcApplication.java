package com.example.springbootshardingjdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.example.springbootshardingjdbc.mapper")
public class SpringbootShardingjdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShardingjdbcApplication.class, args);
    }

}
