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

create table ReporteAsistenciaAlumno(
idReporte char(5) not null,
idAlumno char(4) not null,
nombreAlumno char(40) not null,
asis int not null,
inasis int not null,
tard int not null,
primary key(idReporte),
foreign key(idAlumno) references Alumno(idAlumno)
);

insert into asistenciaAlumno values("AS001","A001","Kevin Cortez Quispe","2/7/2021","Presente","");
insert into asistenciaAlumno values("AS002","A002","Carlos Manuel Huamani Huamani","2/7/2021","Tarde","Problemas de Internet");
#insert into asistenciaAlumno values("AS003","A003","Junior Arias Quispe","2/7/2021","Presente","");
insert into asistenciaAlumno values("AS003","A001","Kevin Cortez Quispe","3/7/2021","Presente","");
insert into asistenciaAlumno values("AS004","A002","Carlos Manuel Huamani Huamani","3/7/2021","Tarde","Problemas de Internet");
#insert into asistenciaAlumno values("AS006","A003","Junior Arias Quispe","3/7/2021","Presente","");
insert into asistenciaAlumno values("AS005","A001","Kevin Cortez Quispe","4/7/2021","Ausente","");
insert into asistenciaAlumno values("AS006","A002","Carlos Manuel Huamani Huamani","4/7/2021","Presente","");
#insert into asistenciaAlumno values("AS009","A003","Junior Arias Quispe","4/7/2021","Presente","");
insert into asistenciaAlumno values("AS007","A001","Kevin Cortez Quispe","5/7/2021","Presente","");
insert into asistenciaAlumno values("AS008","A002","Carlos Manuel Huamani Huamani","5/7/2021","Presente","");
#insert into asistenciaAlumno values("AS012","A003","Junior Arias Quispe","5/7/2021","Presente","");

insert into ReporteAsistenciaAlumno values('RA001','A001','Kevin Cortez Quispe',3,1,0);
insert into ReporteAsistenciaAlumno values('RA002','A002','Carlos Manuel Huamani Huamani',2,0,2);
#insert into ReporteAsistenciaAlumno values('RA003','A003','Junior Arias Quispe',4,0,0);

DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarAsistenciaAlumno(IN _idalumno char(4), in _fecha char(10), in _estado char(20), in _comentario varchar(40))
BEGIN
	SET @idasis = (SELECT CONCAT('AS',RIGHT(CONCAT('00',RIGHT(MAX(idAsistencia),3) + 1),3)) FROM asistenciaAlumno);	
    set @nombrecompleto = (select nombreCompleto from alumno where idalumno = _idalumno); 
	insert into asistenciaAlumno values(@idasis, _idalumno, @nombrecompleto, _fecha, _estado, _comentario);

set @asis = (select count(estado) from asistenciaAlumno where estado = 'Presente' and idalumno = _idalumno);
set @inasis = (select count(estado) from asistenciaAlumno where estado = 'Ausente' and idalumno = _idalumno);
set @tard = (select count(estado) from asistenciaAlumno where estado = 'Tarde' and idalumno = _idalumno);
set @idreporte = (select idReporte from reporteasistenciaalumno where idalumno = _idalumno);

update reporteasistenciaalumno set asis = @asis, inasis = @inasis, tard = @tard  where idReporte = @idreporte;
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
 
 
  
 create procedure sp_MantValidarAsistenciaXFecha(in _fecha char(10), in _idalumno char(4))
 select idAlumno from asistenciaAlumno where fecha = _fecha and idalumno = _idalumno ;

##
 /* CREATE  PROCEDURE sp_MantReporteAsistenciaAlumnos(in _idalumno char(4))
set @asis = (select count(estado) from asistenciaAlumno where estado = 'Presente' and idalumno = _idalumno);
set @inasis = (select count(estado) from asistenciaAlumno where estado = 'Ausente' and idalumno = _idalumno);
set @tard = (select count(estado) from asistenciaAlumno where estado = 'Tarde' and idalumno = _idalumno);
set @alumno = (select nombreCompleto from alumno where idalumno = _idalumno);

select @alumno as Alumno, @asis as Presente, @inasis as Ausente, @tard as Tardanza;
*/

#####################################################
/*DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarReporteAsistenciaAlumno(IN _idalumno char(4), in _fecha char(10), in _estado char(20), in _comentario varchar(40))
BEGIN

	SET @idreporte = (SELECT CONCAT('RA',RIGHT(CONCAT('00',RIGHT(MAX(idReporte),3) + 1),3)) FROM ReporteAsistenciaAlumno);	
	set @nombrecompleto = (select nombreCompleto from alumno where idalumno = _idalumno); 
    insert into ReporteAsistenciaAlumno values(@idreporte,@nombrecompleto,3,1,0);
END$$
 DELIMITER ;
 
 DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarReporteAsistenciaAlumno(IN _idalumno char(4), in _fecha char(10), in _estado char(20), in _comentario varchar(40))
BEGIN

	SET @idreporte = (SELECT CONCAT('RA',RIGHT(CONCAT('00',RIGHT(MAX(idReporte),3) + 1),3)) FROM ReporteAsistenciaAlumno);	
    insert into ReporteAsistenciaAlumno values('RA001','Kevin Cortez Quispe',3,1,0);
END$$
 DELIMITER ;*/
   