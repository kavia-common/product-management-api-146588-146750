package com.example.productsbackend.service.impl;

import com.example.productsbackend.model.Product;
import com.example.productsbackend.repository.ProductRepository;
import com.example.productsbackend.service.ProductService;
import com.example.productsbackend.web.error.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of ProductService using JPA repository.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product create(Product product) {
        product.setId(null);
        return repository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Product update(Long id, Product updates) {
        Product existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        existing.setName(updates.getName());
        existing.setPrice(updates.getPrice());
        existing.setQuantity(updates.getQuantity());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }
        repository.deleteById(id);
    }
}
