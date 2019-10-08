CREATE SEQUENCE IF NOT EXISTS order_item_id_seq
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

CREATE TABLE IF NOT EXISTS order_item (
  order_item_id bigint NOT NULL PRIMARY KEY DEFAULT nextval('order_item_id_seq'),
  description varchar(255) DEFAULT NULL,
  created TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  quantity INTEGER NOT NULL,
  price DECIMAL(10, 5),
  order_id bigint NOT NULL REFERENCES "order"(order_id)
);