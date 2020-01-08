package com.whoops.cloud.remote.fallback;

import com.whoops.cloud.entity.Product;
import com.whoops.cloud.remote.ProductRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRemoteHystrix implements ProductRemote {
    @Override
    public List<Product> getAllProducts(@RequestParam("type") String type) {
        return new ArrayList<>();
    }
}
