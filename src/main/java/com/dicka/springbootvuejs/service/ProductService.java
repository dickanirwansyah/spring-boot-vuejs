package com.dicka.springbootvuejs.service;

import com.dicka.springbootvuejs.entity.Product;
import com.dicka.springbootvuejs.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> listProduct(){
        return productRepository.findAll();
    }

    public Optional<Product> getId(Long productId){
        return productRepository.findById(productId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void delete(Long productId){
        productRepository.deleteById(productId);
    }
}
