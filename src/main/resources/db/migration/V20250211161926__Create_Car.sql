CREATE TABLE TB_CAR (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    price DECIMAL(19, 2) NOT NULL,
    battery DECIMAL(19, 2),
    power DECIMAL(19, 2),
    charge DECIMAL(19, 2),
    urlPhoto VARCHAR(255) NOT NULL UNIQUE
);