##COLEGIO PROCEDIMIENTOS ALMACENADOS

##PROCEDIMIENTOS ALMACENADOS DE GRADO

CREATE PROCEDURE sp_ManListarGradoxNombre(IN _nombre char(15))
SELECT  * FROM  grado where nombre = _nombre;

DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarGrado(IN nombregrado CHAR(15))
BEGIN
	SET @idgrado = (SELECT CONCAT('G',RIGHT(CONCAT('00',RIGHT(MAX(idGrado),3) + 1),3)) FROM grado);	
	INSERT INTO grado (idGrado, nombre,estado) VALUES (@idgrado,nombregrado,'Activo');
END$$
 DELIMITER ;
 
 
DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarGrado(IN _idgrado CHAR(4),IN _nombregrado CHAR(15), IN _estado Char(20))
BEGIN
	UPDATE grado SET nombre = _nombregrado, estado = _estado WHERE idGrado= _idgrado;
END$$
 DELIMITER ;
 
DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarGrado(IN _idgrado CHAR(4))
BEGIN
	UPDATE grado SET estado = "Eliminado" WHERE idGrado = _idgrado; 
END$$
 DELIMITER ;

CREATE PROCEDURE sp_MantObtenerGrado(IN _idgrado CHAR(4))
	SELECT	g.idGrado, g.nombre, g.estado
	FROM	 grado g WHERE g.idGrado = _idgrado;
    #########################################################
    
   ##PROCEDIMIENTOS ALMACENADOS DE SECCIONES
    
   CREATE  PROCEDURE sp_MantListarSecciones()
	select s.idSeccion, s.nombre, s.estado from seccion s;
   
    CREATE PROCEDURE sp_ManListarSeccionxNombre(IN _nombre char(15))
	SELECT  * FROM  seccion where nombre = _nombre;
    
 DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarSeccion(IN nombreseccion CHAR(15))
BEGIN
	SET @idseccion = (SELECT CONCAT('S',RIGHT(CONCAT('00',RIGHT(MAX(idSeccion),3) + 1),3)) FROM seccion);	
	INSERT INTO seccion (idSeccion, nombre, estado) VALUES (@idseccion, nombreseccion,'Activo');
END$$
 DELIMITER ;

DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarSeccion(IN _idseccion CHAR(4),IN _nombreseccion CHAR(15),IN _estado char(20))
BEGIN
	UPDATE seccion SET nombre = _nombreseccion, estado = _estado  WHERE idSeccion= _idseccion;
END$$
 DELIMITER ;

 
 
DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarSeccion(IN _idseccion CHAR(4))
BEGIN
	UPDATE seccion SET estado = "Eliminado" WHERE idSeccion = _idseccion; 
END$$
 DELIMITER ;

CREATE PROCEDURE sp_MantObtenerSeccion(IN _idseccion CHAR(4))
	SELECT	s.idSeccion, s.nombre, s.estado
	FROM	 seccion s WHERE s.idSeccion = _idseccion;
    ##############################
     
   ##PROCEDIMIENTOS ALMACENADOS DE ALUMNOS
    
CREATE  PROCEDURE sp_MantListarAlumnos()
select * from alumno ;

CREATE  PROCEDURE sp_MantListarDetalleAlumno(IN idalumno char(4))
select ap.nombrecompleto as apoderado, p.nombres, p.apellidos , u.nombreUsuario, n.nombre as nivel, g.nombre as grado from alumno a 
inner join persona p on a.idPersona = p.idPersona inner join usuario u on a.idUsuario = u.idUsuario 
inner join nivel n on a.idNivel = n.idNivel inner join grado g on a.idGrado = g.idGrado inner join apoderado ap on a.idApoderado = ap.idApoderado
 Where a.idAlumno =  idalumno;

DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarAlumno(IN idpersona CHAR(4),IN _idusuario char(4),IN idmatricula CHAR(4),IN nivel CHAR(20),
IN grado CHAR(20), in seccion char(20), in apoderado varchar(45))
BEGIN
	SET @idalumno = (SELECT CONCAT('A',RIGHT(CONCAT('00',RIGHT(MAX(idAlumno),3) + 1),3)) FROM alumno);	
    set @nombrecompleto = (select concat(p.nombres,' ',p.apellidos) as nombre_completo from persona p where p.idPersona = idpersona);    
	INSERT INTO alumno (idAlumno, idPersona,idUsuario,idMatricula , Nivel, Grado,Seccion,Apoderado,nombreCompleto, estado) VALUES (@idalumno, idpersona,_idusuario,idmatricula,nivel,grado,seccion,apoderado,@nombrecompleto,'Activo');
    update usuario set estado = 'Ocupado'  where idUsuario = _idusuario;
