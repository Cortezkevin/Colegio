package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.CursoProgramadoRepository;
import golondrinas.com.model.CursoProgramado;

@Service
public class CursoProgramadoService {

	@Autowired
	private CursoProgramadoRepository repository;
	
	public List<CursoProgramado> listarCursoProgramado(){
		return repository.findAll();
	}
	
	public void registrarCursoProgramado(CursoProgramado c) {
		repository.save(c);
	}
	
	public Optional<CursoProgramado> listarPorId(Integer id){
		return repository.findById(id);
	}
}
