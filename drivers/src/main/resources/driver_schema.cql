CREATE KEYSPACE IF NOT EXISTS drivers WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE drivers;

CREATE TABLE IF NOT EXISTS driverstable (
    driver_id int,
    driver_name text,
    PRIMARY KEY (driver_id, driver_name)
);