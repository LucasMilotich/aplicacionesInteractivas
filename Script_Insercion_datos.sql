#Usuario
INSERT INTO api.usuario(dni, nombre, domicilio, nombre_usuario, email, fecha_nacimiento, password, deleted)
VALUES('36930495','Santiago','Domicilio test','admin','admin@test.com.ar','1992-01-01','admin',0);

#Rol Usuario
INSERT INTO api.rol_usuario(nombre_usuario, rol)
VALUES('admin','ADMINISTRADOR');

INSERT INTO api.rol_usuario(nombre_usuario, rol)
VALUES('admin','AGENTE COMERCIAL');

INSERT INTO api.rol_usuario(nombre_usuario, rol)
VALUES('admin','OPERADOR');

INSERT INTO api.rol_usuario(nombre_usuario, rol)
VALUES('admin','VENDEDOR');

#Cines
INSERT INTO api.cine(cuit, nombre, domicilio, deleted)
VALUES('30687307123','Cinemark Palermo','Beruti 320',0);

INSERT INTO api.cine(cuit, nombre, domicilio, deleted)
VALUES('33708537239','Cine Multiplex Belgrano','Mendoza 2799',0);

#Salas
INSERT INTO api.sala(id_sala, nombre, filas, columnas, cuit, deleted)
VALUES(1,'Sala 1',5,10,'30687307123',0);

INSERT INTO api.sala(id_sala, nombre, filas, columnas, cuit, deleted)
VALUES(2,'Sala 2',6,8,'30687307123',0);

INSERT INTO api.sala(id_sala, nombre, filas, columnas, cuit, deleted)
VALUES(3,'Sala 3',5,8,'30687307123',0);

INSERT INTO api.sala(id_sala, nombre, filas, columnas, cuit, deleted)
VALUES(4,'Sala 1',5,10,'33708537239',0);

INSERT INTO api.sala(id_sala, nombre, filas, columnas, cuit, deleted)
VALUES(5,'Sala 2',6,8,'33708537239',0);

INSERT INTO api.sala(id_sala, nombre, filas, columnas, cuit, deleted)
VALUES(6,'Sala 3',5,8,'33708537239',0);

#Pelicula
INSERT INTO api.pelicula(id_pelicula, nombre, director, genero, duracion, idioma, subtitulos, calificacion, observaciones, deleted)
VALUES(1,'Halloween 2018','David Gordon','Suspenso',105,'Ingles','Español',6,'La nueva de Halloween',0);

INSERT INTO api.pelicula(id_pelicula, nombre, director, genero, duracion, idioma, subtitulos, calificacion, observaciones, deleted)
VALUES(2,'Bohemian Rhapsody','Bryan Singer','Drama',134,'Ingles','Español',9,'Pelicula biográfica sobre Freddie Mercury y Queen',0);

INSERT INTO api.pelicula(id_pelicula, nombre, director, genero, duracion, idioma, subtitulos, calificacion, observaciones, deleted)
VALUES(3,'El secreto de sus ojos','Juan José Campanella','Drama',127,'Español','',9,'Una peli argentina',0);

INSERT INTO api.pelicula(id_pelicula, nombre, director, genero, duracion, idioma, subtitulos, calificacion, observaciones, deleted)
VALUES(4,'Pie Pequeño','Karey Kirkpatrick','Infantil',100,'Español','',8,'Infaltable para ir con la familia',0);

#Funcion
INSERT INTO api.funcion(id_funcion, cuit, id_pelicula, id_sala, fecha, hora, deleted)
VALUES(1,'30687307123',1,1,'2018-11-10','17:30',0);

INSERT INTO api.funcion(id_funcion, cuit, id_pelicula, id_sala, fecha, hora, deleted)
VALUES(2,'30687307123',2,2,'2018-11-10','18:00',0);

INSERT INTO api.funcion(id_funcion, cuit, id_pelicula, id_sala, fecha, hora, deleted)
VALUES(3,'30687307123',2,2,'2018-11-10','20:45',0);

INSERT INTO api.funcion(id_funcion, cuit, id_pelicula, id_sala, fecha, hora, deleted)
VALUES(4,'30687307123',4,3,'2018-11-11','14:00',0);

INSERT INTO api.funcion(id_funcion, cuit, id_pelicula, id_sala, fecha, hora, deleted)
VALUES(5,'33708537239',1,4,'2018-11-15','15:00',0);

INSERT INTO api.funcion(id_funcion, cuit, id_pelicula, id_sala, fecha, hora, deleted)
VALUES(6,'33708537239',2,4,'2018-11-15','18:00',0);

INSERT INTO api.funcion(id_funcion, cuit, id_pelicula, id_sala, fecha, hora, deleted)
VALUES(7,'33708537239',2,5,'2018-11-15','19:00',0);

INSERT INTO api.funcion(id_funcion, cuit, id_pelicula, id_sala, fecha, hora, deleted)
VALUES(8,'33708537239',3,6,'2018-11-16','09:00',0);

#Asiento_funcion
DROP PROCEDURE IF EXISTS cargar_asientos_funcion;

DELIMITER #
CREATE PROCEDURE cargar_asientos_funcion(IN id INT(3))
BEGIN
  DECLARE i SMALLINT(2);
  DECLARE j SMALLINT(2);
  set i = 0;
  set j = 0;
  SELECT s.filas, s.columnas INTO @fila,@columna FROM api.sala s, api.funcion f WHERE id_funcion = id AND f.cuit = s.cuit AND f.id_sala = s.id_sala LIMIT 1;
  start transaction;	
  while i < @fila do
	while j < @columna do
		insert into api.asiento_funcion(id_funcion,fila,columna,ocupado) values (id,i,j,0);
		set j=j+1;
	end while;
	set i=i+1;
    set j = 0;
  end while;
  commit;
end #

delimiter ;

call cargar_asientos_funcion(1);
call cargar_asientos_funcion(2);
call cargar_asientos_funcion(3);
call cargar_asientos_funcion(4);
call cargar_asientos_funcion(5);
call cargar_asientos_funcion(6);
call cargar_asientos_funcion(7);
call cargar_asientos_funcion(8);

