package com.whoops.cloud.controlller;

import com.whoops.cloud.entity.Product;
import com.whoops.cloud.remote.ProductRemote;
import com.whoops.cloud.vo.ProductTable;
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
    private ProductRemote productRemote;

    @GetMapping("/getAllProducts")
    @ResponseBody
    public ProductTable getAllProducts(@RequestParam(value = "type",required = false) String type){
        if (StringUtils.isBlank(type)){
            return new ProductTable(0,"",0,null);
        }
        List<Product> productList = productRemote.getAllProducts(type);
        return new ProductTable(0,"",productList.size(),productList);
//        return null;
    }

    @GetMapping("/productList")
    public String productList(){
        return "productList";
    }


}
