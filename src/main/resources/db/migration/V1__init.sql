-- CREATE DATABASE weather;

CREATE TABLE temperature_data
(
    id                SERIAL PRIMARY KEY,
    temperature_value NUMERIC(10, 1),
    created_at        TIMESTAMP
);

CREATE TABLE light_data
(
    id          SERIAL PRIMARY KEY,
    light_value NUMERIC(10, 1),
    created_at  TIMESTAMP
);

CREATE TABLE hum_data
(
    id         SERIAL PRIMARY KEY,
    hum_value  NUMERIC(10, 1),
    created_at TIMESTAMP
);