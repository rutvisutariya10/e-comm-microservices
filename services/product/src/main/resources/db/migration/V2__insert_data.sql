-- Insert data into category table
INSERT INTO category (description, name) VALUES
('Electronics category', 'Electronics'),
('Home Appliances', 'Home Appliances'),
('Furniture', 'Furniture'),
('Clothing', 'Clothing'),
('Books', 'Books'),
('Sports and Outdoors', 'Sports'),
('Health and Beauty', 'Health & Beauty'),
('Toys and Games', 'Toys'),
('Automotive', 'Automotive'),
('Food and Beverages', 'Food & Beverages');

INSERT INTO product (description, name, available_quantity, price, category_id) VALUES
('Tennis racket with case', 'Tennis Racket Pro', 120, 59.99, 251),
('Yoga mat with non-slip surface', 'Yoga Mat', 200, 29.99, 251),
('Facial cleanser for sensitive skin', 'Sensitive Skin Cleanser', 300, 14.99, 301),
('Electric toothbrush', 'Electric Toothbrush Model 500', 250, 39.99, 301),
('Building blocks for kids', 'LEGO Set 500 pieces', 180, 49.99, 351),
('Remote controlled car', 'RC Car Racer', 100, 29.99, 351),
('Car tire for all seasons', 'All-Season Car Tire', 80, 129.99, 401),
('Oil change kit', 'Car Oil Change Kit', 60, 19.99, 401),
('Organic coffee beans', 'Organic Coffee Beans', 500, 12.99, 451),
('Gourmet chocolate box', 'Chocolate Box Deluxe', 400, 25.99, 451),
('Smartphone with 128GB storage', 'Smartphone XYZ', 150, 799.99, 1),
('LED Television 50 inches', 'LED TV', 75, 499.50, 1),
('Air conditioner 1.5 Ton', 'AC Model ABC', 50, 349.99, 51),
('Sofa Set 3 pieces', 'Sofa Set', 20, 899.99, 101),
('T-shirt in various sizes', 'Cotton T-shirt', 200, 19.99, 151),
('Hardcover Novel', 'The Great Adventure', 500, 15.50, 201);