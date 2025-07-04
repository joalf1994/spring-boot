package com.jbobadilla.product_microservice.repository;

import com.jbobadilla.product_microservice.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByUnitPriceLessThan(Double unitPrice);
}
