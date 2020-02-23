package com.whoops.cloud.businessService.rpc;

import com.whoops.cloud.businessService.service.ProductService;
import com.whoops.cloud.inter.ProductApi;
import com.whoops.cloud.inter.entity.ProductDTO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements ProductApi, InitializingBean {

    @Autowired
    private List<ProductService> productServiceList;

    @ResponseBody
    public List<ProductDTO> getAllProducts(@RequestParam("type") String type){
        System.out.println("product1");
//        if (StringUtils.equals(type,"domestic")){
//            return productService.getAllDomesticProducts();
//        }else if (StringUtils.equals(type,"foreign")){
//            return productService.getAllForeignProducts();
//        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("     productServiceList size>>>>" + productServiceList.size());
        System.out.println("     productServiceList     >>>>" + productServiceList);
    }

}
