
CREATE TABLE usuario(
dni					VARCHAR(9),
nombre				VARCHAR(50),
domicilio			VARCHAR(50),
nombre_usuario			VARCHAR(50) NOT NULL PRIMARY KEY,
email				VARCHAR(50),
fecha_nacimiento			DATE,
password			VARCHAR(50),
  deleted          tinyint(1) default '0' null


);
CREATE TABLE rol_usuario(
nombre_usuario		VARCHAR(100) NOT NULL,
rol			VARCHAR(255) NOT NULL,
CONSTRAINT pk_rol_x_user PRIMARY KEY(nombre_usuario, rol)
);

CREATE TABLE cine(
cuit		VARCHAR(12),
nombre		VARCHAR(50),
domicilio	VARCHAR(50),
deleted          tinyint(1) default '0' null
);

create table sala
(
  nombre   varchar(50) null,
  filas    int(2)      null,
  columnas int(2)      null,
  cuit     varchar(12) not null,
  deleted tinyint(1) default '0' null
  constraint sala_pk
  unique (nombre, cuit)
);


CREATE TABLE pelicula(
nombre			VARCHAR(50) NOT NULL PRIMARY KEY,
director		VARCHAR(50),
genero			VARCHAR(30),
duracion		SMALLINT(3),
idioma			VARCHAR(30),
subtitulos		VARCHAR(30),
calificacion	SMALLINT(2),
observaciones	VARCHAR(100),
deleted			TINYINT(1) DEFAULT '0' NULL
);

CREATE TABLE funcion(
cuit			VARCHAR(12) NOT NULL,
pelicula		VARCHAR(50) NOT NULL,
sala			VARCHAR(50) NOT NULL,
horario			TIMESTAMP NOT NULL,
deleted 		TINYINT(1) DEFAULT '0' NULL
);

CREATE TABLE asiento_funcion(
cuit			VARCHAR(12) NOT NULL,
pelicula		VARCHAR(50) NOT NULL,
sala			VARCHAR(50) NOT NULL,
horario			TIMESTAMP NOT NULL,
fila			SMALLINT(2) NOT NULL,
columna			SMALLINT(2) NOT NULL,
deleted 		TINYINT(1) DEFAULT '0' NULL
);

create table descuento
(
  cuit                 varchar(12)            null,
  nombre               varchar(30)            null,
  vigencia_desde       date                   null,
  vigencia_hasta       date                   null,
  cant_prod_requeridos int(10)                null,
  cant_prod_a_pagar    int(10)                null,
  porcentaje_descuento int(10)                null,
  deleted              tinyint(1) default '0' null,
  constraint descuento_pk
  unique (cuit, nombre)
);

CREATE TABLE venta(
id_venta		INTEGER(10) NOT NULL AUTO_INCREMENT,
cuit			VARCHAR(12),
id_pelicula		INTEGER(10),
id_funcion		INTEGER(10),
cantidad		INTEGER(5),
metodo_pago		INTEGER(1)
);
Create table entrada(
id_venta		INTEGER(10) NOT NULL AUTO_INCREMENT,
estado varchar (255),
cuit varchar (12),
nombre_sala varchar (255),
nombre_pelicula varchar (255),
asiento varchar (255),
horario timestamp

)