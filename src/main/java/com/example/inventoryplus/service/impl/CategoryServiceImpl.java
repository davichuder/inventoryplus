package com.example.inventoryplus.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.inventoryplus.persistence.entity.Category;
import com.example.inventoryplus.persistence.repository.CategoryRepository;
import com.example.inventoryplus.service.interfaces.CategoryService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }
    
}
