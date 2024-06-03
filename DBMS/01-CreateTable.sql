CREATE DATABASE EmployeeDB;
SHOW DATABASES;
USE EmployeeDB;

CREATE TABLE Employee (
    EmployeeID INT NOT NULL PRIMARY KEY,
    EmployeeName VARCHAR(50),
    EmployeeSalary INT,
    EmployeeDOB DATE
);

CREATE TABLE BONUS (
    BonusID INT NOT NULL PRIMARY KEY,
    BonusAmount INT,
    EmployeeID INT,
    FOREIGN KEY (EmployeeID) 
        REFERENCES Employee(EmployeeID)     
        ON DELETE CASCADE -- This will delete the record from BONUS table if the record from Employee table is deleted
);

INSERT INTO Employee (EmployeeID, EmployeeName, EmployeeSalary, EmployeeDOB) VALUES 
    (1, 'John Doe', 50000, '1990-01-01'),
    (2, 'Jane Doe', 60000, '1991-01-01'),
    (3, 'John Smith', 70000, '1992-01-01');

INSERT INTO BONUS (BonusID, BonusAmount, EmployeeID) VALUES 
    (1, 5000, 1),
    (2, 6000, 2),
    (3, 7000, 3);