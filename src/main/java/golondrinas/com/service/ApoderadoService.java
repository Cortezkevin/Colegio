package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.ApoderadoRepository;
import golondrinas.com.model.Apoderado;

@Service
public class ApoderadoService {

	@Autowired
	private ApoderadoRepository repository;
	
	public List<Apoderado> listarApoderado(){
		return repository.listarApoderado();
	}
	
	
	public void registrarApoderado(Apoderado o) {
		
		if(o.getIdapoderado() == null) {
			
			repository.RegistrarApoderado(o.getIdpersona());
		}
		
		else {
			repository.ActualizarApoderado(o.getIdapoderado(), o.getIdpersona());
		}
	}
	
		public void elliminarApoderado(Apoderado o) {
				
			repository.EliminarApoderado(o.getIdapoderado());
		}
		
		
		/*Validacion*/
		
		/*public boolean validarNombre(Apoderado obj) {
			
			List<Apoderado> listadoNombres = repository.listarApoderadoxNombre(obj.getNombrecompleto());
			for(Apoderado Apoderado : listadoNombres) {
				
				if(Apoderado.getNombrecompleto().equals(obj.getNombrecompleto())){
					return true;
				}
				break;
			}
			
			return false;
		}*/
		
		
}