END$$
DELIMITER ;

 
DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarAlumno(IN _idalumno CHAR(4),IN _idpersona CHAR(4),IN _idusuario char(4),IN _idmatricula CHAR(4),IN _nivel CHAR(20),
IN _grado CHAR(20), in _seccion char(20), in _apoderado varchar(45))
BEGIN
	set @nombrecompleto = (select concat(p.nombres,' ',p.apellidos) as nombre_completo from persona p where p.idPersona = _idpersona);    
	UPDATE alumno SET idPersona = _idpersona, idUsuario = _idusuario, idMatricula = _idmatricula,Nivel = _nivel, Grado = _grado,Seccion = _seccion ,Apoderado = _apoderado, nombreCompleto = @nombrecompleto WHERE idAlumno= _idalumno;
END$$
DELIMITER ;
 
DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarAlumno(IN _idalumno CHAR(4))
BEGIN
	UPDATE alumno SET estado = "Eliminado" WHERE idAlumno = _idalumno; 
END$$
DELIMITER ;

CREATE PROCEDURE sp_MantObtenerAlumno(IN _idalumno CHAR(4))
	SELECT	a.idAlumno, a.idPersona, a.idUsuario, a.idNivel, a.idGrado, a.estado
	FROM	 alumno a WHERE a.idAlumno = _idalumno;
    
   
CREATE  PROCEDURE sp_MantListarDetalleMatriculas(In _idmatricula char(4))
select concat(p.Nombres,' ',p.Apellidos) as persona, ap.nombreCompleto as apoderado,
n.nombre as nivel, g.nombre as grado, s.nombre as seccion, m.nombreUsuario as usuario
from matricula m inner join persona p on m.idPersona = p.idPersona inner join apoderado ap on m.idApoderado = ap.idApoderado
inner join nivel n on m.idNivel = n.idNivel inner join grado g on m.idGrado = g.idGrado inner join seccion s on m.idSeccion = s.idSeccion
where m.idMatricula = _idmatricula;
   
   
CREATE  PROCEDURE sp_MantListarMatriculas()
	select * from matricula ;

CREATE  PROCEDURE sp_MantListarEstadoXPersona(in _idpersona char(4))
select p.estado  from matricula m
inner join persona p on m.idPersona = p.idPersona
where p.idPersona = _idpersona

DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarMatricula(IN _idpersona CHAR(4),in _idapoderado char(5) ,IN _idnivel CHAR(4),
	IN _idgrado CHAR(4),IN _idseccion CHAR(4),in _nombreUsuario varchar(45),in _contrasena char(200), in monto double,IN fecha DATE)
BEGIN

	SET @idmatricula = (SELECT CONCAT('M',RIGHT(CONCAT('00',RIGHT(MAX(idMatricula),3) + 1),3)) FROM matricula);	
	INSERT INTO matricula (idMatricula, idPersona,idApoderado, idNivel, idGrado, idSeccion,nombreUsuario,contrasena,monto,fecha,estado) 
    VALUES (@idmatricula, _idpersona,_idapoderado,_idnivel,_idgrado,_idseccion,_nombreUsuario,_contrasena,monto,fecha,'Activo');
    
    set @idusuario = (SELECT CONCAT('U',RIGHT(CONCAT('00',RIGHT(MAX(idUsuario),3) + 1),3)) FROM usuario);	
    #set @nombreusuario = (SELECT CONCAT('A',RIGHT(CONCAT('0',RIGHT(dni,8)),9)) FROM persona where idpersona = _idpersona );
    #set  @contrasena = (select  CONCAT(RIGHT(CONCAT(LEFT(p.apellidos,1),LEFT(p.dni,8)),10))  from persona p where p.idPersona = _idpersona );
    set @Cargo = (select idcargo from cargo where nombre = 'Alumno');
    INSERT INTO usuario (idUsuario, nombreUsuario, contrasena, idCargo, idPersona,estado,foto) VALUES (@idusuario,_nombreUsuario,_contrasena,@Cargo, _idpersona,'Activo','no tiene');
    
    set @nivel = (select nombre from nivel where idNivel = _idnivel);
    set @grado = (select nombre from grado where idGrado = _idgrado);
    set @seccion = (select nombre from seccion where idSeccion = _idseccion);
    set @apoderado = (select nombreCompleto from apoderado where idApoderado = _idapoderado);
    set @alumno = (select concat(nombres," " ,apellidos) as nombreCompleto from persona  where idPersona = _idpersona);
    set @idalumno = (SELECT CONCAT('A',RIGHT(CONCAT('00',RIGHT(MAX(idAlumno),3) + 1),3)) FROM alumno);
    insert into alumno (idAlumno, idPersona, idUsuario, idMatricula, nivel, grado, seccion, apoderado ,nombreCompleto, estado) 
    values (@idalumno, _idpersona, @idUsuario, @idMatricula, @nivel, @grado, @seccion,@apoderado,@alumno,'Activo') ;
    
	update persona set estado = 'Ocupado' where idPersona = _idpersona;
    update usuario set estado = 'Ocupado'  where idUsuario = @idusuario;
