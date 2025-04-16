package com.example.inventoryplus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomAssertions {

    /**
     * Validate that the class has exactly the expected fields with their corresponding types.
     *
     * @param clazz          The class we want to validate.
     * @param expectedFields A map with expected attribute names and their types.
     */
    public static void assertClassHasFields(Class<?> clazz, Map<String, Class<?>> expectedFields) {
        Set<String> fieldNames = Arrays.stream(clazz.getDeclaredFields())
                                       .map(Field::getName)
                                       .collect(Collectors.toSet());

        assertEquals(expectedFields.size(), fieldNames.size(),
            "The number of fields in " + clazz.getSimpleName() + " is not the expected");

        for (Map.Entry<String, Class<?>> expected : expectedFields.entrySet()) {
            String fieldName = expected.getKey();
            Class<?> expectedType = expected.getValue();

            assertTrue(fieldNames.contains(fieldName),
                "The field " + fieldName + " was not found in " + clazz.getSimpleName());

            try {
                Field field = clazz.getDeclaredField(fieldName);
                assertEquals(expectedType, field.getType(),
                    "Expected type for field " + fieldName + " is " + expectedType.getSimpleName() +
                    ", but found " + field.getType().getSimpleName());
            } catch (NoSuchFieldException e) {
                throw new AssertionError("Error accessing field: " + fieldName, e);
            }
        }
    }
}
