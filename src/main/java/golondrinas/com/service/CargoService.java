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
	/*
	public void registrarCargo(Cargo c) {
		repository.RegistrarCargo(c.getNombre());
	}*/
	
	public void registrarCargo(Cargo cargo) {
		if(cargo.getIdcargo() == null ){
				repository.RegistrarCargo(cargo.getNombre());	
		}else {
			repository.ActualizarCargo(cargo.getIdcargo(),
					cargo.getNombre());
		}
	}
	/*
	public void actulizarCargo(Cargo c) {
		repository.ActualizarCargo(c.getIdcargo(), c.getNombre());
	}*/
	
	public void eliminarCargo(Cargo c) {
		repository.EliminarCargo(c.getIdcargo());
	}
	
	
	//PRUEBA DE VALIDACION/*
	
	/*
	public boolean validarNombre(String nombre) {
		List<Cargo> listadoNombres = repository.listarCargoxNombre(); 
		for (Cargo cargo : listadoNombres) {
			if(cargo.getNombre().equals(nombre)) {
				return true;
			}	
		}
		return false;
	}
	*/
	

	/*public List<Cargo> listarCargoxNombre(Cargo c){
		return repository.listarCargoxNombre(c.getNombre());
	}
	
	public List<Cargo> listarCargoNombre(){
		return repository.listarCargoxNombre();
	}
	*/
}
