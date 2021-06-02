package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import golondrinas.com.interfaces.CargoRepository;
import golondrinas.com.model.Cargo;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;
	
	public List<Cargo> listarCargos(){
		return repository.listarCargos();
	}
	
	public void registrarCargo(Cargo cargo) {
		if(cargo.getIdcargo() == null ){
				repository.RegistrarCargo(cargo.getNombre());	
		}else {
			repository.ActualizarCargo(cargo.getIdcargo(),
					cargo.getNombre());
		}
	}
	public void eliminarCargo(Cargo c) {
		repository.EliminarCargo(c.getIdcargo());
	}
	
	
	//DE VALIDACION/*
	
	public boolean validarNombre(Cargo obj) {
		List<Cargo> listadoNombres = repository.listarCargoxNombre(obj.getNombre()); 
		for (Cargo cargo : listadoNombres) {
			if(cargo.getNombre().equals(obj.getNombre())) {
				return true;
			}
			break;
		}
		return false;
	}
	/*public List<Cargo> listarCargoxNombre(Cargo c){
		return repository.listarCargoxNombre(c.getNombre());
	}*/
}
