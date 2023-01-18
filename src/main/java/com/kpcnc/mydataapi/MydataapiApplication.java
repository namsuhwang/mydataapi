package com.kpcnc.mydataapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class MydataapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MydataapiApplication.class, args);
    }

}
