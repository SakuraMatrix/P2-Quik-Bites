CREATE  KEYSPACE_IT_NOT_EXISTS customers with replication={'class': 'SimpleStrategy', 'replication_factor':1}

user customers

CREATE TABLE IF NOT EXISTS customer_table(
customerId int,
customerName text,
customerAddress text,
phoneNumber text,
PRIMARY KEY(Id, phoneNumber),

);