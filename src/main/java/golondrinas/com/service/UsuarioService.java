package golondrinas.com.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.UsuarioRepository;
import golondrinas.com.model.Usuario;


@Service
public class UsuarioService{

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> listarUsuarios(){
		return repository.listarUsuarios();
	}
	
	public void registrarUsuario(Usuario u) {
		if(u.getIdusuario() == null ) {
			repository.RegistrarUsuario(u.getNombreusuario(),u.getPassword(),u.getIdcargo(),u.getIdpersona());
		}else {
			repository.ActualizarUsuario(u.getIdusuario(),u.getNombreusuario(),u.getPassword(),u.getIdcargo(),u.getIdpersona());
		}
	}
	
	public void eliminarUsuario(Usuario u) {
		repository.EliminarUsuario(u.getIdusuario());
	}
	
	
	
}
