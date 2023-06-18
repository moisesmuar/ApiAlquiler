
DROP DATABASE IF EXISTS alquiler;
CREATE DATABASE alquiler;
USE alquiler;

CREATE TABLE portales (
    idPortal INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    colorHex VARCHAR(7) NOT NULL
);

CREATE TABLE empresas (
    idEmpresa INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    nif VARCHAR(9) UNIQUE NOT NULL
);

CREATE TABLE users (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    userName VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    rol INT NOT NULL DEFAULT 1,  
    idEmpresa INT NOT NULL,
    FOREIGN KEY (idEmpresa)
        REFERENCES empresas (idEmpresa)
);

CREATE TABLE inmuebles (
    idInmueble INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    calle VARCHAR(255),
    ciudad VARCHAR(255),
    numPersonas INT,
    numHabitaciones INT,
    numBanos INT,
    numAseos INT,
    idEmpresa INT NOT NULL,
    FOREIGN KEY (idEmpresa)
            REFERENCES empresas (idEmpresa)
);

CREATE TABLE clientes (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    telefono VARCHAR(25),
    email VARCHAR(255),
    calle VARCHAR(255),
    ciudad VARCHAR(255),
    pais VARCHAR(100),
    cp VARCHAR(5),
    idEmpresa INT NOT NULL,
    FOREIGN KEY (idEmpresa)
            REFERENCES empresas (idEmpresa)
);

CREATE TABLE alquileres (
    idAlquiler INT AUTO_INCREMENT PRIMARY KEY,
    fhinicio DATE NOT NULL,
    fhfin DATE NOT NULL,
    idInmueble INT NOT NULL,
    idCliente INT NOT NULL,
    idPortal INT NOT NULL,
    idEmpresa INT NOT NULL,
    FOREIGN KEY (idInmueble) 
            REFERENCES inmuebles (idInmueble), 
    FOREIGN KEY (idCliente) 
            REFERENCES clientes (idCliente),
    FOREIGN KEY (idPortal) 
            REFERENCES portales (idPortal), 
    FOREIGN KEY (idEmpresa)
            REFERENCES empresas (idEmpresa)
);

INSERT INTO portales(  nombre, colorHex )
VALUES  ( "Booking", "#a9cbff" ), 
        ( "AirBnb", "#ff9aac" ),    
        ( "Externo", "#ffd496" ); 

INSERT INTO empresas( nombre,  nif)
VALUES  ( "Empresa TIPO" , "12345678Z" ),  
        ( "Castillo S.L." , "X9898983Z" ),
        ( "Global" , "Y1111109Z" );

INSERT INTO users( userName, password, idEmpresa, rol )
VALUES  ( "moi", "moi", 1, 0),
        ( "juan", "juan", 1, 1),
        ( "usu1_castillo", "usu1_castillo", 2, 0),
        ( "usu2_castillo", "usu2_castillo", 2, 1),
        ( "usu1_global", "usu1_global", 3, 0),
        ( "usu2_global", "usu2_global", 3, 1);

INSERT INTO inmuebles( nombre, calle, ciudad, numPersonas, numHabitaciones, numBanos, numAseos, idEmpresa )
VALUES  ('Inmueble TIPO', 'C/ TIPO', 'Ciudad TIPO', 0, 0, 0, 0, 1),
        ('Casa Adosada', 'Calle del Mar 14', 'Alicante', 6, 3, 2, 1, 1),
        ('Piso 1', 'Calle Mayor 5', 'Madrid', 4, 2, 1, 1, 1),
        ('Piso 2', 'Calle de la Sierra 8', 'Sevilla', 8, 4, 3, 2, 1),
        ('Piso 3', 'Calle del Puerto 3', 'Valencia', 2, 1, 1, 0, 1),
        ('Casa del Jardín', 'Calle del Jardín 23', 'Barcelona', 10, 5, 4, 3, 1),
        
        ('Inmueble 1', 'Calle jardin 9', 'Bailén', 0, 0, 0, 0, 2),  
        ('Inmueble 2', 'Calle jardin 12', 'Bailén', 6, 3, 2, 1, 2),

        ('Inmueble 1', 'C/ Ejemplo 1', 'Linares', 4, 2, 1, 1, 3),  
        ('Inmueble 2', 'C/ Ejemplo 2', 'Linares', 2, 1, 1, 0, 3),
        ('Inmueble 3', 'C/ Ejemplo 3', 'Linares', 8, 4, 3, 2, 3),
        ('Inmueble 4', 'C/ Ejemplo 4', 'Linares', 5, 3, 2, 1, 3);


