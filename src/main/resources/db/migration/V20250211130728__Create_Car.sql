CREATE TABLE TB_CAR (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    price VARCHAR(255) NOT NULL,
    battery VARCHAR(255),
    power VARCHAR(255),
    charge VARCHAR(255),
    urlPhoto VARCHAR(255) NOT NULL UNIQUE
);