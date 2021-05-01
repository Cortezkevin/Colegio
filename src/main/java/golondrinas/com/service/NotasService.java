package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.NotasRepository;
import golondrinas.com.model.Notas;

@Service
public class NotasService {

	@Autowired
	private NotasRepository repository;
	
	public List<Notas> listarNotas(){
		return repository.findAll();
	}
	
	public void registrarNotas(Notas n) {
		repository.save(n);
	}
	
	public Optional<Notas> BuscarPorId(Integer id){
		return repository.findById(id);
	}
	
}
