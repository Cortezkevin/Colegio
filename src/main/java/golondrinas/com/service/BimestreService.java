package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.BimestreRepository;
import golondrinas.com.model.Bimestre;
import golondrinas.com.model.Nivel;

@Service
public class BimestreService {

	@Autowired
	private BimestreRepository repository;

	public List<Bimestre> listarBimestres() {
		return repository.findAll();
	}
	
	public List<Bimestre> listarBimestreValidos() {
		return repository.listarBimestreValidos();
	}

	public void registrarBimestre(Bimestre bimestre) {

		if (bimestre.getIdbimestre() == null) {

			repository.RegistrarBimestre(bimestre.getNombre());
		}

		else {

			repository.ActualizarBimestre(bimestre.getIdbimestre(), bimestre.getNombre());
		}
	}

	public void eliminarBimestre(Bimestre b) {

		repository.EliminarBimestre(b.getIdbimestre());
	}
	
	public boolean validarNombre(Bimestre obj) {
		String Nombre = repository.validarBimestre(obj.getNombre()); 
		if(Nombre.equals(obj.getNombre())) {
			return true;
		}
		return false;
	}
	
	public boolean validarEstadoBimestre(Bimestre n){
		String lista = repository.ValidarEstadoBimestre(n.getIdbimestre());
		if(lista.equals("Ocupado")) {
			return true;
		}
		return false;
	}
}
