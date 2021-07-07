package golondrinas.com.service;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.STLineSpacingRuleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.AsistenciaAlumnoRepository;
import golondrinas.com.model.AsistenciaAlumno;
import golondrinas.com.model.Cargo;
import golondrinas.com.model.Persona;

@Service
public class AsistenciaAlumnoService {

	@Autowired
	private AsistenciaAlumnoRepository repository;

	public List<AsistenciaAlumno> listarAsistenciaAlumnos() {
		return repository.findAll();
	}

	public void Asistencia(boolean boton, AsistenciaAlumno a) {

		// boton = false;
		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {

			@Override
			public void run() {
				int dia = 20;
				int asis = 0;
				int inas = 0;

				if (boton == true) {
					dia -= 1;
					asis += 1;
				} else {
					dia -= 1;
					inas += 1;
				}
				repository.AsistenciaAlumno(a.getIdasistencia(), a.getIdalumno(), asis, inas, dia);
			}
		};
		timer.schedule(tarea, new Date(), 10000);
	}
	
	public void registrarAsistencia(AsistenciaAlumno asis) {
		if(asis.getIdasistencia() == null ){
				repository.RegistrarAsistenciaAlumno(asis.getIdalumno(), asis.getFecha(), asis.getEstado(), asis.getComentario());	
		}else {
			repository.ActualizarAsistenciaAlumno(asis.getIdasistencia(), asis.getEstado(),asis.getComentario());
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
	
	/*public String IdAsistenciaAlumnoXFecha(String idalumno, Date fecha) {
		return repository.IdAsistenciaAlumnoXFecha(idalumno, fecha);
	}*/
}
