package golondrinas.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaceService.IUsuarioService;
import golondrinas.com.interfaces.IUsuario;
import golondrinas.com.model.Usuario;


@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuario data;
	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return (List<Usuario>)data.findAll();
	}

	@Override
	public Optional<Usuario> listarId(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Usuario u) {
		data.save(u);
		return 0;
	}

	@Override
	public void delete(int userid) {
		// TODO Auto-generated method stub
		
	}

	
	
}
