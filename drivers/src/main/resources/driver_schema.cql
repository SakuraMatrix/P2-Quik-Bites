CREATE KEYSPACE drivers WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE drivers;

CREATE TABLE driverstable (
    driver_id int,
    driver_name text,
    location text,
    cust_location text,
    rest_location text,
    PRIMARY KEY (driver_id, driver_name)
);