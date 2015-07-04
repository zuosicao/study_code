
CREATE DATABASE IF NOT EXISTS spring ;

USE spring;
CREATE TABLE IF NOT EXISTS students
(
stu_id INT PRIMARY KEY AUTO_INCREMENT,
stu_num INT NOT NULL,
stu_name VARCHAR(15),
stu_sex VARCHAR(2),
stu_age INT
);

INSERT INTO students values (null,1101,'RuanCong','M',22);