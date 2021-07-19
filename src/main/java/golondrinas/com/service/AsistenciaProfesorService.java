package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.AsistenciaProfesorRepository;
import golondrinas.com.model.AsistenciaProfesor;

@Service
public class AsistenciaProfesorService {

	@Autowired
	private AsistenciaProfesorRepository repository;
	
	public void RegistrarAsistenciaProfesor(AsistenciaProfesor a) {
		if(a.getIdasistenciap() == null) {
			repository.RegistrarAsistenciaProfesor(a.getIdprofesor(), a.getFecha(), a.getEstado(), a.getComentario());}
	}
	
	public boolean validarAsistenciaXFecha(AsistenciaProfesor a) {
		List<String> lista = repository.validarAsistenciaXFecha(a.getFecha(), a.getIdprofesor());
		for (String alummos : lista) {
			if (alummos.equals(a.getIdprofesor())) {
				return true;
			}
			break;
		}
		return false;
	}
}
