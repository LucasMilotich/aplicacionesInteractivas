/*
* Creacion de tablas para TP API 2C2018
*/

--Usuarios
CREATE TABLE usuarios(
username			VARCHAR(50) NOT NULL PRIMARY KEY,
password			VARCHAR(50),
email				VARCHAR(50),
nombre				VARCHAR(50),
domicilio			VARCHAR(50),
dni					VARCHAR(9),
fechaNac			DATE
);

--Roles
CREATE TABLE roles(
id_rol		INTEGER(2) NOT NULL AUTO_INCREMENT PRIMARY KEY,
descripcion	VARCHAR(50) NOT NULL
);

CREATE TABLE rol_por_usuario(
username		VARCHAR(100) NOT NULL,
id_rol			INTEGER(2) NOT NULL,
CONSTRAINT pk_rol_x_user PRIMARY KEY(username, id_rol)
);

--Cines
CREATE TABLE cines(
cuit		VARCHAR(12),
nombre		VARCHAR(50),
domicilio	VARCHAR(50),
);

--Salas
CREATE TABLE salas(
id_sala		INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre		VARCHAR(50),
filas		INTEGER(2),
columnas	INTEGER(2)
);

CREATE TABLE salas_x_cine(
cuit		VARCHAR(12) NOT NULL,
id_sala		INTEGER(10) NOT NULL,
CONSTRAINT pk_sala_x_cine PRIMARY KEY(cuit,id_sala)
);

--Peliculas
CREATE TABLE peliculas(
id_pelicula		INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre			VARCHAR(50),
director		VARCHAR(50),
genero			VARCHAR(10),
duracion		SMALLINT(3),
idioma			VARCHAR(30),
subtitulos		VARCHAR(30),
calificacion	SMALLINT(2),
observaciones	VARCHAR(100)
);

--Funciones
CREATE TABLE funciones(
id_funcion		INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
cuit			VARCHAR(12),
horario			VARCHAR(4)
);

--Descuentos
CREATE TABLE descuentos(
id_descuento	INTEGER(10) NOT NULL AUTO_INCREMENT,
descripcion		VARCHAR(30),
vigencia		DATE
);

--Ventas
CREATE TABLE ventas(
id_venta		INTEGER(10) NOT NULL AUTO_INCREMENT,
cuit			VARCHAR(12),
id_pelicula		INTEGER(10),
id_funcion		INTEGER(10),
cantidad		INTEGER(5),
metodo_pago		INTEGER(1)
);