INSERT INTO clientes( nombre, telefono, email, calle, ciudad, pais, cp, idEmpresa )
VALUES  ('Cliente TIPO', '000 000 000', 'clienteTipo@gmail.com', 'C/ TIPO', 'Ciudad TIPO', 'Pais TIPO', '00000', 1),
        ('Juan Pérez', '+34 123456789', 'juanperez@gmail.com', 'Calle Mayor 1', 'Madrid', 'España', '28001', 1),
        ('María García', '+34 987654321', 'mariagarcia@hotmail.com', 'Calle de la Playa 5', 'Barcelona', 'España', '08001', 1),
        ('Pedro Ruiz', '+34 654321987', 'pedroruiz@yahoo.com', 'Calle de la Montaña 9', 'Granada', 'España', '18001', 1),
        ('Laura Sánchez', '+34 111222333', 'laurasanchez@gmail.com', 'Calle de la Fuente 6', 'Valencia', 'España', '46001', 1),
        ('Sara Fernández', '+34 555666777', 'sarafernandez@hotmail.com', 'Calle del Parque 3', 'Madrid', 'España', '28001', 1),

        ('Cliente 1', '+34 111222333', 'cliente1@empresa2.com', 'Calle Principal 1', 'Ciudad Empresa 2', 'País Empresa 2', '00001', 2),
        ('Cliente 2', '+34 222333444', 'cliente2@empresa2.com', 'Calle Secundaria 2', 'Ciudad Empresa 2', 'País Empresa 2', '00002', 2),
        ('Cliente 3', '+34 333444555', 'cliente3@empresa2.com', 'Calle Principal 3', 'Ciudad Empresa 2', 'País Empresa 2', '00003', 2),

        ('Cliente 1', '+34 444555666', 'cliente1@empresa3.com', 'Calle Principal 1', 'Ciudad Empresa 3', 'País Empresa 3', '00001', 3),
        ('Cliente 2', '+34 555666777', 'cliente2@empresa3.com', 'Calle Secundaria 2', 'Ciudad Empresa 3', 'País Empresa 3', '00002', 3),
        ('Cliente 3', '+34 666777888', 'cliente3@empresa3.com', 'Calle Principal 3', 'Ciudad Empresa 3', 'País Empresa 3', '00003', 3),
        ('Cliente 4', '+34 777888999', 'cliente4@empresa3.com', 'Calle Principal 4', 'Ciudad Empresa 3', 'País Empresa 3', '00004', 3);


INSERT INTO alquileres( fhinicio, fhfin, idInmueble, idCliente, idPortal, idEmpresa )
VALUES  ('2023-04-06', '2023-04-08', 1, 3, 2, 1),
        ('2023-04-03', '2023-04-05', 4, 2, 1, 1),
        ('2023-04-16', '2023-04-20', 3, 5, 1, 1),
        ('2023-04-10', '2023-04-12', 5, 4, 2, 1),
        ('2023-04-24', '2023-04-26', 5, 4, 2, 1),
        ('2023-04-28', '2023-04-29', 5, 4, 1, 1),

        ('2023-05-02', '2023-05-03', 7, 1, 1, 2),
        ('2023-05-05', '2023-05-07', 7, 1, 2, 2),
        ('2023-05-11', '2023-05-13', 7, 1, 3, 2),
        ('2023-05-14', '2023-05-17', 7, 1, 2, 2),

        ('2023-05-18', '2023-05-19', 9, 1, 1, 3),  /* posible mejora fhini y fh fin mismo dia*/
        ('2023-05-20', '2023-05-21', 9, 1, 1, 3),
        ('2023-05-22', '2023-05-23', 9, 1, 2, 3),
        ('2023-05-24', '2023-05-25', 9, 1, 3, 3),
        ('2023-05-27', '2023-05-30', 9, 1, 2, 3);