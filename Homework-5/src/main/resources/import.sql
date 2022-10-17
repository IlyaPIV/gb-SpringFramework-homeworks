DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS customers CASCADE;
DROP TABLE IF EXISTS customers_products;

CREATE TABLE IF NOT EXISTS products (id bigserial PRIMARY KEY, title VARCHAR(255), cost FLOAT);
INSERT INTO products (title, cost) VALUES ( 'InMemory Product', 111.11 );
INSERT INTO products (title, cost) VALUES ( 'Second Product', 99.99 );
INSERT INTO products (title, cost) VALUES ('Milk', 07.14);
INSERT INTO products (title, cost) VALUES ('Bread', 9.99);
INSERT INTO products (title, cost) VALUES ('Toilet paper', 5.55);

CREATE TABLE IF NOT EXISTS customers(id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES ( 'Vasia');
INSERT INTO customers (name) VALUES ('Petia');
INSERT INTO customers (name) VALUES ( 'Galia');

CREATE TABLE IF NOT EXISTS customers_products(customer_id bigint, product_id bigint, foreign key (product_id) references products (id), foreign key (customer_id) references customers (id));
INSERT INTO customers_products (customer_id, product_id) VALUES (1, 2);
INSERT INTO customers_products (customer_id, product_id) VALUES (1, 3);
INSERT INTO customers_products (customer_id, product_id) VALUES (1, 4);
INSERT INTO customers_products (customer_id, product_id) VALUES (2, 2);
INSERT INTO customers_products (customer_id, product_id) VALUES (2, 3);
INSERT INTO customers_products (customer_id, product_id) VALUES (3, 3);
INSERT INTO customers_products (customer_id, product_id) VALUES (3, 5);