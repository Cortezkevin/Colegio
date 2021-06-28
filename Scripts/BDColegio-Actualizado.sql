create database colegio5;
use  colegio5;

create table Persona(
idPersona char(4) not null,
tipoPersona char(1) not null,
nombres char(20) null,
apellidos char(20) null,
direccion char(20) null,
telefono char(9) null,
email char(20) null,
dni char(8) null,
edad int null,
genero char(10) not null,
estado char(20) null,
primary key (idPersona)
);

create table Cargo(
idCargo char(4) not null,
nombre char(15) null,
estado char(20) null,
primary key (idCargo)
);

create table Usuario(
idUsuario char(4) not null,
nombreUsuario char(20) null,
contrasena char(150) null,
idCargo char(4) not null,
idPersona char(4) not null,
estado char(20) null,
foto longblob null,
primary key (idUsuario), 
foreign key (idPersona) references Persona(idPersona),
foreign key (idCargo) references Cargo(idCargo)
);

create table Nivel(
idNivel char(4) not null,
nombre char(15) null,
estado char(20) null,
primary key(idNivel)
);

create table Grado(
idGrado char(4) not null,
nombre char(15) null,
estado char(20) null,
primary key(idGrado)
);
create table Seccion(
idSeccion char(4) not null,
nombre char(15) null,
estado char(20) null,
primary key(idSeccion)
);


create table Profesor(
idProfesor char(4) not null,
idPersona char(4) not null,
idUsuario char(4) not null,
nombreCompleto char(40) null,
estado char(20) null,
primary key(idProfesor),
foreign key (idPersona) references Persona(idPersona),
foreign key (idUsuario) references Usuario(idUsuario)
);

create table Curso(
idCurso char(4) not null,
idNivel char(4) not null,
idGrado char(4) not null,
nombre char(20) null,
descripcion char(40) null,
estado char(20) null,
primary key (idCurso),
foreign key (idNivel) references Nivel(idNivel),
foreign key (idGrado) references Grado(idGrado)
);

create table Hora(
idHora char(4) not null,
horaInicio char(10) null,
horaFin char(10) null,
dia char(10) null,
estado char(20) null,
primary key (idHora)
);

create table CursoProgramado(
idCursoProgramado char(4) not null,
idCurso char(4) not null,
idSeccion char(4) not null,
idProfesor char(4) not null,
estado char(20) null,
primary key (idCursoProgramado),
foreign key (idCurso) references Curso(idCurso),
foreign key (idSeccion) references Seccion(idSeccion),
foreign key (idProfesor) references Profesor(idProfesor)
);

create table Horario(
idHorario char(4) not null,
idNivel char(4) not null,
idGrado char(4) not null,
#idCursoProgramado char(4) not null,
hLunes char(40) not null,
hMartes char(40) not null,
hMiercoles char(40) not null,
hJueves char(40) not null,
hViernes char(40) not null,
idHora char(4) not null,
estado char(20) null,
primary key (idHorario),
foreign key (idNivel) references Nivel(idNivel),
foreign key (idGrado) references Grado(idGrado),
#foreign key (idCursoProgramado) references CursoProgramado(idCursoProgramado),
foreign key (idHora) references Hora(idHora)
);
##FALTA AGREGAR 
create table Apoderado(
idApoderado char(5) not null,
idPersona char(4) not null,
nombreCompleto char(40) null,
estado char(20) not null,
primary key(idApoderado) ,
foreign key (idPersona) references Persona(idPersona) 
);
create table Matricula(
idMatricula char(4) not null,
idPersona char(4) not null,
idApoderado char(5) not null,
idNivel char(4) not null,
idGrado char(4) not null,
idSeccion char(4) not null,
nombreUsuario varchar(45) not null,
contrasena char(200) not null,
monto double null,
fecha date null,
estado char(20),
primary key(idMatricula),
foreign key (idPersona) references Persona(idPersona),
foreign key (idApoderado) references Apoderado(idApoderado),
foreign key (idNivel) references Nivel(idNivel),
foreign key (idGrado) references Grado(idGrado),
foreign key (idSeccion) references Seccion(idSeccion)
);

create table Alumno(
idAlumno char(4)not null,
idPersona char(4)not null,
idUsuario char(4) not null,
idMatricula char(4) not null,
nivel char(20) not null,
grado char(20) not null,
seccion char(20) not null,
apoderado varchar(45) not null,
nombreCompleto char(40) null, 
estado char(20) null,
primary key (idAlumno), 
foreign key (idPersona) references Persona(idPersona),
foreign key (idUsuario) references Usuario(idUsuario),
foreign key (idMatricula) references Matricula(idMatricula)
);

 create table Bimestre(               ##
 idBimestre char(4) not null,      ##
nombre char(20) null,                 ##
estado char(20) null,
primary key(idBimestre)
 );

create table Notas(
idNotas char(5) not null,
idAlumno char(4) not null,
idCurso char(4) not null,
idBimestre char(4) not null,        ##
examen1 double null,
examen2 double null,
examen3 double null,
examen4 double null,
promedio double null,
estado char(20) null,
primary key(idNotas),
foreign key (idAlumno) references Alumno(idAlumno),
foreign key (idCurso) references Curso(idCurso),
foreign key (idBimestre) references Bimestre(idBimestre)
);

create table  NotaBimestres(
idNotaBimestre char(5) not null,
idAlumno char(4) not null,
idCurso char(4) not null,
nota_bimestre1 double null,   
nota_bimestre2 double null,   
nota_bimestre3 double null,   
nota_bimestre4 double null,   
promedio_anual double null,    
estado char(20) null,
primary key (idNotaBimestre),
foreign key (idAlumno) references Alumno(idAlumno),
foreign key (idCurso) references Curso(idCurso)
);

create table Pago(
idPago char(5) not null,
idMatricula char(4) not null,
fechaPago date null,
monto Double null,
estado char(20) null,
primary key(idPago),
foreign key (idMatricula) references Matricula(idMatricula)
);

 create table Asistencias(
 idAsistencia char(5) not null,
 idAlumno char(4) not null,
 Inasist_justificada varchar(2) null,
 Inasist_injustificada varchar(2) null,
 Tard_justificada varchar(2) null,
 Tard_injustificada varchar(2) null,
 primary key(idAsistencia),
 foreign key (idAlumno) references Alumno(idAlumno)
 );
 
 create table user_role(
 user_id varchar(255) not null,
 role_id  varchar(255) not null,
 primary key (user_id, role_id)
 );
 

 

