package com.whoops.cloud.businessService.service.impl;

import com.whoops.cloud.businessService.entity.Product;
import com.whoops.cloud.businessService.repository.domestic.DomesticProductRepository;
import com.whoops.cloud.businessService.repository.foreign.ForeignProductRepository;
import com.whoops.cloud.businessService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private DomesticProductRepository domesticProductRepository;

    @Autowired
    private ForeignProductRepository foreignProductRepository;

    @Override
    public List<Product> getAllDomesticProducts(){
        return domesticProductRepository.findAll();
    }

    @Override
    public List<Product> getAllForeignProducts(){
        return foreignProductRepository.findAll();
    }


}
