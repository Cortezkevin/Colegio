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

create table AsistenciaProfesor(
idAsistenciaP char(5) not null,
idProfesor char(4) not null,
nombreProfesor char(40) not null,
fecha  char(10) not  null,
estado char(20) not null,
comentario varchar(40) not null,
primary key(idAsistenciaP),
foreign key(idProfesor) references Profesor(idProfesor)
);

create table ReporteAsistenciaAlumno(
idReporte char(5) not null,
idAlumno char(4) not null,
nivel char(20) not null,
grado char(20) not null,
seccion char(20) not null,
nombreAlumno char(40) not null,
asis int not null,
inasis int not null,
tard int not null,
primary key(idReporte),
foreign key(idAlumno) references Alumno(idAlumno)
);

create table ReporteAsistenciaProfesor(
idReporteP char(5) not null,
idProfesor char(4) not null,
nombreProfesor char(40) not null,
asis int not null,
inasis int not null,
tard int not null,
primary key(idReporteP),
foreign key(idProfesor) references Profesor(idProfesor)
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

insert into ReporteAsistenciaAlumno values('RA001','A001','Inicial','Primer Grado','Seccion A','Kevin Cortez Quispe',3,1,0);
insert into ReporteAsistenciaAlumno values('RA002','A002','Inicial','Primer Grado','Seccion A','Carlos Manuel Huamani Huamani',2,0,2);
#insert into ReporteAsistenciaAlumno values('RA003','A003','Primaria','Segundo Grado','Seccion B','Junior Arias Quispe',4,0,0);
#insert into ReporteAsistenciaAlumno values('RA004','A004','Primaria','Segundo Grado','Seccion B','Piero Torrez Lorenzo',1,0,0);

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
CREATE  PROCEDURE sp_MantRegistrarAsistenciaProfesor(IN _idprofesor char(4), in _fecha char(10), in _estado char(20), in _comentario varchar(40))
BEGIN
	SET @idasis = (SELECT CONCAT('AS',RIGHT(CONCAT('00',RIGHT(MAX(idAsistenciaP),3) + 1),3)) FROM asistenciaProfesor);	
    set @nombrecompleto = (select nombreCompleto from profesor where idProfesor = _idprofesor); 
	insert into asistenciaProfesor values(@idasis, _idprofesor, @nombrecompleto, _fecha, _estado, _comentario);

set @asis = (select count(estado) from asistenciaProfesor where estado = 'Presente' and idprofesor = _idprofesor);
set @inasis = (select count(estado) from asistenciaProfesor where estado = 'Ausente' and idprofesor = _idprofesor);
set @tard = (select count(estado) from asistenciaProfesor where estado = 'Tarde' and idprofesor = _idprofesor);
set @idreporte = (select idReporteP from reporteasistenciaprofesor where idprofesor = _idprofesor);

update reporteasistenciaprofesor set asis = @asis, inasis = @inasis, tard = @tard  where idReporteP = @idreporte;
END$$
 DELIMITER ;

insert into asistenciaProfesor values("AS001","D001","Juan Perez Huapaya Arias","7/7/2021","Presente","");

insert into ReporteAsistenciaProfesor values('RP001','D001','Juan Perez Huapaya Arias',2,0,0);
 
 create procedure sp_MantIdAsistenciaAlumnoXFecha(in _idalumno char(4), in _fecha date)
 select idAsistencia from asistenciaAlumno where idAlumno = _idalumno and fecha = _fecha ;
 
 
 create procedure sp_MantValidarAsistenciaXFecha(in _fecha char(10), in _idalumno char(4))
 select idAlumno from asistenciaAlumno where fecha = _fecha and idalumno = _idalumno ;
 
  create procedure sp_MantValidarAsistenciaXFechaProfesor(in _fecha char(10), in _idprofesor char(4))
 select idProfesor from asistenciaProfesor where fecha = _fecha and idprofesor = _idprofesor ;


create procedure sp_MantListarReporteAsistencias(in _nivel char(20), in _grado char(20), in _seccion char(20))
select nombrealumno, asis, inasis, tard from reporteasistenciaalumno where nivel = _nivel and grado = _grado and seccion = _seccion;
   
create procedure sp_MantListarReporteAsistenciasP()
select nombreprofesor, asis, inasis, tard from reporteasistenciaprofesor;   
   ####
   
DELIMITER $$
CREATE PROCEDURE sp_listUserLogin(IN _idusuario char(40))
BEGIN 
select a.idalumno,a.nombrecompleto,a.apoderado,m.idmatricula,m.idnivel,g.nombre as Gnombre,s.nombre as Snombre,
	p.nombres,p.apellidos,p.dni,p.telefono, p.direccion, p.email, p.genero,
    p.edad,a.estado, u.idcargo,u.foto from usuario u
inner join alumno a on u.idusuario= a.idusuario
inner join persona p on p.idpersona = a.idpersona
inner join matricula m on a.idmatricula = m.idmatricula
inner join grado g on m.idgrado= g.idgrado
inner join seccion s on m.idseccion=s.idseccion
where u.nombreusuario= _idusuario;
END$$
DELIMITER ;

create procedure sp_CargoXUsuario(in _usuario char(30))
select c.idcargo from usuario u inner join cargo c on u.idcargo = c.idcargo
where u.nombreusuario = _usuario;