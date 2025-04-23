package com.example.inventoryplus.util.context;

import java.util.Map;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.example.inventoryplus.persistence.entity.Category;
import com.example.inventoryplus.service.interfaces.CategoryService;

import lombok.RequiredArgsConstructor;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class DevInitializer implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryService categoryService;

    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        Map<String, String> categories = Map.of(
            "Electronics", "Devices and gadgets",
            "Clothing", "Apparel and accessories",
            "Books", "Literature and educational materials",
            "Home & Kitchen", "Household items and kitchenware",
            "Sports & Outdoors", "Sporting goods and outdoor equipment"
        );
        for (Map.Entry<String, String> entry : categories.entrySet()) {
            String name = entry.getKey();
            String description = entry.getValue();
            Optional<Category> category = categoryService.findCategoryByName(name);
            if (category.isEmpty()) {
                Category newCategory = Category.builder()
                    .name(name)
                    .description(description)
                    .build();
                categoryService.saveCategory(newCategory);
            }
        }
    }
}
