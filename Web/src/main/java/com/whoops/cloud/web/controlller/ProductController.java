package com.whoops.cloud.web.controlller;

import com.whoops.cloud.inter.ProductApi;
import com.whoops.cloud.inter.entity.ProductDTO;
import com.whoops.cloud.web.vo.ProductTable;
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
    private ProductApi productApiService;

    @GetMapping("/getAllProducts")
    @ResponseBody
    public ProductTable getAllProducts(@RequestParam(value = "type",required = false) String type){
        System.out.println("web1");
        if (StringUtils.isBlank(type)){
            return new ProductTable(0,"",0,null);
        }
        List<ProductDTO> productList = productApiService.getAllProducts(type);
        return new ProductTable(0,"",productList.size(),productList);
    }

    @GetMapping("/productList")
    public String productList(){
        return "productList";
    }


}
