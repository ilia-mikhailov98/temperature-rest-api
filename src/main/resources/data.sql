CREATE TABLE IF NOT EXISTS sensor
(
    id
    SERIAL
    PRIMARY
    KEY,
    name
    VARCHAR
(
    30
) NOT NULL CHECK
(
    LENGTH
(
    name
) >= 3 AND LENGTH
(
    name
) <= 30)
    );

CREATE TABLE IF NOT EXISTS measurement
(
    id
    SERIAL
    PRIMARY
    KEY,
    value
    DOUBLE
    PRECISION
    NOT
    NULL,
    raining
    BOOLEAN
    NOT
    NULL,
    date
    TIMESTAMP
    NOT
    NULL,
    sensor_id
    INT,
    FOREIGN
    KEY
(
    sensor_id
) REFERENCES sensor
(
    id
) ON DELETE SET NULL
    );