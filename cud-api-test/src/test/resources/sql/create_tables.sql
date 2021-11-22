CREATE TABLE IF NOT EXISTS brand
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT brand_pkey PRIMARY KEY (id),
    CONSTRAINT unique_name UNIQUE (name)
    )
    WITH (
        OIDS = FALSE
        )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS brand
    OWNER to postgres;