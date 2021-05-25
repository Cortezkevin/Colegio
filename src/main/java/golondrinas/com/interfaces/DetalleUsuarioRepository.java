package golondrinas.com.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.DetalleUsuario;

@Repository
public interface DetalleUsuarioRepository extends JpaRepository<DetalleUsuario, String> {

	@Query(value = "{call sp_MantListarDetalleUsuario(:idusuario)}", nativeQuery = true)
	List<DetalleUsuario> listarDetalleUsuario(@Param("idusuario") String idusuario);
}
