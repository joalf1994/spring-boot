package com.jbobadilla.product_microservice.service.impl;

import com.jbobadilla.product_microservice.domain.entity.Product;
import com.jbobadilla.product_microservice.repository.ProductRepository;
import com.jbobadilla.product_microservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }


    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByUnitPriceLessThan(Double unitPrice) {
        return productRepository.findByUnitPriceLessThan(unitPrice);

    }
}
