CREATE TABLE wishlist (
  user_id BIGINT NOT NULL,
  product_id BIGINT NOT NULL,
  PRIMARY KEY (user_id, product_id)
);

ALTER TABLE wishlist
  ADD CONSTRAINT fk_wishlist_users
    FOREIGN KEY (user_id)
    REFERENCES users (id);

ALTER TABLE wishlist
  ADD CONSTRAINT fk_wishlist_products
    FOREIGN KEY (product_id)
    REFERENCES products (id);