package golondrinas.com.service;

import java.util.Collection;
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
		return (List<Usuario>) repository.findAll();
	}
	
	public List<Usuario> listarSelectUsuario(){
		return repository.listarSelectUsuario();
	}
	public void registrarUsuario(Usuario u) {
			repository.RegistrarUsuario(u.getNombreusuario(),u.getContrasena(),u.getIdcargo(),u.getIdpersona(),u.getFoto());
	}
	
	public void eliminarUsuario(Usuario u) {
		repository.EliminarUsuario(u.getIdusuario());
	}
	
	public void actualizarUsuario(Usuario u) {
		repository.ActualizarUsuario(u.getIdusuario(),u.getNombreusuario(),u.getContrasena(),u.getEstado(),u.getIdcargo(),u.getIdpersona(),u.getFoto());
	}
	public Collection<Object[]> buscarUserCargo(String nomUsuario, String cargo) {
		return (Collection<Object[]>) repository.buscarUserCargo(nomUsuario, cargo);
		}
}
