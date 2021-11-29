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