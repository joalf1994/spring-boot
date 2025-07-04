package com.jbobadilla.product_microservice.controller;

import com.jbobadilla.product_microservice.domain.entity.Product;
import com.jbobadilla.product_microservice.repository.ProductRepository;
import com.jbobadilla.product_microservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.protobuf.ProtobufDecoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        Product prodExist = productService.findById(id);
        if (prodExist == null) {
            return ResponseEntity.notFound().build();
        }
        //actualiza
        prodExist.setProdName(product.getProdName());
        prodExist.setPodDescription(product.getPodDescription());
        prodExist.setUnitPrice(product.getUnitPrice());
        Product save =  productService.update(prodExist);
        return ResponseEntity.ok(save);
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping(value = "/search/by-price")
    public List<Product> findByUnitPriceLessThan(@RequestParam("unitPrice") Double unitPrice) {
        return productService.findByUnitPriceLessThan(unitPrice);
    }

}
