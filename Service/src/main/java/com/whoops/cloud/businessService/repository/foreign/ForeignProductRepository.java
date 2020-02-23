package com.whoops.cloud.businessService.repository.foreign;

import com.whoops.cloud.businessService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeignProductRepository extends JpaRepository<Product,Integer> {
}
