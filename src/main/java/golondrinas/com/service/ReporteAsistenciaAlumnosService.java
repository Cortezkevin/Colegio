package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.ReporteAsistenciaAlumnosRepository;
import golondrinas.com.model.ReporteAsistenciaAlumnos;

@Service
public class ReporteAsistenciaAlumnosService {

	@Autowired
	private ReporteAsistenciaAlumnosRepository repository;
	
	public List<ReporteAsistenciaAlumnos> listarReporteAsistenciaAlumnos(String nivel, String grado, String seccion){
		return repository.listarReporteAsistenciaAlumnos(nivel, grado, seccion);
	}
}
