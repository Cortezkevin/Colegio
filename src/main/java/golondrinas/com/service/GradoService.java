package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.GradoRepository;
import golondrinas.com.model.Grado;
import golondrinas.com.model.Nivel;

@Service
public class GradoService {

	@Autowired
	private GradoRepository repository;

	public List<Grado> listarGrado() {
		return repository.findAll();
	}

	public void registrarGrado(Grado g) {
		repository.registrarGrado(g.getNombre());
	}

	public List<Grado> listarGradoValidos() {
		return repository.listarGradosValidos();
	}
	
	public void actualizarGrado(Grado g) {
		repository.actualizarGrado(g.getIdgrado(), g.getNombre(), g.getEstado());
	}

	public void eliminarGrado(Grado objGrado) {
		repository.eliminarGrado(objGrado.getIdgrado());
	}

	public boolean validarNombre(Grado obj) {
		List<Grado> listadoNombres = repository.listarGradoxNombre(obj.getNombre());
		for (Grado grado : listadoNombres) {
			if (grado.getNombre().equals(obj.getNombre())) {
				return true;
			}
			break;
		}
		return false;
	}
	
	public boolean validarEstadoGrado(Grado n){
		String lista = repository.ValidarEstadoGrado(n.getIdgrado());
		if(lista.equals("Ocupado")) {
			return true;
		}
		return false;
	}
}
