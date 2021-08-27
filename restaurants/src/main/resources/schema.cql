CREATE KEYSPACE IF NOT EXISTS Food_Delivery WITH replication=
{'class': 'SimpleStrategy','replication_factor':1};
use Food_Delivery;
CREATE TABLE IF NOT EXISTS restaurants(
restaurantId int,
name text,
location text,
PRIMARY KEY(restaurantId, name)
);

CREATE TABLE menu(
menuId int,
name text,
price,
PRIMARY KEY(menuId, name)
);
