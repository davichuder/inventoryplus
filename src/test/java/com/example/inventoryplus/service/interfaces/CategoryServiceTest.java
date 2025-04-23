package com.example.inventoryplus.service.interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.inventoryplus.persistence.entity.Category;
import com.example.inventoryplus.persistence.repository.CategoryRepository;
import com.example.inventoryplus.service.impl.CategoryServiceImpl;

class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCategory() {
        // Arrange
        Category categoryToSave = Category.builder().name("Test Category").description("Test Description").build();
        Category savedCategory = Category.builder().id(1L).name("Test Category").description("Test Description").build();
        when(categoryRepository.save(categoryToSave)).thenReturn(savedCategory);

        // Act
        Category result = categoryService.saveCategory(categoryToSave);

        // Assert
        assertEquals(savedCategory, result);
        verify(categoryRepository, times(1)).save(categoryToSave);
    }

    @Test
    void testFindCategoryByName_ExistingName() {
        // Arrange
        String categoryName = "Test Category";
        Category foundCategory = Category.builder().id(1L).name(categoryName).description("Test Description").build();
        when(categoryRepository.findByName(categoryName)).thenReturn(Optional.of(foundCategory));

        // Act
        Optional<Category> result = categoryService.findCategoryByName(categoryName);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(foundCategory, result.get());
        verify(categoryRepository, times(1)).findByName(categoryName);
    }

    @Test
    void testFindCategoryByName_NonExistingName() {
        // Arrange
        String categoryName = "Non Existing Category";
        when(categoryRepository.findByName(categoryName)).thenReturn(Optional.empty());

        // Act
        Optional<Category> result = categoryService.findCategoryByName(categoryName);

        // Assert
        assertFalse(result.isPresent());
        verify(categoryRepository, times(1)).findByName(categoryName);
    }
}

