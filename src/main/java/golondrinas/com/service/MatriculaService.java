package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.MatriculaRepository;
import golondrinas.com.model.Matricula;
import golondrinas.com.model.ProfesoresForm;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository repository;
	
	public List<Matricula> listarMatriculas(){
		return repository.listarMatricula();
	}
	
	public void RegistrarMatricula(Matricula m) {
		if(m.getIdmatricula() == null) {
			repository.RegistrarMatricula(m.getIdalumno(), m.getIdnivel(), m.getIdgrado(), m.getIdseccion(), m.getFecha());  //(m.getIdalumno(), m.getIdnivel(), m.getIdgrado(), m.getIdseccion(), m.getFecha());
		}else {
			repository.ActualizarMatricula(m.getIdmatricula(),m.getIdalumno(), m.getIdnivel(), m.getIdgrado(), m.getIdseccion(), m.getFecha());
		}
	}
	
	
	public void EliminarMatricula(Matricula m) {
		repository.EliminarMatricula(m.getIdmatricula());
	}
}
