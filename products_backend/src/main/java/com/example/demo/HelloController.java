package com.example.productsbackend.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Basic utility endpoints for health and docs redirection.
 */
@RestController
@Tag(name = "Utility", description = "Basic endpoints for productsbackend")
public class HelloController {
    // PUBLIC_INTERFACE
    /**
     * Welcome endpoint.
     * @return welcome message.
     */
    @GetMapping("/")
    @Operation(summary = "Welcome endpoint", description = "Returns a welcome message")
    public String hello() {
        return "Hello, Spring Boot! Welcome to productsbackend";
    }

    // PUBLIC_INTERFACE
    /**
     * Swagger UI redirect.
     * @return redirect view.
     */
    @GetMapping("/docs")
    @Operation(summary = "API Documentation", description = "Redirects to Swagger UI")
    public RedirectView docs() {
        return new RedirectView("/swagger-ui.html");
    }

    // PUBLIC_INTERFACE
    /**
     * Health check endpoint.
     * @return OK string.
     */
    @GetMapping("/health")
    @Operation(summary = "Health check", description = "Returns application health status")
    public String health() {
        return "OK";
    }

    // PUBLIC_INTERFACE
    /**
     * Application info endpoint.
     * @return info string.
     */
    @GetMapping("/api/info")
    @Operation(summary = "Application info", description = "Returns application information")
    public String info() {
        return "Spring Boot Application: productsbackend";
    }
}