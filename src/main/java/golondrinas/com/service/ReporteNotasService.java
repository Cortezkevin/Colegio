package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.ReporteNotasRepository;
import golondrinas.com.model.ReporteNotas;

@Service
public class ReporteNotasService {

	@Autowired
	private ReporteNotasRepository repository;
	
	public List<ReporteNotas> listarNotasXBimestre1(String idalumno){
		return repository.listarNotasXBimestre1(idalumno);
	}
	
	public List<ReporteNotas> listarNotasXBimestre2(String idalumno){
		return repository.listarNotasXBimestre2(idalumno);
	}
	
	public List<ReporteNotas> listarNotasXBimestre3(String idalumno){
		return repository.listarNotasXBimestre3(idalumno);
	}
	
	public List<ReporteNotas> listarNotasXBimestre4(String idalumno){
		return repository.listarNotasXBimestre4(idalumno);
	}
}
