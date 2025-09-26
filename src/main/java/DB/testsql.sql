CREATE DATABASE IF NOT EXISTS esunbank;
USE esunbank;

DROP TABLE IF EXISTS like_list;               -- 喜好清單
DROP TABLE IF EXISTS product;                 -- 產品資料
DROP TABLE IF EXISTS users;                   -- 使用者

-- 使用者
CREATE TABLE users (
    user_id       VARCHAR(50) PRIMARY KEY,
    user_name     VARCHAR(100) NOT NULL,
    email         VARCHAR(100) UNIQUE NOT NULL,
    debit_account VARCHAR(50) NOT NULL
);

INSERT INTO users (user_id, user_name, email, debit_account) VALUES
('U001', '陳艾利', 'alice@example.com', '0000000000'),
('U002', '林伯駿', 'bob@example.com',   '0000000001');


-- 產品資料
CREATE TABLE product (
    product_id   INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    price        DECIMAL(10,2) NOT NULL,
    fee_rate     DECIMAL(5,4) NOT NULL
);

INSERT INTO product (product_name, price, fee_rate) VALUES
('基金A', 1000.00, 0.015),
('基金B', 2500.00, 0.020),
('債券C', 500.00,  0.010);


-- 喜好清單
CREATE TABLE like_list (
    sn           INT AUTO_INCREMENT PRIMARY KEY,
    user_id      VARCHAR(50) NOT NULL,
    product_id   INT NOT NULL,
    quantity     INT NOT NULL,
    debit_account      VARCHAR(50) NOT NULL,
    total_fee    DECIMAL(12,2) NOT NULL,
    total_amount DECIMAL(12,2) NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product(product_id)
);


INSERT INTO like_list (user_id, product_id, quantity, debit_account, total_fee, total_amount)VALUES 
('U001', 1, 2, 'ACCT1001', 1000.00*2*0.015, 1000.00*2),-- Alice 買 基金A 2份
('U002', 2, 1, 'ACCT1002', 2500.00*1*0.020, 2500.00*1);-- Bob 買 基金B 1份


