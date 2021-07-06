create table AsistenciaAlumno(
idAsistencia char(5) not null,
idAlumno char(4) not null,
nombreAlumno char(40) not null,
fecha  char(10) not  null,
/*asis int not null,
inasis int not null,
dias int not null,*/
estado char(20) not null,
comentario varchar(40) not null,
primary key(idAsistencia),
foreign key(idAlumno) references Alumno(idAlumno)
);

insert into asistenciaAlumno values("AS001","A001","Kevin Cortez Quispe","2021-04-05","Presente","Tardanza")


DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarAsistenciaAlumno(IN _idalumno char(4), in _fecha char(10), in _estado char(20), in _comentario varchar(40))
BEGIN
	SET @idasis = (SELECT CONCAT('AS',RIGHT(CONCAT('00',RIGHT(MAX(idAsistencia),3) + 1),3)) FROM asistenciaAlumno);	
    set @nombrecompleto = (select nombreCompleto from alumno where idalumno = _idalumno); 
	insert into asistenciaAlumno values(@idasis, _idalumno, @nombrecompleto, _fecha, _estado, _comentario);
END$$
 DELIMITER ;

DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarAsistenciaAlumno(IN _idasistencia char(5), in _estado char(20), in comentario varchar(40))
BEGIN
	UPDATE asistenciaAlumno set estado = _estado, comentario = _comentario where idAsistencia = _idasistencia;
END$$
 DELIMITER ;
 
 create procedure sp_MantIdAsistenciaAlumnoXFecha(in _idalumno char(4), in _fecha date)
 select idAsistencia from asistenciaAlumno where idAlumno = _idalumno and fecha = _fecha ;
 
 
 create procedure sp_MantValidarAsistenciaXFecha(in _fecha char(10))
 select idAlumno from asistenciaAlumno where fecha = _fecha ;
