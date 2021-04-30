package golondrinas.com.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.model.ProfesoresForm;
import golondrinas.com.interfaces.ProfesoresRepository;

@Service
public class ProfesoresService {

	@Autowired
	private ProfesoresRepository repository;
	
	public List<ProfesoresForm> listarProfesores(){
		return repository.findAll();
	}
	
	public void RegistrarProfesores(ProfesoresForm profe) {
		repository.save(profe);
	}
	
	public Optional<ProfesoresForm> BuscarPorId(Integer id){
		return repository.findById(id);
	}
	
	public void Actualizar(ProfesoresForm profe) {
		repository.save(profe);
	}
	/*
	public Optional<ProfesoresForm> BuscarProfesor(Integer codigo) {
		Optional<ProfesoresForm> profesores = repository.findById(codigo);
		return profesores;
	}*/
}
