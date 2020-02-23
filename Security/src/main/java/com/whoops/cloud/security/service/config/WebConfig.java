package com.whoops.cloud.security.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private URIInterceptor uri;

//    @Override
//        registry.addInterceptor(uri);
//    }

    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        URIFilter uriFilter = new URIFilter();
        registrationBean.setFilter(uriFilter);//将自定义的Filter或者第三方框架提供的Filter添加进去

        List<String> url = new ArrayList<>();
        url.add("/*");//设置filter要拦截的URL
        registrationBean.setUrlPatterns(url);
        registrationBean.setOrder(Integer.MIN_VALUE);
        return registrationBean;
    }
}
