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
	
	public List<ReporteNotas> listarNotasXBimestre_1(String idalumno){
		return repository.listarNotasXBimestre_1(idalumno);
	}
	
	public List<ReporteNotas> NotasBimestre_2(String idalumno){
		return repository.listarNotasXBimestre_2(idalumno);
	}
	
	public List<ReporteNotas> listarNotasXBimestre_3(String idalumno){
		return repository.listarNotasXBimestre_3(idalumno);
	}
	
	public List<ReporteNotas> listarNotasXBimestre_4(String idalumno){
		return repository.listarNotasXBimestre_4(idalumno);
	}
}
