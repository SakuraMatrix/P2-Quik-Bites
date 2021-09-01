CREATE KEYSPACE IF NOT EXISTS quikeats WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE IF NOT EXISTS quikeats.orders (
    orderId int PRIMARY KEY,
    customerId int,
    driverId int,
    resturantId int,
    total double,
    orderStatus text,
    orderItems map<int, int>
);