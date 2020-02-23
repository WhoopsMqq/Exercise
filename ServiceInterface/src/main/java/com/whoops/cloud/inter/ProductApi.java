package com.whoops.cloud.inter;

import com.whoops.cloud.inter.entity.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductApi {

    @GetMapping("/getAllProducts")
    List<ProductDTO> getAllProducts(@RequestParam("type") String type);

}
