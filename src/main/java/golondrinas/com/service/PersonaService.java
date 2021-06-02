package golondrinas.com.service;

import java.util.List;
//import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.PersonaRepository;
import golondrinas.com.model.*;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository repository;

	public List<Persona> listarPersona() {
		return repository.findAll();
	}

	public void registrarPersona(Persona persona) {
		if (persona.getIdpersona() == null) {
			repository.registrarPersona(persona.getNombres(), persona.getApellidos(), persona.getDireccion(),
					persona.getTelefono(), persona.getEmail(), persona.getDni(), persona.getEdad(),
					persona.getGenero());

		} else {
			repository.actualizarPersona(persona.getIdpersona(), persona.getNombres(), persona.getApellidos(),
					persona.getDireccion(), persona.getTelefono(), persona.getEmail(), persona.getDni(),
					persona.getEdad(), persona.getGenero());
		}

	}

	public void eliminarPersona(Persona persona) {
		repository.eliminarPersona(persona.getIdpersona());
	}

	public List<Persona> listaPersonaxDNI(Persona p) {
		return repository.listarPersonaxDNI(p.getDni());
	}

	// dni, telefono, correo, //no deben ser iguales que otro


	public boolean validarTelefono(Persona p) {
		List<Persona> lista = repository.listarPersonaxTelefono(p.getTelefono());
		for (Persona persona : lista) {
			if (persona.getTelefono().equals(p.getTelefono())) {
				return true;
			}
			break;
		}
		return false;
	}

	public int validarDNI(Persona p) {
		List<Persona> lista = repository.listarPersonaxDNI(p.getDni());
		for (Persona persona : lista) {
			if (persona.getDni().equals(p.getDni())) {
				return 1;
			}
			break;
		}
		return 0;
	}

	public int validarEmail(Persona p) {
		List<Persona> lista = repository.listarPersonaxEmail(p.getEmail());
		for (Persona persona : lista) {
			if (p.getEmail().equals((persona.getEmail()))) {
				return  1;
			}
			break;
		}
		return 0;
	}

}
