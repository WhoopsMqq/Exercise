package com.whoops.cloud.remote;

import com.whoops.cloud.entity.Product;
import com.whoops.cloud.remote.fallback.ProductRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name = "service",fallback = ProductRemoteHystrix.class)
public interface ProductRemote {

    @GetMapping("/product/getAllProducts")
    List<Product> getAllProducts(@RequestParam("type") String type);
}
