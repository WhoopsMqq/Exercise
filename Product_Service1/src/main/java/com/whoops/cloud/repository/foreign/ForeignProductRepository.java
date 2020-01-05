package com.whoops.cloud.repository.foreign;

import com.whoops.cloud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeignProductRepository extends JpaRepository<Product,Integer> {
}
