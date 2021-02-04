package io.github.rafaelcmr.repository;

import io.github.rafaelcmr.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
