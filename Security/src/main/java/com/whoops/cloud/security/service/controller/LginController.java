package com.whoops.cloud.security.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LginController {

    @GetMapping("/login")
    public String login(){
        return "lgin";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

}
