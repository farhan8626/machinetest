package com.example.machinetest.service;

import com.example.machinetest.entity.Product;
import com.example.machinetest.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public Page<Product> getAllProducts(Pageable pageable){
        return productRepo.findAll(pageable);
    }

    public Product getProductById(Long id){
        return productRepo.findById(id).orElseThrow(()-> new RuntimeException("Products not found"));
    }

    public Product createProduct(Product product){
        return productRepo.save(product);

    }

    public Product updateProduct(Long id, Product product){
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        return productRepo.save(existingProduct);
    }

    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }
}
