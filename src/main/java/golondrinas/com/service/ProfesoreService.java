package golondrinas.com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.model.Apoderado;
import golondrinas.com.model.Profesor;
import golondrinas.com.interfaces.ProfesorRepository;


@Service
public class ProfesoreService {

	@Autowired
	private ProfesorRepository repository;
	
	public List<Profesor> listarProfesor(){
		return repository.listarProfesores();
	}
	
	public void RegistrarProfesor(Profesor p) {
		if(p.getIdprofesor() == null) {
			
			repository.RegistrarProfesor(p.getIdpersona(), p.getIdusuario());
		}
		
		else {
			
			repository.ActualizarProfesor(p.getIdprofesor(), p.getIdpersona(), p.getIdusuario());
		}
	}
	
	public void eliminarProfesor(Profesor p) {
		
		repository.EliminarProfesor(p.getIdprofesor());
	}


	public boolean validarEstado(Profesor m) {
		String lista = repository.listarEstado(m.getIdpersona());
		if (lista.equals("Ocupado")) {
			return true;
		}
		return false;
	}
}
