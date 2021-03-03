package io.github.rafaelcmr.controller;

import io.github.rafaelcmr.domain.Product;
import io.github.rafaelcmr.dto.ProductDTO;
import io.github.rafaelcmr.repository.ProductRepository;
import io.github.rafaelcmr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findProductOrThrowBadRequestException(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(service.findAllProducts());
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(service.saveProduct(productDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(service.updateProduct(productDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
