package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.SeccionRepository;
import golondrinas.com.model.Seccion;

@Service
public class SeccionService {

	@Autowired
	private SeccionRepository repository;
	
	public List<Seccion> listarSeccion(){
		return repository.findAll();
	}
	
	public void registrarSeccion(Seccion s) {
		repository.registrarSeccion(s.getNombre());
	}
	
	public void actualizarSeccion(Seccion s) {
		repository.actualizarSeccion(s.getIdseccion(), s.getNombre(), s.getEstado());
	}
	
	public void eliminarSeccion(Seccion s) {
		repository.eliminarSeccion(s.getIdseccion());
	}
}
