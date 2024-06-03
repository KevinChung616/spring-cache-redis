package com.jtsp.springboot3redis.repository;

import com.jtsp.springboot3redis.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
