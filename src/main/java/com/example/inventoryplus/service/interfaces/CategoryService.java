package com.example.inventoryplus.service.interfaces;

import java.util.Optional;

import com.example.inventoryplus.persistence.entity.Category;

public interface CategoryService {
    Category saveCategory(Category category);

    Optional<Category> findCategoryByName(String name);
}
