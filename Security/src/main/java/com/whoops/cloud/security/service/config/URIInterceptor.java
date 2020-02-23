package com.whoops.cloud.security.service.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class URIInterceptor  implements HandlerInterceptor {
    @Override //控制器的方法被调用之前会被调用
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        return true;
    }

    @Override //控制器的方法被调用之后会被调用 如果抛出异常就不会调用
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle");
//        System.out.println("time:"+(new java.util.Date().getTime() - (Long)request.getAttribute("startTime")));
    }

    @Override //无论是否抛出异常,都会在最后被调用
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion");
    }
}
