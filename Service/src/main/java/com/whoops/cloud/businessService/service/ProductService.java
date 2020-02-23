package com.whoops.cloud.businessService.service;

import com.whoops.cloud.businessService.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllDomesticProducts();

    List<Product> getAllForeignProducts();

}
