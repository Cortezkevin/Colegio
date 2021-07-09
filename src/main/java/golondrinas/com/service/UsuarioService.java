package golondrinas.com.service;

import java.util.Collection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.UsuarioRepository;
import golondrinas.com.model.Apoderado;
import golondrinas.com.model.Persona;
import golondrinas.com.model.Usuario;


@Service
public class UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> listarUsuarios(){
		return (List<Usuario>) repository.findAll();
	}
	
	public List<Usuario> listarUsuarioXR001(){
		return repository.listarUsuarioXR001();
	}
	
	public List<Usuario> listarUsuarioXR002(){
		return repository.listarUsuarioXR002();
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
	
	public boolean validarEstado(Usuario p) {
		String lista = repository.validarUsuario(p.getIdusuario());
		if(lista.equals("Ocupado")) {
			return true;
		}
		return false;
	}
	
	
	public Collection<Object[]>listUserLogin(String idusuario){
		return (Collection<Object[]>) repository.listUserLogin(idusuario);
	}
	
	public String cargoXUsuario(String usuario) {
		return repository.cargoXUsuario(usuario);
	}
	

}
