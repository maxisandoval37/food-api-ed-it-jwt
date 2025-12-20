--Food
INSERT INTO food (name, calories) VALUES ('Pizza', 300);
INSERT INTO food (name, calories) VALUES ('Hamburguesa', 350);
INSERT INTO food (name, calories) VALUES ('Lomito', 250);
INSERT INTO food (name, calories) VALUES ('Fideos con salsa', 100);
INSERT INTO food (name, calories) VALUES ('Tarta de verduras', 80);
INSERT INTO food (name, calories) VALUES ('Milanesa', 80);

--Ingredients
INSERT INTO ingredient (name, food_id) VALUES ('Harina', 1);
INSERT INTO ingredient (name, food_id) VALUES ('Queso', 1);
INSERT INTO ingredient (name, food_id) VALUES ('Salsa de tomate', 1);

INSERT INTO ingredient (name, food_id) VALUES ('Harina', 2);
INSERT INTO ingredient (name, food_id) VALUES ('Queso', 2);
INSERT INTO ingredient (name, food_id) VALUES ('Carne', 2);

INSERT INTO ingredient (name, food_id) VALUES ('Carne', 3);
INSERT INTO ingredient (name, food_id) VALUES ('Pan', 3);
INSERT INTO ingredient (name, food_id) VALUES ('Lechuga', 3);

INSERT INTO ingredient (name, food_id) VALUES ('Fideos', 4);
INSERT INTO ingredient (name, food_id) VALUES ('Salsa', 4);

INSERT INTO ingredient (name, food_id) VALUES ('Milanesa', 5);

-- password: password
INSERT INTO app_user (username, password, role) VALUES ('user1', '$2a$12$VIgsm77yjZNqLbpRo0aQjuWKNMKuCqF.5HkvNZd9LCUMMLnduCGgm', 'USER');
INSERT INTO app_user (username, password, role) VALUES ('admin', '$2a$12$VIgsm77yjZNqLbpRo0aQjuWKNMKuCqF.5HkvNZd9LCUMMLnduCGgm', 'ADMIN');