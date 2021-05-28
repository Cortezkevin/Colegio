package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.DetalleAlumnoRepository;
import golondrinas.com.model.DetalleAlumno;

@Service
public class DetalleAlumnoService {

	@Autowired
	private DetalleAlumnoRepository repository;
	
	public List<DetalleAlumno> listarDetalleAlumnos(String idalumno){
		return repository.listarAlumnos(idalumno);
	}
}
 