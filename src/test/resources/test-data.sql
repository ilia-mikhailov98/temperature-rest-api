-- TODO: instead of copy-paste start using liquibase

CREATE TABLE IF NOT EXISTS sensor (
    id INT PRIMARY KEY,
    name VARCHAR(30) NOT NULL CHECK (LENGTH(name) >= 3 AND LENGTH(name) <= 30)
);

CREATE TABLE IF NOT EXISTS measurement (
    id INT PRIMARY KEY,
    "value" DOUBLE PRECISION NOT NULL,
    raining BOOLEAN NOT NULL,
    date TIMESTAMP NOT NULL,
    sensor_id INT,
    FOREIGN KEY (sensor_id) REFERENCES sensor(id) ON DELETE SET NULL
);
