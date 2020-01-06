package com.whoops.cloud.service;

import com.whoops.cloud.entity.Product;
import com.whoops.cloud.repository.domestic.DomesticProductRepository;
import com.whoops.cloud.repository.foreign.ForeignProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private DomesticProductRepository domesticProductRepository;

    @Autowired
    private ForeignProductRepository foreignProductRepository;

    public List<Product> getAllDomesticProducts(){
        return domesticProductRepository.findAll();
    }

    public List<Product> getAllForeignProducts(){
        return foreignProductRepository.findAll();
    }


}
