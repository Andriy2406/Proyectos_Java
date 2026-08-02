create table Alumnos(
id serial not null primary key,
	nombres varchar(50),
	apellidos varchar(50)
);

/*INSERTAR*/
insert into Alumnos (nombres,apellidos) values ('Naruto', 'Uzumaki');

/*MOSTRAR*/
select * from Alumnos;

/*ACTUALIZAR*/
update Alumnos set nombres = 'Itachi', apellidos = 'Uchiha' where Alumnos.id = 1;

/*Eliminar*/
delete from Alumnos where Alumnos.id = 2;