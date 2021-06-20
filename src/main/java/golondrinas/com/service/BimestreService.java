package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.BimestreRepository;
import golondrinas.com.model.Bimestres;

@Service
public class BimestreService {

	@Autowired
	private BimestreRepository repository;
	
	public List<Bimestres> listarBimestres(){
		return repository.findAll();
	}
}
