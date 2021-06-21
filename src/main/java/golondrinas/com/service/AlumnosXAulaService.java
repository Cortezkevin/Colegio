package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.AlumnosXAulaRepository;
import golondrinas.com.model.AlumnosXAula;

@Service
public class AlumnosXAulaService {

	@Autowired
	private AlumnosXAulaRepository repository;
	
	public List<AlumnosXAula> listarAlumnoxAula(String nivel, String grado, String seccion){
		return (List<AlumnosXAula>)repository.listarAlumnoxAula(nivel, grado, seccion);
	}
	
}
