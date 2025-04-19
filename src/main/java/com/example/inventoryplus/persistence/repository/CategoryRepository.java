package com.example.inventoryplus.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventoryplus.persistence.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
