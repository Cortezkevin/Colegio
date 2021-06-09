package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.AlumnoRepository;
import golondrinas.com.model.Alumno;

@Service
public class AlumnoService {

	@Autowired
	private AlumnoRepository repository;

	public List<Alumno> listarALumno() {
		return repository.listarAlumnos();
	}

	public void registrarAlumno(Alumno a) {
		if (a.getIdalumno() == null) {

			repository.RegistrarAlumno(a.getIdpersona(),a.getIdusuario(), a.getIdmatricula(), a.getNivel(), a.getGrado(), a.getSeccion(),
					a.getApoderado());
		}

		else {
			repository.ActualizarAlumno(a.getIdalumno(),a.getIdpersona(),a.getIdusuario(), a.getIdmatricula(), a.getNivel(), a.getGrado(), a.getSeccion(),
					a.getApoderado());
		}
	}

	public void eliminarAlumno(Alumno a) {

		repository.EliminarAlumno(a.getIdalumno());
	}
}
