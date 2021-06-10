package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	 public Optional<Usuario> findByNombreusuario(String nombreusuario);
	
	/*@Query(value="{call sp_MantListarUsuarios()}",
			nativeQuery = true)
	List<Usuario> listarUsuarios();
	*/
	@Query(value = "{call sp_ManSelectUsuario()}", nativeQuery = true) 
	List<Usuario> listarSelectUsuario(); 
	 
	@Transactional
	@Modifying
	@Query(value="{call sp_MantRegistrarUsuario(:nombreUsuario, :contraseña, :idcargo, :idpersona,:foto)}",
			nativeQuery = true)
	void RegistrarUsuario(@Param("nombreUsuario") String nombreUsuario, @Param("contraseña") String contraseña,
			@Param("idcargo") String idcargo, @Param("idpersona") String idpersona,
			@Param("foto")String foto);
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantActualizarUsuario(:idusuario, :nombreusuario, :contraseña,:estado, :idcargo, :idpersona,:foto)}",
			nativeQuery = true)
	void ActualizarUsuario(@Param("idusuario") String idUsuario,@Param("nombreusuario") String nombreUsuario, @Param("contraseña") String contraseña,
			@Param("estado")String estado,@Param("idcargo") String idcargo, @Param("idpersona") String idpersona,@Param("foto")String foto);
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantEliminarUsuario(:idusuario)}",
			nativeQuery = true)
	void EliminarUsuario(@Param("idusuario") String idUsuario);
}
