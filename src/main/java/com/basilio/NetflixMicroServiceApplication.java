package com.basilio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class NetflixMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixMicroServiceApplication.class, args);
    }
}
