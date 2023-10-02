package com.albee.mydataapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MydataapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MydataapiApplication.class, args);
    }

}
