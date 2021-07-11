package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.JustificacionRepository;
import golondrinas.com.model.Justificaciones;

@Service
public class JustificacionService {

	@Autowired
	private JustificacionRepository repository;
	
	public void RegistrarJustificaion(Justificaciones j) {
		repository.RegistrarJustificacion(j.getIdasistencia(), j.getFecha_falta(), j.getFecha_justi(), j.getDescripcion());
	}
	
	public List<Justificaciones> ListarJustificaciones( String idalumno){
		return repository.ListarJustificaciones(idalumno);
	}
	
	public boolean validarJustificacion(Justificaciones j) {
		String estado = repository.validarJustificacion(j.getIdasistencia());
		if(estado.equals("Justificado")) {
			return true;
		}
		
		return false;
	}
}
