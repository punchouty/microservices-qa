#!/usr/bin/env bash
psql "postgres://$POSTGRES_USER:$POSTGRES_PASSWORD@$POSTGRES_HOST/$POSTGRES_DB?sslmode=disable" <<-EOSQL
-- SQL Statements
CREATE TABLE brand (
     id   INTEGER      NOT NULL AUTO_INCREMENT,
     name VARCHAR(255) NOT NULL,
     code VARCHAR(255) NOT NULL,
     PRIMARY KEY (id)
);
INSERT INTO brand (name, code) VALUES ('Facebook', 'FB');
INSERT INTO brand (name, code) VALUES ('Google', 'GOO');
INSERT INTO brand (name, code) VALUES ('Apple', 'APL');
INSERT INTO brand (name, code) VALUES ('Microsoft', 'MSFT');
EOSQL