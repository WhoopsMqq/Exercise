package com.whoops.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.whoops.cloud.zuul.tool.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LoginFilter extends ZuulFilter {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return Integer.MIN_VALUE;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String url = request.getRequestURI();
        if (StringUtils.equals(url,"/security/login-in") || StringUtils.equals(url,"/security/login")){   //登录请求不拦截
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = "";
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            //转发至登录请求
            HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(request){
                @Override
                public String getRequestURI() {
                    return "/security/login";
                }
            };
            requestContext.setRequest(requestWrapper);
            return null;
        }
        for (Cookie cookie : cookies){
            if (StringUtils.equalsIgnoreCase(cookie.getName(),"JSESSIONID")){
                token = cookie.getValue();
            }
        }
        if (redisUtil.hasKey(token)){

            return null;  //用户已经登录,放行
        }
        //转发至登录请求
        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(request){
            @Override
            public String getRequestURI() {
                return "/security/login";
            }
        };
        requestContext.setRequest(requestWrapper);
        return null;
    }
}
