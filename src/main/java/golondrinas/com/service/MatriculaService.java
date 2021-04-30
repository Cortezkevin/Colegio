package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.MatriculaRepository;
import golondrinas.com.model.Matricula;
import golondrinas.com.model.ProfesoresForm;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository repository;
	
	public List<Matricula> listarMatriculas(){
		return repository.findAll();
	}
	
	public void RegistrarMatricula(Matricula m) {
		repository.save(m);
	}
	
	public Optional<Matricula> BuscarPorId(Integer id){
		return repository.findById(id);
	}
	
	public void Actualizar(Matricula m) {
		repository.save(m);
	}
}
