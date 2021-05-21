package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.NivelRepository;
import golondrinas.com.model.Nivel;

@Service
public class NivelService {

	@Autowired
	private NivelRepository repository;
	
	public List<Nivel> listarNivel(){
		return repository.listarNiveles();
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
}
