package com.jtsp.springboot3redis.service;

import com.jtsp.springboot3redis.entity.Product;
import com.jtsp.springboot3redis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Cacheable(value = "products", key = "#id")
    public Product findProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @CacheEvict(value = "products", allEntries = true)
    public List<Product> createProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @CachePut(value = "products", key = "#product.id")
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @CacheEvict(value = "products", key = "#id")
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
