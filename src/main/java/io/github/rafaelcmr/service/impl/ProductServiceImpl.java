package io.github.rafaelcmr.service.impl;

import io.github.rafaelcmr.domain.Product;
import io.github.rafaelcmr.dto.ProductDTO;
import io.github.rafaelcmr.repository.ProductRepository;
import io.github.rafaelcmr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public Product findProductOrThrowBadRequestException(Long id) {
        return repository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product Not Found"));
    }

    @Override
    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        return repository.save(new Product(null, productDTO.getDescription(), productDTO.getPrice()));
    }

    @Override
    public Product updateProduct(ProductDTO productDTO) {
        Product productToBeUpdated = findProductOrThrowBadRequestException(productDTO.getId());
        productToBeUpdated.setPrice(productDTO.getPrice());
        productToBeUpdated.setDescription(productDTO.getDescription());
        return repository.save(productToBeUpdated);
    }

    @Override
    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }
}
