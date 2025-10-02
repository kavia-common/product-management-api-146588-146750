package com.example.productsbackend.web;

import com.example.productsbackend.model.Product;
import com.example.productsbackend.service.ProductService;
import com.example.productsbackend.web.error.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * REST controller exposing CRUD operations for products.
 */
@RestController
@RequestMapping("/api/products")
@Tag(name = "Products", description = "CRUD operations for products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // PUBLIC_INTERFACE
    /**
     * Create a product.
     * @param product product payload.
     * @return Created product with location header.
     */
    @PostMapping
    @Operation(
            summary = "Create product",
            description = "Creates a new product with name, price, and quantity.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created",
                            content = @Content(schema = @Schema(implementation = Product.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid payload", content = @Content)
            }
    )
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        Product created = service.create(product);
        return ResponseEntity.created(URI.create("/api/products/" + created.getId())).body(created);
    }

    // PUBLIC_INTERFACE
    /**
     * List all products.
     * @return list of products.
     */
    @GetMapping
    @Operation(summary = "List products", description = "Returns all products.")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // PUBLIC_INTERFACE
    /**
     * Get a product by id.
     * @param id product id
     * @return product
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Get product by id",
            description = "Returns a product if found.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = Product.class))),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            }
    )
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
    }

    // PUBLIC_INTERFACE
    /**
     * Update a product by id.
     * @param id product id to update
     * @param product new payload
     * @return updated product
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Update product",
            description = "Updates name, price, and quantity of an existing product.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Updated",
                            content = @Content(schema = @Schema(implementation = Product.class))),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Invalid payload", content = @Content)
            }
    )
    public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product) {
        Product updated = service.update(id, product);
        return ResponseEntity.ok(updated);
    }

    // PUBLIC_INTERFACE
    /**
     * Delete a product by id.
     * @param id product id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete product",
            description = "Deletes a product by id.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "No Content"),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            }
    )
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
