package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	@Query(value="{call sp_MantListarUsuarios()}",
			nativeQuery = true)
	List<Usuario> listarUsuarios();
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantRegistrarUsuario(:nombreUsuario, :contraseña, :idcargo, :idpersona)}",
			nativeQuery = true)
	void RegistrarUsuario(@Param("nombreUsuario") String nombreUsuario, @Param("contraseña") String contraseña,
			@Param("idcargo") String idcargo, @Param("idpersona") String idpersona);
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantActualizarUsuario(:idusuario, :nombreusuario, :contraseña, :idcargo, :idpersona)}",
			nativeQuery = true)
	void ActualizarUsuario(@Param("idusuario") String idUsuario,@Param("nombreusuario") String nombreUsuario, @Param("contraseña") String contraseña,
			@Param("idcargo") String idcargo, @Param("idpersona") String idpersona);
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantEliminarUsuario(:idusuario)}",
			nativeQuery = true)
	void EliminarUsuario(@Param("idusuario") String idUsuario);
}
