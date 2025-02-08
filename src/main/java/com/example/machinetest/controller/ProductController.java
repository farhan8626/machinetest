package com.example.machinetest.controller;

import com.example.machinetest.entity.Product;
import com.example.machinetest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;

//    http://localhost:8080/api/products?page=2     GET all the products
    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "5") int size
                                        ){
        Pageable pageable = PageRequest.of(page,size);
        return productService.getAllProducts(pageable);

    }


//
//  http://localhost:8080/api/products/{di}         GET product by Id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

//    http://localhost:8080/api/products            POST - create a new product
    @PostMapping
    public Product createProducts(@RequestBody Product product){
        return productService.createProduct(product);

    }


//    http://localhost:8080/api/products/{di}            PUT - update product by id
    @PutMapping("/{id}")
    public Product updateProducts(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }


//    http://localhost:8080/api/products/{di}       //DELETE - Delete product by id
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
