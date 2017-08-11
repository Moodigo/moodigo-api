package com.zoutly.datagen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zoutly"})
public class DatagenApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatagenApplication.class, args);
    }

}
