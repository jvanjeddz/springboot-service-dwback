INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('johndoe', '12345', 1, 'John', 'Doe', 'johndoe@example.com')
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('janesmith', '54321', 1, 'Jane', 'Smith', 'janesmith@example.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (1, 1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2, 2);
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2, 1);