package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.ApoderadoRepository;
import golondrinas.com.model.Apoderado;
import golondrinas.com.model.Nivel;


@Service
public class ApoderadoService {

	@Autowired
	private ApoderadoRepository repository;

	public List<Apoderado> listarApoderado() {
		return repository.listarApoderado();
	}
	
	public List<Apoderado> listarApoderadoValidos() {
		return repository.listarApoderadoValidos();
	}

	public void registrarApoderado(Apoderado o) {

		if (o.getIdapoderado() == null) {

			repository.RegistrarApoderado(o.getIdpersona());
		}

		else {
			repository.ActualizarApoderado(o.getIdapoderado(), o.getIdpersona());
		}
	}

	public void elliminarApoderado(Apoderado o) {

		repository.EliminarApoderado(o.getIdapoderado());
	}

	
	public int validarEstado(Apoderado m) {
		String lista = repository.listarEstado(m.getIdpersona());
		if(lista.equals("Ocupado")) {
			return 1;
		}else if(lista.equals("Eliminado")) {
			return 2;
		}
		return 0;
	}
	
	public boolean validarEstadoApoderado(Apoderado n){
		String lista = repository.ValidarEstadoApoderado(n.getIdapoderado());
		if(lista.equals("Ocupado")) {
			return true;
		}
		return false;
	}

}
