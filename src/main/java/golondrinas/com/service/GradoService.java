package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.GradoRepository;
import golondrinas.com.model.Grado;

@Service
public class GradoService {

	@Autowired
	private GradoRepository repository;
	
	public List<Grado> listarGrado(){
		return repository.findAll() ;
	}
	
	public void registrarGrado(Grado g) {
			repository.registrarGrado(g.getNombre());
	}
	
	/*public Optional<Grado> BuscarPorId(String id){
		return repository.findById(id);
	}*/
	public void actualizarGrado(Grado g) {
			repository.actualizarGrado(g.getIdgrado(), g.getNombre(),g.getEstado());
	}
	
	public void eliminarGrado(Grado objGrado) {
		repository.eliminarGrado(objGrado.getIdgrado());
	}
}
