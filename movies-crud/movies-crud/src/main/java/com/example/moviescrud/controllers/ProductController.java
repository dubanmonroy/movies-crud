package com.example.moviescrud.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.example.moviescrud.entities.ProductEntity;
import com.example.moviescrud.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Obtener todos los productos
    @GetMapping
    public List<ProductEntity> getProducts() {
        return productService.getAllProducts();
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public Optional<ProductEntity> getProduct(@PathVariable UUID id) {
        return productService.getProductById(id);
    }

    // Crear un nuevo producto
    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity product) {
        return productService.createProduct(product);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ProductEntity updateProduct(@PathVariable UUID id, @RequestBody ProductEntity updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    // Eliminar un producto por su ID
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }
}
