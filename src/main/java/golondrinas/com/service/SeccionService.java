package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.SeccionRepository;
import golondrinas.com.model.Seccion;

@Service
public class SeccionService {

	@Autowired
	private SeccionRepository repository;

	public List<Seccion> listarSeccion() {
		return repository.findAll();
	}

	public List<Seccion> listarSeccionValidos() {
		return repository.listarSeccionValidos();
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

	public boolean validarNombre(Seccion obj) {
		List<Seccion> listadoNombres = repository.listarSeccionxNombre(obj.getNombre());
		for (Seccion seccion : listadoNombres) {
			if (seccion.getNombre().equals(obj.getNombre())) {
				return true;
			}
			break;
		}
		return false;
	}

	public boolean validarEstadoSeccion(Seccion n) {
		String lista = repository.ValidarEstadoSeccion(n.getIdseccion());
		if (lista.equals("Ocupado")) {
			return true;
		}
		return false;
	}
}
