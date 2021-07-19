package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.NivelRepository;
import golondrinas.com.model.Nivel;

@Service
public class NivelService {

	@Autowired
	private NivelRepository repository;

	public List<Nivel> listarNivel() {
		return repository.listarNiveles();
	}

	public List<Nivel> listarNivelValidos() {
		return repository.listarNivelValidos();
	}

	public void registrarNivel(Nivel n) {
		if (n.getIdnivel() == null) {

			repository.RegistrarNivel(n.getNombre());
		}

		else {

			repository.ActualizarNivel(n.getIdnivel(), n.getNombre());
		}

	}

	public void eliminarNivel(Nivel n) {

		repository.EliminarNivel(n.getIdnivel());
	}

	public boolean validarNombre(Nivel obj) {
		List<Nivel> listadoNombres = repository.ListarNivelxNombre(obj.getNombre());
		for (Nivel nivel : listadoNombres) {
			if (nivel.getNombre().equals(obj.getNombre())) {
				return true;
			}
			break;
		}
		return false;
	}

	public boolean validarEstadoNivel(Nivel n) {
		String lista = repository.ValidarEstadoNivel(n.getIdnivel());
		if (lista.equals("Ocupado")) {
			return true;
		}
		return false;
	}

}
