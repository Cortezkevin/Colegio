package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.NotaXCursoRepository;
import golondrinas.com.model.NotaXCurso;

@Service
public class NotaXCursoService {

	@Autowired
	private NotaXCursoRepository repository;
	
	
	public List<NotaXCurso> listarNotaXCurso(String idalumno, String idbimestre){
		return repository.listarNotasXCurso(idalumno, idbimestre);
	}
	
	
}
