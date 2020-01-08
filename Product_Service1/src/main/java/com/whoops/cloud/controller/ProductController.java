package com.whoops.cloud.controller;

import com.whoops.cloud.entity.Product;
import com.whoops.cloud.service.ProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProducts")
    @ResponseBody
    public List<Product> getAllProducts(@RequestParam("type") String type){
        System.out.println("product1");
        if (StringUtils.equals(type,"domestic")){
            return productService.getAllDomesticProducts();
        }else if (StringUtils.equals(type,"foreign")){
            return productService.getAllForeignProducts();
        }
        return null;
    }





}
