package com.whoops.cloud.remote;

import com.whoops.cloud.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "service")
public interface ProductRemote {

    @GetMapping("/product/getAllProducts")
    List<Product> getAllProducts(@RequestParam("type") String type);
}
