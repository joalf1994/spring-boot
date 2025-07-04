package com.jbobadilla.product_microservice.service;

import com.jbobadilla.product_microservice.domain.entity.Product;

import java.util.List;

public interface ProductService {

    //CRUD de Product
    public Product findById(Long id);

    public Product create(Product product);

    public Product update(Product product);


    public void delete(Long id);

    public List<Product> findAll();

    public List<Product> findByUnitPriceLessThan(Double unitPrice);

}
