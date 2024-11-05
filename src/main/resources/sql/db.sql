CREATE EXTENSION IF NOT EXISTS pgcrypto;

DROP TABLE IF EXISTS Order_Items;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Roles;
DROP TABLE IF EXISTS Product_Platforms;
DROP TABLE IF EXISTS Platforms;
DROP TABLE IF EXISTS Products;

CREATE TABLE Roles (
    role_id BIGINT PRIMARY KEY,
    role_name VARCHAR(15) NOT NULL
);

CREATE TABLE Users (
    user_id BIGINT PRIMARY KEY,
    username VARCHAR(40) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    last_login TIMESTAMP NOT NULL,
    role_id BIGINT REFERENCES Roles(role_id)
);

CREATE TABLE Products (
    product_id BIGINT PRIMARY KEY,
    title VARCHAR(40) NOT NULL,
    price DECIMAL NOT NULL,
    stock_quantity INT NOT NULL,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE Platforms (
    platform_id BIGINT PRIMARY KEY,
    name VARCHAR(40) NOT NULL
);

CREATE TABLE Product_Platforms (
    product_id BIGINT REFERENCES Products(product_id),
    platform_id BIGINT REFERENCES Platforms(platform_id)
);

CREATE TABLE Orders (
    order_id BIGINT PRIMARY KEY,
    user_id BIGINT REFERENCES Users(user_id),
    total_amount DECIMAL NOT NULL,
    order_date TIMESTAMP NOT NULL,
    status VARCHAR(40) NOT NULL     -- Could be converted to a status ID with a join table later
);

CREATE TABLE Order_Items (
    order_item_id BIGINT PRIMARY KEY,
    order_id BIGINT REFERENCES Orders(order_id),
    product_id BIGINT REFERENCES Products(product_id),
    quantity INT NOT NULL
);