END$$
DELIMITER ;
 
 /*
DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarMatricula(IN _idmatricula CHAR(4),IN _idalumno CHAR(4),IN _idnivel CHAR(4),IN _idgrado CHAR(4),IN _idseccion CHAR(4),IN _fecha DATE)
BEGIN
	UPDATE matricula SET idAlumno = _idalumno, idNivel = _idnivel, idGrado = _idgrado, idSeccion = _idseccion, fecha = _fecha WHERE idMatricula= _idmatricula;
END$$
DELIMITER ;*/

DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarMatricula(IN _idmatricula CHAR(4),IN _idpersona CHAR(4),IN _idapoderado char(5),
IN _idnivel CHAR(4),IN _idgrado CHAR(4),IN _idseccion CHAR(4),In _nombreusuario varchar(45), in _contrasena char(200), in _monto double,IN _fecha DATE)
BEGIN
	UPDATE matricula SET idPersona = _idpersona, idApoderado = _idapoderado,idNivel = _idnivel, idGrado = _idgrado, 
    idSeccion = _idseccion,nombreUsuario = _nombreusuario,contrasena = _contrasena, monto = _monto,fecha = _fecha WHERE idMatricula= _idmatricula;
END$$
DELIMITER ;
 
DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarMatricula(IN _idmatricula CHAR(4))
BEGIN
	UPDATE matricula set estado = "Eliminado" where idMatricula = _idmatricula;
END$$
DELIMITER ;

CREATE PROCEDURE sp_MantObtenerMatricula(IN _idmatricula CHAR(4))
	SELECT	m.idMatricula, m.idAlumno, m.idNivel, m.idGrado, m.idSeccion, m.fecha, m.estado
	FROM	 matricula m WHERE m.idMatricula = _idmatricula;
    
         ##############################
     
   ##PROCEDIMIENTOS ALMACENADOS DE PERSONA
   ##############################################################################################################
   ##Listar personas
CREATE PROCEDURE sp_ManListarPersona()
            SELECT    p.IdPersona, p.Nombres, p.Apellidos, p.Direccion, p.Telefono,
            p.Email, p.DNI, p.Edad, p.Genero, p.estado
            FROM persona p;
            
CREATE PROCEDURE sp_ManSelectPersona()
            SELECT   *
            FROM persona where estado = 'Activo' ;
            
CREATE PROCEDURE sp_ManListarPersonaxDNI(IN _dni char(8))
	SELECT  * FROM persona where dni = _dni;

CREATE PROCEDURE sp_ManListarPersonaxTelefono(IN _telefono char(9))
	SELECT  * FROM persona where telefono = _telefono;
    
CREATE PROCEDURE sp_ManListarPersonaxEmail(IN _email char(20))
	SELECT  * FROM persona where email = _email;    
 

##Registar persona
DELIMITER $$
CREATE PROCEDURE sp_MantRegistrarPersona(IN nombreper char(20), IN apellidoper char(20), IN direccionper char(20), IN telefonoper char(9),
                                            IN emailper char(20), IN dniper char(8), IN edadper INT, IN generoper char(10))
BEGIN
    SET @idPersona = (SELECT CONCAT('P',RIGHT(CONCAT('00',RIGHT(MAX(idPersona),3) + 1),3)) FROM persona);	  
    INSERT INTO Persona(idPersona, nombres, apellidos, direccion, telefono, email, dni, edad, genero, estado) 
                        VALUES (@idPersona, nombreper, apellidoper, direccionper, telefonoper, emailper, dniper, edadper, generoper,'Activo');
END$$
 DELIMITER ;


DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarPersona(IN _idPersona char(4), IN _nombreper char(20), IN _apellidoper char(20), IN _direccionper char(20), IN _telefonoper char(9),
                                            IN _emailper char(20), IN _dniper char(8), IN _edadper INT, IN _generoper char(10))
BEGIN
    UPDATE persona SET nombres = _nombreper, apellidos = _apellidoper, direccion = _direccionper, telefono = _telefonoper, email = _emailper, dni = _dniper ,edad = _edadper, genero = _generoper WHERE idPersona = _idPersona;
END$$
DELIMITER ;
 
DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarPersona(IN _idPersona CHAR(4))
BEGIN
    UPDATE persona SET estado = "Eliminado" WHERE idPersona = _idPersona; 
END$$
DELIMITER ;
 

 

CREATE PROCEDURE sp_MantObtenerPersona(IN _idPersona CHAR(4))
    SELECT    p.idPersona, p.Nombres, p.Apellidos, p.Direccion, p.Telefono,
            p.Email, p.DNI, p.Edad, p.Genero, p.Estado
    FROM    persona p WHERE p.idPersona = _idPersona;

            ##############################
     
   ##PROCEDIMIENTOS ALMACENADOS DE CURSOS
   
   ##Registrar Curso
