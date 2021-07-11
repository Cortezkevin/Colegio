create table Justificaciones(
idJustificacion char(4) not null,
idAsistencia char(5) not null,
fecha_falta char(11) not null,
fecha_justi char(11) not null,
descripcion char(60) not null,
primary key(idJustificacion),
foreign key(idAsistencia) references AsistenciaAlumno(idAsistencia)
);


DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarJustificacion(in _idAsistencia char(5),in _fechafalta char(11), in _fechajusti char(11),in _descripcion char(60))
BEGIN
	SET @id= (SELECT CONCAT('J',RIGHT(CONCAT('00',RIGHT(MAX(idJustificacion),3) + 1),3)) FROM Justificaciones);	
	INSERT INTO Justificaciones VALUES (@id, _idAsistencia, _fechafalta,_fechajusti, _descripcion);
    
    update asistenciaAlumno set estado = 'Justificado' where idAsistencia = _idAsistencia;
END$$
 DELIMITER ;
 
 insert into Justificaciones VALUES ('J001', 'AS005', '4/7/2021','10/7/2021', 'Corte de Luz');
 #call sp_MantRegistrarJustificacion('AS010','7/7/2021','10/7/2021','Problemas de Salud');
 
 CREATE  PROCEDURE sp_MantListarAsistenciasFaltas(in _idalumno char(4))
select * from asistenciaalumno where idalumno = _idalumno and (estado = 'Ausente' or estado = "Justificado" );
 
 CREATE  PROCEDURE sp_MantListarAsistenciasXAlumno(in _idalumno char(4))
select fecha, estado, comentario from asistenciaalumno where idalumno = _idalumno;


 CREATE  PROCEDURE sp_MantListarJustificacion(in _idalumno char(4))
select j.* from justificaciones j
inner join asistenciaalumno a on j.idAsistencia = a.idAsistencia
where a.idalumno = _idalumno; /*and (estado = 'Ausente' or estado = 'Justificado');*/

 CREATE  PROCEDURE sp_MantValidarJustificacion(in _idasistencia char(5))
select estado from asistenciaalumno where idasistencia = _idasistencia;