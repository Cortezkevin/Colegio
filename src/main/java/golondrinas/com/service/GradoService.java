package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.GradoRepository;
import golondrinas.com.model.Grado;

@Service
public class GradoService {

	@Autowired
	private GradoRepository repository;
	
	public List<Grado> listarGrado(){
		return repository.findAll() ;
	}
	
	public void registrarGrado(Grado g) {
		repository.save(g);
	}
	
	public Optional<Grado> BuscarPorId(Integer id){
		return repository.findById(id);
	}
}
