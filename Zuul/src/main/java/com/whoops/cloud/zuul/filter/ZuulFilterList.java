package com.whoops.cloud.zuul.filter;

import org.springframework.context.annotation.Bean;

public class ZuulFilterList {
    @Bean
    public LoginFilter loginFilter(){
        return new LoginFilter();
    }
}
