CREATE TABLE IF NOT EXISTS categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

INSERT INTO categories (name, description) VALUES
('Electronics', 'Electronic items'),
('Clothing', 'Clothing items'),
('Books', 'Book items');