CREATE TABLE curstom
(
curstom_id INT PRIMARY KEY auto_increment,
name VARCHAR(20),
sex VARCHAR(10),
age INT
);

UPDATE curstom SET age = 22;
INSERT INTO curstom (name,sex) values ('ruancong','male');
INSERT INTO curstom (name,sex) values ('c2','female');