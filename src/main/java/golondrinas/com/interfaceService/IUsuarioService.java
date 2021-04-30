package golondrinas.com.interfaceService;

import java.util.List;
import java.util.Optional;


import golondrinas.com.model.Usuario;

public interface IUsuarioService {
		public List<Usuario>listar();
		public Optional<Usuario>listarId(int userid);
		public int save(Usuario u);
		public void delete(int userid);
}
