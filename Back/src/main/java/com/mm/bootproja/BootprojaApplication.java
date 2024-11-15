package com.mm.bootproja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mm")
public class BootprojaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootprojaApplication.class, args);
    }

}
