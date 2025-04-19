package com.example.inventoryplus.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

import com.example.inventoryplus.persistence.entity.Category;

@SpringBootTest
class CategoryRepositoryTest {
    static MySQLContainer<?> mySql = new MySQLContainer<>("mysql:8.4.5");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySql::getJdbcUrl);
        registry.add("spring.datasource.username", mySql::getUsername);
        registry.add("spring.datasource.password", mySql::getPassword);
        registry.add("spring.jpa.database-platform", () -> "org.hibernate.dialect.MySQLDialect");
    }

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeAll
    static void beforeAll() {
        mySql.start();
    }

    @AfterAll
    static void afterAll() {
        mySql.stop();
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