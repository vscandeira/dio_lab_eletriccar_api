--CREATE DATABASE cardb;
--\c cardb; -- Conecta ao banco de dados cardb

--CREATE USER carapp WITH PASSWORD 'secret';
--GRANT ALL PRIVILEGES ON DATABASE cardb TO carapp;
--GRANT ALL PRIVILEGES ON SCHEMA public TO carapp;

CREATE SCHEMA eletriccar AUTHORIZATION carapp;
GRANT ALL PRIVILEGES ON SCHEMA eletriccar TO carapp;
SET search_path = eletriccar;

CREATE TABLE TB_CAR (
    id BIGSERIAL PRIMARY KEY,
    price NUMERIC(19, 2) NOT NULL,
    battery NUMERIC(19, 2),
    power NUMERIC(19, 2),
    charge NUMERIC(19, 2),
    urlPhoto VARCHAR(255) NOT NULL UNIQUE
);