DELIMITER $$
CREATE PROCEDURE sp_MantRegistrarCurso(IN idnivel char(4), IN idgrado char(4),IN nombre char(20), IN descripcion char(40))
BEGIN
    SET @idcurso = (SELECT CONCAT('C',RIGHT(CONCAT('00',RIGHT(MAX(IdCurso),3) + 1),3)) FROM curso);#####################################################################
    INSERT INTO Curso(idCurso, idNivel, idGrado, Nombre, Descripcion, Estado) 
                        VALUES (@idcurso, idnivel, idgrado, nombre, descripcion, 'Activo');
END$$
 DELIMITER ;


 

##Actualizar Curso
DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarCurso(IN _idcurso char(4), IN _idnivel char(4), IN _idgrado char(4), IN _nombre char(20), IN _descripcion char(40))
BEGIN
    UPDATE Curso SET idNivel = _idnivel, idGrado = _idgrado, nombre = _nombre, descripcion = _descripcion
    WHERE idCurso = _idcurso;
END$$
DELIMITER 

##Eliminar Curso
DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarCurso(IN _idcurso CHAR(4))
BEGIN
    UPDATE curso SET estado = "Eliminado" WHERE idCurso = _idcurso; 
END$$
DELIMITER ;

 

##Obtener Curso
CREATE PROCEDURE sp_MantObtenerCurso(IN _idcurso CHAR(4))
    SELECT    c.idCurso, c.idNivel, c.idGrado, c.nombre, c.descripcion, c.estado
    FROM    curso c WHERE c.idCurso = _idcurso;
    
   
            ##############################
     
   ##PROCEDIMIENTOS ALMACENADOS DE PROFESORES
   
   CREATE  PROCEDURE sp_MantListarProfesores()
select p.idProfesor, p.idPersona, p.idUsuario, p.nombreCompleto ,p.estado from profesor p;
   
CREATE  PROCEDURE sp_MantListarDetalleProfesor(IN idprofesor char(4))
select  p.nombres, p.apellidos , u.nombreUsuario, pr.estado from profesor pr
inner join persona p on pr.idPersona = p.idPersona inner join usuario u on pr.idUsuario = u.idUsuario 
 Where pr.idProfesor =  idprofesor;
   
   
   
DELIMITER $$
CREATE PROCEDURE sp_MantRegistrarProfesor(IN idprofesor char(4), IN _idpersona char(4), IN _idusuario char(4))
BEGIN
    SET @idprofesor = (SELECT CONCAT('D',RIGHT(CONCAT('00',RIGHT(MAX(idProfesor),3) + 1),3)) FROM profesor);
    set @nombrecompleto = (select concat(p.nombres,' ',p.apellidos) as nombre_completo from persona p where p.idPersona = _idpersona);    
    INSERT INTO Profesor(idProfesor, idPersona, idUsuario,nombreCompleto, estado) 
                        VALUES (@idprofesor, _idpersona, _idusuario, @nombrecompleto,'Activo');
	update persona set estado = 'Ocupado' where idPersona = _idpersona;
    update usuario set estado = 'Ocupado'  where idUsuario = _idusuario;
							
END$$
 DELIMITER ;


 

##Actualizar Profesor
DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarProfesor(IN _idprofesor char(4), IN _idpersona char(4), IN _idusuario char(4), IN _estado char(20))
BEGIN
	set @nombrecompleto = (select concat(p.nombres,' ',p.apellidos) as nombre_completo from persona p where p.idPersona = idpersona);    
    UPDATE Profesor SET idPersona = _idpersona, idUsuario = _idusuario, nombreCompleto = @nombrecompleto, estado = _estado
    WHERE idProfesor = idprofesor;
END$$
DELIMITER 

 

##Eliminar Profesor
DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarProfesor(IN _idprofesor CHAR(4))
BEGIN
    UPDATE profesor SET estado = "Eliminado" WHERE idProfesor = _idprofesor; 
END$$
DELIMITER ;

 

##Obtener Profesor
CREATE PROCEDURE sp_MantObtenerProfesor(IN _idprofesor CHAR(4))
    SELECT    p.idProfesor, p.idPersona, p.idUsuario, p.estado
    FROM    profesor p WHERE p.idProfesor = _idprofesor;
   
   
               ##############################
     
   ##PROCEDIMIENTOS ALMACENADOS DE CARGO
 CREATE  PROCEDURE sp_MantListarGrados()
	select c.idCargo, c.nombre, c.estado from cargo c;
 
 
  CREATE  PROCEDURE sp_MantListarCargos()
	select c.idcargo, c.nombre, c.estado from cargo c;
    

   
   
   DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarCargo(IN nombrecargo CHAR(15))
