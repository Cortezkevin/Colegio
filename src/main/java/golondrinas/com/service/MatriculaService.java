package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.MatriculaRepository;
import golondrinas.com.model.Matricula;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class MatriculaService {


	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Autowired
	private MatriculaRepository repository;
	
	public List<Matricula> listarMatriculas(){
		return repository.listarMatricula();
	}
	
	public void RegistrarMatricula(Matricula m) {
		if(m.getIdmatricula() == null) {
			repository.RegistrarMatricula(m.getIdpersona(),m.getIdapoderado(), m.getIdnivel(), 
					m.getIdgrado(), m.getIdseccion(),m.getNombreusuario(), encoder.encode(m.getContrasena()), m.getMonto(), m.getFecha());  
		}else {
			repository.ActualizarMatricula(m.getIdmatricula(),m.getIdpersona(),m.getIdapoderado(), m.getIdnivel(), 
					m.getIdgrado(), m.getIdseccion(),m.getNombreusuario(), encoder.encode(m.getContrasena()), m.getMonto(), m.getFecha());
		}
	}
	
	
	public void EliminarMatricula(Matricula m) {
		repository.EliminarMatricula(m.getIdmatricula());
	}
	
	
	public int validarEstado(Matricula m) {
		String lista = repository.listarEstado(m.getIdpersona());
		if(lista.equals("Ocupado")) {
			return 1;
		}else if(lista.equals("Eliminado")) {
			return 2;
		}
		return 0;
	}
	
	public boolean validarNombreUsuario(Matricula m) {
		String nombre = repository.ListarNombreUsuario(m.getNombreusuario());
		if(nombre.equals(m.getNombreusuario())) {
			return true;
		}
		return false;
	}
}
