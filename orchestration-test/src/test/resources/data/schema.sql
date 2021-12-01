DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS employee;

CREATE TABLE brand (
   id INT GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(255) NOT NULL,
   code VARCHAR(255) NOT NULL,
   PRIMARY KEY(id)
);
CREATE TABLE location (
  id INT GENERATED ALWAYS AS IDENTITY,
  company_code VARCHAR(255),
  name VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
);
CREATE TABLE employee (
  id INT GENERATED ALWAYS AS IDENTITY,
  name VARCHAR(255) NOT NULL,
  company_code VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
);