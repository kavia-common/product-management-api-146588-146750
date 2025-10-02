package com.example.productsbackend.repository;

import com.example.productsbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Product persistence.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
