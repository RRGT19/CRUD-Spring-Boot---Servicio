DROP TABLE IF EXISTS students;

CREATE TABLE students (
  id            INTEGER AUTO_INCREMENT PRIMARY KEY,
  code          VARCHAR(8) NOT NULL,
  first_name    VARCHAR(15) NOT NULL,
  last_name     VARCHAR(15) NOT NULL,
  phone         VARCHAR(10)
);