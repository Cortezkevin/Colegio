package golondrinas.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.DetalleUsuarioRepository;
import golondrinas.com.model.DetalleUsuario;

@Service
public class DetallerUsuarioService {

	@Autowired
	private DetalleUsuarioRepository repository;
	
	public List<DetalleUsuario> listarDetalleUsuario(String idusuario){
		return repository.listarDetalleUsuario(idusuario);
	}
}
