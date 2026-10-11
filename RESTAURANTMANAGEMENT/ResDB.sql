CREATE DATABASE IF NOT EXISTS restaurantmanagement;
USE restaurantmanagement;

CREATE TABLE IF NOT EXISTS employee (
    empID INT PRIMARY KEY,
    empName VARCHAR(100) NOT NULL,
    empAge INT NOT NULL,
    empDesignation VARCHAR(30) NOT NULL,
    empGender CHAR(1) NOT NULL,
    empSal INT NOT NULL,
    empEmail VARCHAR(100) NOT NULL,
    empBranch VARCHAR(3) NOT NULL
);

CREATE TABLE IF NOT EXISTS menu (
    DishID INT NOT NULL,
    DishName VARCHAR(100) NOT NULL,
    Price INT NOT NULL,
    FoodType VARCHAR(30) NOT NULL,
    Branch VARCHAR(3) NOT NULL,
    PRIMARY KEY (Branch, DishID),
    UNIQUE KEY uq_menu_branch_dish (Branch, DishName)
);

CREATE TABLE IF NOT EXISTS seating (
    Branch VARCHAR(3) PRIMARY KEY,
    Seats3 INT NOT NULL DEFAULT 0,
    seats5 INT NOT NULL DEFAULT 0,
    Seats10 INT NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS orders (
    ID INT NOT NULL,
    Item VARCHAR(100) NOT NULL,
    Qty INT NOT NULL,
    Stat CHAR(1) NOT NULL DEFAULT 'p',
    PRIMARY KEY (ID, Item)
);

CREATE TABLE IF NOT EXISTS reservation (
    ID INT PRIMARY KEY,
    custName VARCHAR(100) NOT NULL,
    Branch VARCHAR(3) NOT NULL,
    `Count` INT NOT NULL,
    TimeSlot TIME NOT NULL,
    TimeIn TIME NULL,
    Stat CHAR(1) NOT NULL DEFAULT 'r',
    tcat INT NOT NULL
);

INSERT IGNORE INTO seating(Branch, Seats3, seats5, Seats10) VALUES
    ('Hyd', 15, 10, 2),
    ('Blr', 12, 8, 2),
    ('Chn', 10, 6, 2);