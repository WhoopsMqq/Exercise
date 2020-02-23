package com.whoops.cloud.businessService.repository.domestic;

import com.whoops.cloud.businessService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomesticProductRepository extends JpaRepository<Product,Integer> {
}
