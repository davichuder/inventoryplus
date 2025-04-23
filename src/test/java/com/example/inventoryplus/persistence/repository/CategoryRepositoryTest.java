package com.example.inventoryplus.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.inventoryplus.persistence.MySQLTestContainer;
import com.example.inventoryplus.persistence.entity.Category;

@SpringBootTest
@ActiveProfiles("test")
class CategoryRepositoryTest extends MySQLTestContainer {
    @Autowired
    CategoryRepository categoryRepository;

    @BeforeAll
    static void beforeAll() {
        startContainer();
    }

    @AfterAll
    static void afterAll() {
        stopContainer();
    }

    @BeforeEach
    void setUp() {
        categoryRepository.deleteAll();
    }

    @Test
    void testSaveAndFindByName() {
        String name = "Electronics";
        String description = "Electronic items";

        Category category = Category.builder()
                .name(name)
                .description(description)
                .build();

        categoryRepository.save(category);

        Optional<Category> found = categoryRepository.findById(category.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo(name);
        assertThat(found.get().getDescription()).isEqualTo(description);
    }
}