CREATE  KEYSPACE IF NOT EXISTS customers with replication={'class': 'SimpleStrategy', 'replication_factor':1};

USE customers

CREATE TABLE IF NOT EXISTS customer_table(
customerId int,
customerName text,
customerAddress text,
phoneNumber text,
PRIMARY KEY(customerId),

);