BEGIN
	SET @idcargo = (SELECT CONCAT('R',RIGHT(CONCAT('00',RIGHT(MAX(idCargo),3) + 1),3)) FROM cargo);	
	INSERT INTO cargo (idCargo, nombre,estado) VALUES (@idcargo,nombrecargo,'Activo');
END$$
 DELIMITER ;
 
DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarCargo(IN _idcargo CHAR(4),IN _nombrecargo CHAR(15))
BEGIN
	UPDATE cargo SET nombre = _nombrecargo WHERE idCargo= _idcargo;
END$$
 DELIMITER ;
 
DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarCargo(IN _idcargo CHAR(4))
BEGIN
	 UPDATE cargo SET estado = "Eliminado" WHERE idCargo = _idcargo; 
END$$
 DELIMITER ;

CREATE PROCEDURE sp_MantObtenerCargo(IN _idcargo CHAR(4))
	SELECT	c.idCargo, c.nombre
	FROM	 cargo c WHERE c.idCargo = _idcargo;

CREATE PROCEDURE sp_MantObtenerListaNombres()
	SELECT	c.nombre
	FROM	 cargo c ;
    

CREATE PROCEDURE sp_MantListarCargoxNombre(IN _nombre CHAR(15))
	SELECT *
	FROM	 cargo  WHERE nombre = _nombre;
    
  
CREATE  PROCEDURE sp_MantListarDetalleUsuario(IN _idusuario char(4))
select u.idusuario, u.nombreUsuario, u.contraseña, c.nombre as Cargo, p.nombres as Nombres, p.apellidos as Apellidos, u.estado from usuario u inner join cargo c
on u.idcargo = c.idcargo inner join persona p on u.idpersona = p.idpersona WHERE u.idUsuario =  _idusuario;
  

CREATE  PROCEDURE sp_MantListarUsuarios()
select u.idusuario, u.nombreUsuario, u.contraseña, c.idcargo, p.idpersona, u.estado from usuario u inner join cargo c
on u.idcargo = c.idcargo inner join persona p on u.idpersona = p.idpersona;
  
CREATE PROCEDURE sp_ManSelectUsuario()
            SELECT   *
            FROM usuario where estado = 'Activo' ;
            
DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarUsuario(IN pnombreusuario CHAR(20),IN pcontrasena varCHAR(250), IN pidcargo CHAR(4), IN pidpersona CHAR(4),IN pfoto longblob)
BEGIN
	SET @pidusuario = (SELECT CONCAT('U',RIGHT(CONCAT('00',RIGHT(MAX(idusuario),3) + 1),3)) FROM usuario);	
	INSERT INTO usuario (idusuario, nombreusuario, contrasena, idcargo, idpersona,estado,foto) VALUES (@pidusuario,pnombreusuario,pcontraseña,pidcargo, pidpersona,'Activo',pfoto);
    update persona set estado = 'Ocupado' where idPersona = pidpersona;
END$$
 DELIMITER ;
 
DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarUsuario(IN _idusuario CHAR(4))
BEGIN
	UPDATE  usuario set estado='Eliminado' WHERE idusuario = _idusuario;
END$$
DELIMITER ;

 /*
DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarUsuario(IN _idusuario CHAR(4),IN _nombreusuario CHAR(20),IN _contraseña CHAR(20), IN _idcargo CHAR(4), IN _idpersona CHAR(4))
BEGIN
	UPDATE usuario SET nombreUsuario = _nombreusuario, contraseña = _contraseña,  idCargo=_idcargo, idPersona = _idpersona WHERE IdUsuario= _idusuario;
END$$
 DELIMITER ;
 */
 /*
DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarUsuario(IN _idusuario CHAR(4))
BEGIN
	 UPDATE usuario SET estado = "Eliminado" WHERE idUsuario = _idusuario; 
END$$
 DELIMITER ;*/
 
/*
CREATE PROCEDURE sp_MantObtenerUsuario(IN _idusuario CHAR(4))
	SELECT	u.idUsuario, u.nombreUsuario, u.contraseña, u.estado, u.idCargo, u.idPersona
	FROM	 usuario u WHERE u.idUsuario = _idusuario;
  */
   
   
               ##############################
     
   ##PROCEDIMIENTOS ALMACENADOS DE NIVEL
   
    CREATE  PROCEDURE sp_MantListarNivel()
	select n.idnivel, n.nombre, n.estado from nivel n;
    
    CREATE  PROCEDURE sp_MantListarNivelxNombre(in _nombre char(15))
	select * from nivel  where nombre = _nombre;
    
      DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarNivel(IN nombrenivel CHAR(15))
BEGIN
	SET @idnivel = (SELECT CONCAT('N',RIGHT(CONCAT('00',RIGHT(MAX(idNivel),3) + 1),3)) FROM nivel);	
	INSERT INTO nivel (idNivel, nombre, estado) VALUES (@idnivel,nombrenivel,'Activo');
