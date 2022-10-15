DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), cost FLOAT, PRIMARY KEY (id));
INSERT INTO products (title, cost) VALUES ( 'InMemory Product', 111.11 );
INSERT INTO products (title, cost) VALUES ( 'Second Product', 99.99 );