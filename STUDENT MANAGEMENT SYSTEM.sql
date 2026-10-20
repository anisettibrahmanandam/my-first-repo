CREATE DATABASE studentdb;
USE studentdb;
CREATE TABLE students(
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(100),
    course VARCHAR(50),
    attendance DECIMAL(5,2),
    marks INT
);
INSERT INTO students(student_name,course,attendance,marks)
VALUES
('Ravi','Java',90.5,85),
('Sita','Python',95.0,92),
('Kiran','JDBC',88.0,78);
USE studentdb;
SELECT*FROM students;+