END$$
 DELIMITER ;

 
DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarNivel (IN _idnivel CHAR(4),IN _nombrenivel CHAR(15))
BEGIN
	UPDATE nivel SET nombre = _nombrenivel WHERE idNivel= _idnivel;
END$$
 DELIMITER ;
 
DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarNivel(IN _idnivel CHAR(4))
BEGIN
	UPDATE nivel SET estado='Eliminado' WHERE idNivel = _idnivel;
END$$
 DELIMITER ;

CREATE PROCEDURE sp_MantObtenerNivel(IN _idnivel CHAR(4))
	SELECT	n.idNivel, n.nombre
	FROM	 nivel n WHERE n.idNivel = _idnivel;
    
                   ##############################
     
   ##PROCEDIMIENTOS ALMACENADOS DE HORA
   
         DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarHora(IN horainicio CHAR(10),IN horafin CHAR(10),IN dia CHAR(10))
BEGIN
	SET @idhora = (SELECT CONCAT('H',RIGHT(CONCAT('00',RIGHT(MAX(idHora),3) + 1),3)) FROM hora);	
	INSERT INTO hora (idHora, horaInicio, horaFin, dia, estado) VALUES (@idhora,horainicio, horafin, dia, 'Activo');
END$$
 DELIMITER ;


DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarHora(IN _idhora CHAR(4),IN _horainicio CHAR(10),IN _horafin CHAR(10),IN _dia CHAR(10))
BEGIN
	UPDATE hora SET horaInicio = _horainicio,horaFin = _horafin, dia = _dia WHERE idHora= _idhora;
END$$
 DELIMITER ;
 
DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarHora(IN _idhora CHAR(4))
BEGIN
	UPDATE hora SET estado = 'Eliminado' WHERE idHora = _idhora;
END$$
 DELIMITER ;

CREATE PROCEDURE sp_MantObtenerHora(IN _idhora CHAR(4))
	SELECT	h.idHora, h.horaInicio, h.horaFin, h.dia
	FROM	 hora h WHERE h.idHora = _idhora;
 
   ###########################################
   ##PROCEDIMIENTOS ALMACENADOS DE PAGO
   
       CREATE  PROCEDURE sp_MantListarPago()
	select p.idpago, p.idmatricula, p.fechapago, p.monto, p.estado from pago p;
   
   
   
   
   ##Registrar Pago
DELIMITER $$
CREATE PROCEDURE sp_MantRegistrarPago(IN idmatricula char(4), IN fechapago DATE, IN _monto Double)
BEGIN
    SET @idpago = (SELECT CONCAT('PA',RIGHT(CONCAT('00',RIGHT(MAX(idPago),3) + 1),3)) FROM pago);
    INSERT INTO Pago(idPago, idMatricula, FechaPago, monto, estado) 
                        VALUES (@idpago, idmatricula, fechapago,_monto, 'Activo');
END$$
 DELIMITER ;
 

##Actualizar Pago
DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarPago(IN _idpago char(5), IN _idmatricula char(4), IN _fechapago DATE,IN _monto double, IN _estado char(20))
BEGIN
    UPDATE Pago SET idMatricula = _idmatricula, idFechaPago = _fechapago, monto = _monto, estado = _estado
    WHERE idPago = idpago;
END$$
DELIMITER 

 

##Eliminar Pago
DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarPago(IN _idpago CHAR(5))
BEGIN
    UPDATE pago SET estado = "Eliminado" WHERE idPago = _idpago; 
END$$
DELIMITER ;

 

##Obtener Pago
CREATE PROCEDURE sp_MantObtenerPago(IN _idpago CHAR(5))
    SELECT    p.idPago, p.idPersona, p.idUsuario, p.estado
    FROM   pago p WHERE p.idPago = _idpago;
    
    
    CREATE  PROCEDURE sp_MantListarApoderados()
	select a.idApoderado, a.idPersona, a.nombreCompleto, a.estado from apoderado a;
   
DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarApoderado(IN _idpersona CHAR(4))
BEGIN
	SET @idapoderado = (SELECT CONCAT('AP',RIGHT(CONCAT('00',RIGHT(MAX(idApoderado),3) + 1),3)) FROM apoderado);
    set @nombrecompleto = (select concat(p.nombres,' ',p.apellidos) as nombre_completo from persona p where p.idPersona = _idpersona);
	INSERT INTO apoderado (idApoderado, idPersona,nombreCompleto,estado) VALUES (@idapoderado, _idpersona , @nombrecompleto,'Activo');
    update persona set estado = 'Ocupado' where idPersona = _idpersona;
END$$
DELIMITER ;

DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarApoderado(IN _idapoderado CHAR(5),IN _idpersona CHAR(4))
BEGIN
	set @nombrecompleto = (select concat(p.nombres,' ',p.apellidos) as nombre_completo from persona p where p.idPersona = _idpersona);
	UPDATE apoderado SET idPersona = _idpersona,nombreCompleto = @nombrecompleto WHERE idApoderado = _idapoderado;
