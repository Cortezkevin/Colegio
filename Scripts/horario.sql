create table Horario(
idHorario char(4) not null,
Nivel char(20) not null,
Grado char(20) not null,
Seccion char(20) not null,
Dia char(20) not null,
Curso char(40) not null,
Hora_Inicio char(10) not null,
Hora_Fin char(10) not null,
estado char(20) null,
primary key (idHorario)
);

DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarHorario(in _nivel char(20),in _grado char(20),in _seccion char(20),in _dia char(20),
in _curso char(40),in _horainicio char(10),in _horafin char(10))
BEGIN
	SET @idhora = (SELECT CONCAT('H',RIGHT(CONCAT('00',RIGHT(MAX(idHorario),3) + 1),3)) FROM horario);	
	INSERT INTO horario VALUES (@idhora,_nivel,_grado,_seccion,_dia,_curso,_horainicio, _horafin, 'Activo');
END$$
 DELIMITER ;
 
     DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarHorario(in _idhorario char(4),in _dia char(20),
in _curso char(40),in _horainicio char(10),in _horafin char(10))
BEGIN
		update horario set dia = _dia, curso = _curso, hora_inicio = _horainicio, hora_fin = _horafin where idhorario = _idhorario;
END$$
 DELIMITER ;
 
     DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarHorario(in _idhorario char(4))
BEGIN
		update horario set estado = 'Eliminado' where idhorario = _idhorario;
END$$
 DELIMITER ;
 
CREATE  PROCEDURE sp_MantListarHorario(in _nivel char(20),in _grado char(20),in _seccion char(20))
select * from horario where nivel = _nivel and grado = _grado and seccion = _seccion;

insert into horario values('H001','Inicial','Primer Grado','Seccion A','Lunes','Matematica I','7:00 AM','9:00 AM','Activo');

