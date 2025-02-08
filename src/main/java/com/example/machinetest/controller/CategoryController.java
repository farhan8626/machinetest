package com.example.machinetest.controller;

import com.example.machinetest.entity.Category;
import com.example.machinetest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


//    http://localhost:8080/api/categories?page=3       GET all the categories
    @GetMapping
    public Page<Category> getAllCategory(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page,size);
        return categoryService.getAllCategory(pageable);
    }



//    http://localhost:8080/api/categories/{di}  GET category by Id
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryBYId(id);

    }


//    http://localhost:8080/api/categories   POST - create a new category
    @PostMapping
    public Category createCategory(@RequestBody Category category){

        return categoryService.createCategory(category);
    }


//    http://localhost:8080/api/categories/{di}   PUT - update category by id
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category){
        return categoryService.updateCategory(id, category);

    }


//
//  http://localhost:8080/api/categories/{di}   DELETE - Delete category by id
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
