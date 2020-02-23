package com.whoops.cloud.zuul;

import com.whoops.cloud.zuul.filter.ZuulFilterList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class Application extends ZuulFilterList {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
