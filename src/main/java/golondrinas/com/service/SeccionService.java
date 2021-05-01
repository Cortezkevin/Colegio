package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.SeccionRepository;
import golondrinas.com.model.Seccion;

@Service
public class SeccionService {

	@Autowired
	private SeccionRepository repository;
	
	public List<Seccion> listarSeccion(){
		return repository.findAll();
	}
	
	public void registrarSeccion(Seccion s) {
		repository.save(s);
	}
	
	public Optional<Seccion> BuscarPorId(Integer id){
		return repository.findById(id);
	}
}
