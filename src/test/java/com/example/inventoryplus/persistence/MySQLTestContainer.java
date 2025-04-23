package com.example.inventoryplus.persistence;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

public abstract class MySQLTestContainer {
    protected static final MySQLContainer<?> mySql = new MySQLContainer<>("mysql:8.4.5");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mySql::getJdbcUrl);
        registry.add("spring.datasource.username", mySql::getUsername);
        registry.add("spring.datasource.password", mySql::getPassword);
        registry.add("spring.jpa.database-platform", () -> "org.hibernate.dialect.MySQLDialect");
    }
    
    protected static void startContainer() {
        mySql.start();
    }

    protected static void stopContainer() {
        mySql.stop();
    }
}
