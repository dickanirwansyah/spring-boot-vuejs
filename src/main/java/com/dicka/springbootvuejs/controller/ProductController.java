package com.dicka.springbootvuejs.controller;

import com.dicka.springbootvuejs.entity.Product;
import com.dicka.springbootvuejs.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.listProduct());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getId(@PathVariable("id") Long id){
        Optional<Product> productId = productService.getId(id);
        if (!productId.isPresent()){
            log.error("Id "+id+" is not exists");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productId.get());
    }

    @PutMapping(value = "/{productId}")
    public ResponseEntity<Product> update(@PathVariable Long productId, @RequestBody Product product){
        if (!productService.getId(productId).isPresent()){
            log.error("Id "+productId+" is not exists");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productService.save(product));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        if (!productService.getId(id).isPresent()){
            log.error("Id "+id+" is not exists");
            ResponseEntity.badRequest().build();
        }
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
