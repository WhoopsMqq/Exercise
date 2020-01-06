package com.whoops.cloud.controlller;

import com.whoops.cloud.entity.Product;
import com.whoops.cloud.entity.Response;
import com.whoops.cloud.remote.ProductRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private ProductRemote productRemote;

    @GetMapping("/getAllProducts")
    @ResponseBody
    public /*ResponseEntity<Response>*/ List<Product> getAllProducts(@RequestParam("type") String type){
        List<Product> productList = productRemote.getAllProducts(type);
//        if (productList != null){
//            return ResponseEntity.ok().body(new Response(true,"加载成功!",productList));
//        }
//        return ResponseEntity.ok().body(new Response(false,"加载失败!"));
        return productList;
    }

}
