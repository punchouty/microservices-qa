#!/usr/bin/env bash
psql "postgres://$POSTGRES_USER:$POSTGRES_PASSWORD@$POSTGRES_HOST/$POSTGRES_DB?sslmode=disable" <<-EOSQL
-- SQL Statements
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS location;

CREATE TABLE brand (
    id INT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE location (
    id INT GENERATED ALWAYS AS IDENTITY,
    brand_id INT,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_brand
        FOREIGN KEY(brand_id)
            REFERENCES brand(id)
            ON DELETE SET NULL
);
INSERT INTO brand (name, code) VALUES ('Facebook', 'FB');
INSERT INTO brand (name, code) VALUES ('Google', 'GOO');
INSERT INTO brand (name, code) VALUES ('Apple', 'APL');
INSERT INTO brand (name, code) VALUES ('Microsoft', 'MSFT');

INSERT INTO location(brand_id, name, city)
VALUES(1,'J P Nagar','Bangalore'),
      (1,'White Fields','Bangalore'),
      (2,'Faridabad','Delhi'),
      (2,'Noida','Delhi'),
      (3,'Gurgaon','Delhi'),
      (4,'Banjara Hills','Hyderabad'),
      (4,'Jubilee Hills','Hyderabad');
EOSQL