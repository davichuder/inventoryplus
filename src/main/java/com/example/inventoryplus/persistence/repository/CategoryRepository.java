package com.example.inventoryplus.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.inventoryplus.persistence.entity.Category;

import io.swagger.v3.oas.annotations.tags.Tag;

@RepositoryRestResource(path = "categories")
@Tag(name = "Categorías")
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Optional<Category> findByName(String name);
}
