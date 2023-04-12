INSERT INTO Brands (id, name) VALUES (1, 'Brand 1');

INSERT INTO Price_Lists (id, name) VALUES (1, 'PriceList 1');
INSERT INTO Price_Lists (id, name) VALUES (2, 'PriceList 2');
INSERT INTO Price_Lists (id, name) VALUES (3, 'PriceList 3');
INSERT INTO Price_Lists (id, name) VALUES (4, 'PriceList 4');

INSERT INTO Products (id, name) VALUES (35455, 'Products 35455');

INSERT INTO Sales (id, product_id, brand_id, price_id, start_date, end_date, price, priority, currency) VALUES (0, 35455, 1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 35.50, 0, 'EUR');
INSERT INTO Sales (id, product_id, brand_id, price_id, start_date, end_date, price, priority, currency) VALUES (1, 35455, 1, 2, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 25.45, 1, 'EUR');
INSERT INTO Sales (id, product_id, brand_id, price_id, start_date, end_date, price, priority, currency) VALUES (2, 35455, 1, 3, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 30.50, 1, 'EUR');
INSERT INTO Sales (id, product_id, brand_id, price_id, start_date, end_date, price, priority, currency) VALUES (3, 35455, 1, 4, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 38.95, 1, 'EUR');

