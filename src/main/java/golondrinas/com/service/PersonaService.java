package golondrinas.com.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.PersonaRepository;
import golondrinas.com.model.*;




@Service
public class PersonaService {

	@Autowired
	private PersonaRepository repository;
	
	public List<Persona> listarPersona(){
		return repository.findAll();
		}
	
	public void registrarPersona(Persona persona) {
		if(persona.getIdpersona() == null) {
			repository.registrarPersona(persona.getNombre(), persona.getApellido(),
					persona.getDireccion(), persona.getTelefono(), persona.getEmail(), persona.getDni(),
					persona.getEdad(), persona.getGenero(), persona.getEstado());
		
		}else {
			repository.actualizarPersona(persona.getIdpersona(), persona.getNombre(), persona.getApellido(),
					persona.getDireccion(), persona.getTelefono(), persona.getEmail(), persona.getDni(),
					persona.getEdad(), persona.getGenero());
		}
		
}
	public void eliminarPersona(Persona persona) {
		repository.eliminarPersona(persona.getIdpersona());
	}
	
}
