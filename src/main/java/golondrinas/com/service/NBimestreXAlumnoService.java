package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.NBimestreXAlumnoRepository;
import golondrinas.com.model.NBimestreXAlumno;

@Service
public class NBimestreXAlumnoService {

	@Autowired
	private NBimestreXAlumnoRepository repository;
	
	public List<NBimestreXAlumno> listarNotaBimestreXAlumno(String idalumno){
		return repository.listarNotaBimestreXAlumno(idalumno);
	}
}
