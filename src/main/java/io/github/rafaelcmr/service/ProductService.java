package io.github.rafaelcmr.service;

import io.github.rafaelcmr.domain.Product;
import io.github.rafaelcmr.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    Product findProductOrThrowBadRequestException(Long id );
    List<Product> findAllProducts();
    Product saveProduct(ProductDTO productDTO);
    Product updateProduct(ProductDTO productDTO);
    void deleteProductById(Long id);
}