END$$
DELIMITER ;

DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarApoderado(IN _idapoderado CHAR(5))
BEGIN
	UPDATE apoderado SET estado = 'Eliminado' WHERE idApoderado = _idapoderado;
END$$
DELIMITER ;

DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarRoles(IN idcargo varchar(40))
BEGIN
	SET @pidusuario = (SELECT CONCAT('U',RIGHT(CONCAT('00',RIGHT(MAX(idusuario),3) ),3)) FROM usuario);
	INSERT INTO user_role(user_id, role_id) VALUES (@pidusuario,idcargo);
END$$
DELIMITER ;
DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarUserRoles(IN idusuario varchar(50),IN idcargo varchar(50))
BEGIN
	UPDATE user_role SET  role_id=idcargo where user_id=idusuario;
END$$
 DELIMITER ;
 

#PROCEDIMIENTOS NOTAS
CREATE  PROCEDURE sp_MantListarAlumnosxAula(in nivel char(20), in grado char(20), in seccion char(20))
    select a.idAlumno, a.nombreCompleto, a.apoderado from alumno a 
    where a.nivel = nivel and a.grado = grado and a.seccion = seccion;
    
DELIMITER $$
create procedure sp_RegistrarNotaxCurso(in _idalumno char(4), in _idcurso char(4), in _examen1 double,
						in _examen2 double, in _examen3 double, in _examen4 double, in _promedio  double)
BEGIN
    SET @idnota = (SELECT CONCAT('NO',RIGHT(CONCAT('00',RIGHT(MAX(idNotas),3) + 1),3)) FROM notas);
    INSERT INTO Notas(idNotas, idAlumno, idCurso,examen1, examen2, examen3, examen4, promedio, estado) 
                        VALUES (@idnota,_idalumno, _idcurso, _examen1, _examen2, _examen3, _examen4, _promedio,'Activo');
END$$
 DELIMITER ;
 /*
 call sp_RegistrarNotaxCurso('A003','C001',12,13,17,18,16)
 select * from alumno
 select * from notas
 delete from notas where idNotas = 'NO007'*/
 
 ################################################################
 
 DELIMITER $$
create procedure sp_ActualizarNotaxCurso(in _idnota char(5), in _idalumno char(4), in _idcurso char(4), in _examen1 double,
						in _examen2 double, in _examen3 double, in _examen4 double, in _promedio  double)
BEGIN
	update notas set examen1 = _examen1, examen2 = _examen2, examen3 = _examen3, examen4 = _examen4, promedio = _promedio
    where idnotas = _idnota;
END$$
 DELIMITER ;
 ################################################################
 /*
 DELIMITER $$
create procedure sp_ActualizarNotaxCurso(in _idnota char(5), in _idalumno char(4), in _idcurso char(4), in _examen1 double,
						in _examen2 double, in _examen3 double, in _examen4 double, in _promedio  double)
BEGIN
	update notas set examen1 = _examen1, examen2 = _examen2, examen3 = _examen3, examen4 = _examen4, promedio = _promedio
    where idnotas = _idnota;
END$$
 DELIMITER ;
 */
 
 
 
 
 #select * from curso;
 insert into Notas values ('NO002','A001','C001',15,17,10,18,15,'Activo');
 #call  sp_RegistrarNotaxCurso('A001','C003',18,15,13,10,15);
 
 CREATE  PROCEDURE sp_MantListarNotaxCurso(in _idalumno char(4))
Select n.idnotas,n.idalumno, n.idcurso, c.nombre, n.examen1, n.examen2, n.examen3, n.examen4, n.promedio
 from notas n inner join curso c on n.idCurso = c.idCurso where n.idAlumno = _idalumno;
 


CREATE  PROCEDURE sp_MantListarNotas()
Select * from notas;
   
   
 /*  ##Registrar NOTAS
DELIMITER $$
CREATE PROCEDURE sp_MantRegistrarNotas(IN _idalumno char(4), IN _idcurso char(4), IN _idnotabimestre char(5), in _examen1 double,
																				 in _examen2 double, in _examen3 double, in _examen4 double, in _promedio  double)
BEGIN
    SET @idnota = (SELECT CONCAT('NO',RIGHT(CONCAT('00',RIGHT(MAX(idNotas),3) + 1),3)) FROM notas);
    INSERT INTO Notas(idNotas, idAlumno, idCurso, idNotaBimestre,examen1, examen2, examen3, examen4, promedio, estado) 
                        VALUES (@idnota,_idalumno, _idcurso, _idnotabimestre, _examen1, _examen2, _examen3, _examen4, _promedio,'Activo');
END$$
 DELIMITER ;
 
#ACTUALIZAR NOTAS
 DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarNotas(IN _idnotas CHAR(5),IN _idalumno char(4), IN _idcurso char(4), IN _idnotabimestre char(5), in _examen1 double,
																				 in _examen2 double, in _examen3 double, in _examen4 double, in _promedio  double)
BEGIN
	##set @nombrecompleto = (select concat(p.nombres,' ',p.apellidos) as nombre_completo from persona p where p.idPersona = _idpersona);
	UPDATE notas SET idAlumno = _idalumno , idCurso = _idcurso, idNotaBimestre = _idnotabimestre, examen1 = _examen1, examen2 = _examen2,
    examen3 = _examen3, examen4 = _examen4, promedio = _promedio WHERE idNotas = _idnotas;
END$$
DELIMITER ;*/

