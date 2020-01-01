package com.whoops.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Product_Service1 {
    public static void main(String[] args){
        SpringApplication.run(Product_Service1.class,args);
    }
}
