package com.example.productsbackend.service;

import com.example.productsbackend.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * Service interface defining business operations for Product.
 */
public interface ProductService {

    // PUBLIC_INTERFACE
    /**
     * Create a new product.
     * @param product Product to create.
     * @return Created product with generated id.
     */
    Product create(Product product);

    // PUBLIC_INTERFACE
    /**
     * Get all products.
     * @return list of products.
     */
    List<Product> findAll();

    // PUBLIC_INTERFACE
    /**
     * Find product by id.
     * @param id product id.
     * @return optional product.
     */
    Optional<Product> findById(Long id);

    // PUBLIC_INTERFACE
    /**
     * Update product by id.
     * @param id product id.
     * @param product product data to set.
     * @return updated product.
     */
    Product update(Long id, Product product);

    // PUBLIC_INTERFACE
    /**
     * Delete product by id.
     * @param id product id.
     */
    void delete(Long id);
}
