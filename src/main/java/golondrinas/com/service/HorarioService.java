package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.HorarioRepository;
import golondrinas.com.model.Horario;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepository repository;
	
	public List<Horario> listarHorario(){
		return repository.findAll();
	}
	
	public void registrarHorario(Horario h) {
		repository.save(h);
	}
	
	public Optional<Horario> listarPorId(Integer id){
		return repository.findById(id);
	}
}
