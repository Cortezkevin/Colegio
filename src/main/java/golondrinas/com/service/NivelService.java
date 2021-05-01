package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.NivelRepository;
import golondrinas.com.model.Nivel;

@Service
public class NivelService {

	@Autowired
	private NivelRepository repository;
	
	public List<Nivel> listarNivel(){
		return repository.findAll();
	}
	
	public void registrarNivel(Nivel n) {
		repository.save(n);
	}
	
	public Optional<Nivel> BuscarPorId(Integer id){
		return repository.findById(id);
	}
}
