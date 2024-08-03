CREATE TABLE productos (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    precio DOUBLE NOT NULL
);

-- Insertar datos en la tabla de productos
INSERT INTO productos (nombre, precio) VALUES ('Bebidas', 1000.00);
INSERT INTO productos (nombre, precio) VALUES ('Alimentos', 2000.00);
INSERT INTO productos (nombre, precio) VALUES ('Art Limpieza', 5000.00);
