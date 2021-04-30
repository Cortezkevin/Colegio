package golondrinas.com.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Usuario;

@Repository
public interface IUsuario extends CrudRepository<Usuario, Integer> {

}
