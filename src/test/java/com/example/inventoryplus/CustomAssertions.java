package com.example.inventoryplus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomAssertions {

    /**
     * Validate that the class has exactly the expected fields with their
     * corresponding types.
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
                assertNotNull(e, "Could not access field " + fieldName + " in " + clazz.getSimpleName());
            }
        }
    }

    /**
     * Validate that the enum contains exactly the expected values.
     *
     * @param enumClass      The enum class to validate.
     * @param expectedValues A set of expected enum value names.
     */

    public static <E extends Enum<E>> void assertEnumHasValues(Class<E> enumClass, Set<String> expectedValues) {
        Set<String> enumValues = Arrays.stream(enumClass.getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toSet());

        assertEquals(expectedValues.size(), enumValues.size(),
                "Unexpected number of values in " + enumClass.getSimpleName());

        expectedValues.forEach(expectedValue -> assertTrue(enumValues.contains(expectedValue),
                "Missing value: " + expectedValue + " in " + enumClass.getSimpleName()));
    }

    /**
     * Validate that the enum has fields with expected values, reporting all errors
     * at the end.
     *
     * @param enumClass      The enum class to validate.
     * @param expectedValues A map where each key is an enum name, and the value is
     *                       a map of field names to expected values.
     * @param <E>            The type of the enum.
     */
    public static <E extends Enum<E>> void assertEnumHasFields(Class<E> enumClass,
            Map<String, Map<String, Object>> expectedValues) {
        Set<String> enumNames = Arrays.stream(enumClass.getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toSet());

        assertEquals(expectedValues.size(), enumNames.size(),
                "Unexpected number of enums in " + enumClass.getSimpleName() + ". Expected: " + expectedValues.size()
                        + ", Actual: " + enumNames.size());

        for (Map.Entry<String, Map<String, Object>> entry : expectedValues.entrySet()) {
            String enumName = entry.getKey();
            Map<String, Object> expectedFields = entry.getValue();

            if (!enumNames.contains(enumName)) {
                assertTrue(enumNames.contains(enumName),
                        "Missing enum: " + enumName + " in " + enumClass.getSimpleName());
                continue;
            }

            E enumInstance = Enum.valueOf(enumClass, enumName);

            expectedFields.forEach((fieldName, expectedValue) -> {
                try {
                    Field field = enumClass.getDeclaredField(fieldName);
                    field.setAccessible(true);

                    Object actualValue = field.get(enumInstance);

                    assertEquals(expectedValue, actualValue,
                            "Error in " + enumName + ": expected " + expectedValue + " in " + fieldName + ", but found "
                                    + actualValue);

                } catch (NoSuchFieldException | IllegalAccessException e) {
                    fail("Could not access field " + fieldName + " in " + enumClass.getSimpleName());
                }
            });
        }
    }
}
