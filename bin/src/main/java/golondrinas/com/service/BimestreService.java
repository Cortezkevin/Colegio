package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.BimestreRepository;
import golondrinas.com.model.Bimestre;

@Service
public class BimestreService {

	
	@Autowired
	private BimestreRepository repository;
	
	public List<Bimestre> listarBimestre(){
		
		return repository.listarBimestre();
	}
	
	public void registrarBimestre(Bimestre bimestre) {
		
		if(bimestre.getIdbimestre() == null) {
			
			repository.RegistrarBimestre(bimestre.getNombre());
		}
		
		else {
			
			repository.ActualizarBimestre(bimestre.getIdbimestre(), bimestre.getNombre());
		}
	}
	
	public void eliminarBimestre(Bimestre b) {
		
		repository.EliminarBimestre(b.getIdbimestre());
	}
	
	
}
