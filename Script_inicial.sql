
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

CREATE TABLE sala
(
  id_sala	int(3) PRIMARY KEY AUTO_INCREMENT,
  nombre   	varchar(50) null,
  filas    	int(2)      null,
  columnas 	int(2)      null,
  cuit     	varchar(12) not null,
  deleted tinyint(1) default '0' null
);


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

CREATE TABLE funcion(
id_funcion		int(3) PRIMARY KEY AUTO_INCREMENT,
cuit			VARCHAR(12) NOT NULL,
id_pelicula		INT(3) NOT NULL,
id_sala			INT(3) NOT NULL,
fecha			DATE NOT NULL,
hora			TIME NOT NULL,
deleted 		TINYINT(1) DEFAULT '0' NULL
);

CREATE TABLE asiento_funcion(
id_funcion		INT(3) NOT NULL,
fila			SMALLINT(2) NOT NULL,
columna			SMALLINT(2) NOT NULL,
ocupado			TINYINT(1) DEFAULT '0' NULL
);

CREATE TABLE descuento
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
id_venta		INTEGER(10) PRIMARY KEY AUTO_INCREMENT,
cuit			VARCHAR(12),
cantidad		INTEGER(5),
metodo_pago		INTEGER(1),
precio_unitario	DOUBLE,
total			DOUBLE
);

CREATE TABLE entrada(
id				INTEGER(10) PRIMARY KEY AUTO_INCREMENT,
id_venta 		INTEGER(10) NOT NULL,
estado 			VARCHAR(255),
fila 			SMALLINT(2) NOT NULL,
columna 		SMALLINT(2) NOT NULL,
id_funcion 		INTEGER(3) NOT NULL
);

CREATE TABLE datos_tarjeta(
id_venta		INTEGER(10) NOT NULL,
tipo_tarjeta	INT(1) NOT NULL,
numero			VARCHAR(16) NOT NULL,
vencimiento		VARCHAR(4) NOT NULL,
codigo_seg		VARCHAR(4) NOT NULL
);