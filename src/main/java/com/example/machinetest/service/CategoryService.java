package com.example.machinetest.service;

import com.example.machinetest.entity.Category;
import com.example.machinetest.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public Page<Category> getAllCategory(Pageable pageable){
        return categoryRepo.findAll(pageable);
    }
    public Category getCategoryBYId(Long id){
        return categoryRepo.findById(id).orElseThrow(()->new RuntimeException("Category not Found"));
    }

    public Category updateCategory(Long id, Category category){
        Category existingCategory = getCategoryBYId(id);
        existingCategory.setName(category.getName());
        return categoryRepo.save(existingCategory);
    }
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    public void deleteCategory(Long id){
        categoryRepo.deleteById(id);
    }
}
