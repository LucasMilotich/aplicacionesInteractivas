CREATE DATABASE IF NOT EXISTS api
USE api;

#Usuarios
CREATE TABLE usuario(
dni					VARCHAR(9),
nombre				VARCHAR(50),
domicilio			VARCHAR(50),
nombre_usuario		VARCHAR(50) NOT NULL PRIMARY KEY,
email				VARCHAR(50),
fecha_nacimiento	DATE,
password			VARCHAR(50),
deleted          	TINYINT(1) DEFAULT '0' NULL
);

#Roles por Usuario
CREATE TABLE rol_usuario(
nombre_usuario		VARCHAR(100) NOT NULL,
rol					VARCHAR(255) NOT NULL,
CONSTRAINT pk_rol_x_user PRIMARY KEY(nombre_usuario, rol)
);

#Cines
CREATE TABLE cine(
cuit		VARCHAR(11) PRIMARY KEY,
nombre		VARCHAR(50),
domicilio	VARCHAR(50),
deleted     TINYINT(1) DEFAULT '0' NULL
);

#Salas
CREATE TABLE sala(
id_sala		INT(3) PRIMARY KEY AUTO_INCREMENT,
nombre   	VARCHAR(50),
filas    	INT(2),
columnas 	INT(2),
cuit     	VARCHAR(12) NOT NULL,
deleted 	TINYINT(1) DEFAULT '0' NULL
);

#Peliculas
CREATE TABLE pelicula(
id_pelicula		INT(3) PRIMARY KEY AUTO_INCREMENT,
nombre			VARCHAR(50) NOT NULL,
director		VARCHAR(50),
genero			VARCHAR(30),
duracion		SMALLINT(3),
idioma			VARCHAR(30),
subtitulos		VARCHAR(30),
calificacion	SMALLINT(2),
observaciones	VARCHAR(100),
deleted			TINYINT(1) DEFAULT '0' NULL
);

#Funciones
CREATE TABLE funcion(
id_funcion		int(3) PRIMARY KEY AUTO_INCREMENT,
cuit			VARCHAR(12) NOT NULL,
id_pelicula		INT(3) NOT NULL,
id_sala			INT(3) NOT NULL,
fecha			DATE NOT NULL,
hora			TIME NOT NULL,
deleted 		TINYINT(1) DEFAULT '0' NULL
);

#Asientos de funciones
CREATE TABLE asiento_funcion(
id_funcion		INT(3) NOT NULL,
fila			SMALLINT(2) NOT NULL,
columna			SMALLINT(2) NOT NULL,
ocupado			TINYINT(1) DEFAULT '0' NULL
);

#Descuentos
CREATE TABLE descuento(
cuit                 VARCHAR(12),
nombre               VARCHAR(30),
vigencia_desde       DATE,
vigencia_hasta       DATE,
cant_prod_requeridos INT(10),
cant_prod_a_pagar    INT(10),
porcentaje_descuento INT(10),
deleted              TINYINT(1) DEFAULT '0' NULL,
CONSTRAINT descuento_pk UNIQUE (cuit, nombre)
);

#Ventas
CREATE TABLE venta(
id_venta		INTEGER(10) PRIMARY KEY AUTO_INCREMENT,
cuit			VARCHAR(12),
cantidad		INTEGER(5),
metodo_pago		INTEGER(1),
precio_unitario	DOUBLE,
total			DOUBLE
);

#Entradas
CREATE TABLE entrada(
id				INTEGER(10) PRIMARY KEY AUTO_INCREMENT,
id_venta 		INTEGER(10) NOT NULL,
estado 			VARCHAR(255),
fila 			SMALLINT(2) NOT NULL,
columna 		SMALLINT(2) NOT NULL,
id_funcion 		INTEGER(3) NOT NULL
);

#Datos tarjeta
CREATE TABLE datos_tarjeta(
id_venta		INTEGER(10) NOT NULL,
tipo_tarjeta	INT(1) NOT NULL,
numero			VARCHAR(16) NOT NULL,
vencimiento		VARCHAR(4) NOT NULL,
codigo_seg		VARCHAR(4) NOT NULL
);