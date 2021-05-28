package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.ApoderadoRepository;
import golondrinas.com.model.Apoderado;

@Service
public class ApoderadoService {

	@Autowired
	private ApoderadoRepository repository;
	
	public List<Apoderado> listarApoderado(){
		return repository.listarApoderado();
	}
}
