package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.AsistenciaAlumnoRepository;
import golondrinas.com.model.AsistenciaAlumno;

@Service
public class AsistenciaAlumnoService {

	@Autowired
	private AsistenciaAlumnoRepository repository;

	public List<AsistenciaAlumno> listarAsistenciaAlumnos() {
		return repository.findAll();
	}

	public void registrarAsistencia(AsistenciaAlumno asis) {
		if (asis.getIdasistencia() == null) {
			if (asis.getComentario().equals("")) {
				asis.setComentario("Sin Comentario");
				repository.RegistrarAsistenciaAlumno(asis.getIdalumno(), asis.getFecha(), asis.getEstado(),
						asis.getComentario());
			} else {
				repository.RegistrarAsistenciaAlumno(asis.getIdalumno(), asis.getFecha(), asis.getEstado(),
						asis.getComentario());
			}
		}

	}

	public boolean validarAsistenciaXFecha(AsistenciaAlumno a) {
		List<String> lista = repository.validarAsistenciaXFecha(a.getFecha(), a.getIdalumno());
		for (String alummos : lista) {
			if (alummos.equals(a.getIdalumno())) {
				return true;
			}
			break;
		}
		return false;
	}

	public List<AsistenciaAlumno> listarFaltas(String idalumno) {
		return repository.asistenciaFaltas(idalumno);
	}

	public List<AsistenciaAlumno> asistenciaXAlumno(String idalumno) {
		return repository.asistenciasXAlumno(idalumno);
	}
}
