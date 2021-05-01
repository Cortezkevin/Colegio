package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.CursoRepository;
import golondrinas.com.model.Curso;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;
	
	public List<Curso> listarCurso(){
		return repository.findAll();
	}
	
	public void registrarCurso(Curso c) {
		repository.save(c);
	}
	
	public Optional<Curso> listarPorId(Integer id){
		return repository.findById(id);
	}
}
