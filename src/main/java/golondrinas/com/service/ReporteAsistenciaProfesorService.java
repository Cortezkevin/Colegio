package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.ReporteAsistenciaProfesorRepository;
import golondrinas.com.model.ReporteAsistenciaProfesor;

@Service
public class ReporteAsistenciaProfesorService {
	
	@Autowired
	private ReporteAsistenciaProfesorRepository repository;
	
	public List<ReporteAsistenciaProfesor> listarReporteAsistencia(){
		return repository.listarReporteAsistencia();
	}
}
