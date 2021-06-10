package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Apoderado;

@Repository
public interface ApoderadoRepository  extends JpaRepository<Apoderado, String>{

	@Query(value = "{call sp_MantListarApoderados()}", nativeQuery = true)
	List<Apoderado> listarApoderado();
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantRegistrarApoderado(:idpersona)}", nativeQuery = true)
	void RegistrarApoderado(@Param("idpersona") String idpersona);
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantActualizarApoderado(:idapoderado, :idpersona)}", nativeQuery = true)
	void ActualizarApoderado(@Param("idapoderado") String idapoderado,
			@Param("idpersona") String idpersona);
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantEliminarApoderado(:idapoderado)}", nativeQuery = true)
	void EliminarApoderado(@Param("idapoderado") String idapoderado);

	
	
	@Query(value = "{call sp_MantListarApoderadoxNombre(:nombrecompleto)}", nativeQuery = true)
	List<Apoderado> listarApoderadoxNombre(@Param("nombrecompleto") String nombrecompleto);
	
	
}
