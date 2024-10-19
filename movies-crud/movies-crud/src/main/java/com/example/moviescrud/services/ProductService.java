package com.example.moviescrud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.example.moviescrud.entities.ProductEntity;

@Service
public class ProductService {
    private final List<ProductEntity> productList = new ArrayList<>();

    public ProductService() {
        // Inicializa la lista con algunos productos de ejemplo.
        productList.add(new ProductEntity("Laptop", "Electrónica", 1000.00, 50));
        productList.add(new ProductEntity("Silla", "Muebles", 150.00, 30));
        productList.add(new ProductEntity("Cámara", "Fotografía", 500.00, 15));
        productList.add(new ProductEntity("Smartphone", "Electrónica", 800.00, 100));
        productList.add(new ProductEntity("Mesa de comedor", "Muebles", 250.00, 20));
        productList.add(new ProductEntity("Impresora", "Oficina", 200.00, 40));
        productList.add(new ProductEntity("Audífonos", "Electrónica", 100.00, 150));
        productList.add(new ProductEntity("Televisor", "Electrónica", 1200.00, 25));
        productList.add(new ProductEntity("Sofá", "Muebles", 550.00, 10));
        productList.add(new ProductEntity("Lámpara de pie", "Iluminación", 75.00, 60));
        productList.add(new ProductEntity("Monitor", "Electrónica", 300.00, 45));
        productList.add(new ProductEntity("Cafetera", "Cocina", 80.00, 70));
        productList.add(new ProductEntity("Microondas", "Cocina", 150.00, 35));
        productList.add(new ProductEntity("Cámara de video", "Fotografía", 1200.00, 12));
    }

    // Obtener todos los productos.
    public List<ProductEntity> getAllProducts() {
        return productList;
    }

    // Obtener un producto por su ID.
    public Optional<ProductEntity> getProductById(UUID id) {
        return productList.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    // Crear un nuevo producto.
    public ProductEntity createProduct(ProductEntity product) {
        product.setId(UUID.randomUUID()); // Genera un nuevo UUID para el producto.
        productList.add(product);
        return product;
    }

    // Actualizar un producto existente.
    public ProductEntity updateProduct(UUID id, ProductEntity updatedProduct) {
        Optional<ProductEntity> existingProduct = getProductById(id);
        if (existingProduct.isPresent()) {
            ProductEntity product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setCategory(updatedProduct.getCategory());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            return product;
        }
        return null;
    }

    // Eliminar un producto por su ID.
    public boolean deleteProduct(UUID id) {
        return productList.removeIf(product -> product.getId().equals(id));
    }
}
