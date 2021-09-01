CREATE KEYSPACE IF NOT EXISTS restaurants WITH replication=
{'class': 'SimpleStrategy','replication_factor':1};
use restaurant;
CREATE TABLE IF NOT EXISTS restaurants(
restaurantId int,
name text,
location text,
PRIMARY KEY(restaurantId, name)
);

CREATE TABLE menu(
menuId int,
resId int,
price double,
name text,
PRIMARY KEY(menuId, resId)
);