insert into grado values('G001','Primer Grado','Activo');
insert into seccion values('S001','Seccion A','Activo');
insert into cargo values('R001','Alumno','Activo');
insert into nivel values('N001','Primaria','Activo');
insert into persona values('P001','Kevin ','Cortez Quispe','Av. San Marcos','995624785','dr@gmail.com','72195679','20','Masculino','Ocupado');
insert into persona values('P002','Victor','Martinez Ruiz','Av. Los paltos','995624785','dsadr@gmail.com','72197584','20','Masculino','Ocupado');
insert into persona values('P003','Carlos Manuel','Huamani Huamani','Av. Los paltos','995624785','dsadr@gmail.com','72856216','20','Masculino','Activo');
insert into persona values('P004','Maria Isabel','Huamani Caceres','Av. Cipres','912238976','HCMI@gmail.com','72123279','32','Femenino','Activo');
insert into persona values('P005','Juan Perez','Huapaya Arias','Av. Los paltos','988956147','JPHA@gmail.com','77896679','40','Masculino','Ocupado');
insert into apoderado values('AP001','P002','Victor Martinez Ruiz','Activo');
insert into matricula values('M001','P001','AP001','N001','G001','S001','Kevin123','$2a$04$rwAEqg.wIeWGot/iHN3.4OHPTlF3/cM0tO4PMySLy0bdbYRMYrzL6',100.0,'2002-10-10','Activo');
insert into usuario values('U001','Kevin123','$2a$04$rwAEqg.wIeWGot/iHN3.4OHPTlF3/cM0tO4PMySLy0bdbYRMYrzL6','R001','P001','Ocupado','dfsddfs');
insert into usuario values('U002','DJP123','$2a$04$rwAEqg.wIeWGot/iHN3.4OHPTlF3/cM0tO4PMySLy0bdbYRMYrzL6','R002','P005','Ocupado','dfsddfs');
insert into alumno values('A001','P001','U001','M001','Primaria','Primer Grado','Seccion A','Wilfredo Cortez Pereda','Kevin Cortez Quispe','Activo');
call sp_MantRegistrarRoles('R001');
insert into pago values('PA001','M001','2002-10-10',350.00,'Activo');
insert into curso values('C001','N001','G001','Matematica I','Matematica I nivel primaria','Activo');
insert into profesor values('D001','P008','U003','Juan Perez Huapaya Arias','Activo');


CREATE  PROCEDURE sp_MantListarNotasBimestrales()
Select * from notasbimestres;
   
   
   ##Registrar NOTAS
DELIMITER $$
CREATE PROCEDURE sp_MantRegistrarNotasBimestrales(IN _bimestre1 double,IN _bimestre2 double,IN _bimestre3 double,IN _bimestre4 double, IN _promanual double)
BEGIN
    SET @idnotabimestre = (SELECT CONCAT('NB',RIGHT(CONCAT('00',RIGHT(MAX(idNotaBimestre),3) + 1),3)) FROM notabimestres);
    INSERT INTO Notabimestres(idNotaBimestre, nota_bimestre1, nota_bimestre2, nota_bimestre3,nota_bimestre4, promedio_anul, estado) 
                        VALUES (@idnotabimestre, _bimestre1, _bimestre2, _bimestre3, _bimestre4, _promanual,'Activo');
END$$
 DELIMITER ;
 
#ACTUALIZAR NOTAS
 DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarNotasBimestrales(IN _idnotabimestre CHAR(5),IN _bimestre1 double,IN _bimestre2 double,IN _bimestre3 double,IN _bimestre4 double, IN _promanual double)
BEGIN
	##set @nombrecompleto = (select concat(p.nombres,' ',p.apellidos) as nombre_completo from persona p where p.idPersona = _idpersona);
	UPDATE notabimestres SET nota_bimestre1 = _bimestre1 , nota_bimestre2 = _bimestre2, nota_bimestre3 = _bimestre3, nota_bimestre4 = _bimestre4, promedio_anul = _promanual 
    WHERE idNotaBimestre = _idnotabimestre;
END$$
DELIMITER ;
