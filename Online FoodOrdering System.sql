CREATE DATABASE food_ordering;
USE food_ordering;

CREATE TABLE customers(
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    address VARCHAR(200)
);
INSERT INTO customers(customer_name,phone,address)
VALUES
('Brahmanandam','9676423181','Polavaram'),
('Nagu','8008083710','Rajahmundry');

SELECT * FROM customers;

CREATE TABLE menu(
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(100),
    price DECIMAL(10,2)
);
INSERT INTO menu(item_name,price)
VALUES
('chicken Biryani',250.00),
('Veg Biryani',180.00),
('Fried Rice',150.00),
('Pizza',300.00),
('Burger',120.00);
SELECT * FROM menu;
CREATE TABLE orders(
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10,2),
    FOREIGN KEY (customer_id)
    REFERENCES
    customers(customer_id)
);
CREATE TABLE order_items(
    order_item_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    item_id INT,
    quantity INT,
    subtotal DECIMAL(10,2),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY(item_id) REFERENCES menu (item_id)
);
SHOW TABLES;
use food_ordering;
select*from orders;
select*from customers;
desc menu;
select*from menu;
Describe orders;
desc order_items;
