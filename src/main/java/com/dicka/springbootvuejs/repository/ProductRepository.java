package com.dicka.springbootvuejs.repository;

import com.dicka.springbootvuejs.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
