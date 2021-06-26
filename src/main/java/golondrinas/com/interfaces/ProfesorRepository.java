package golondrinas.com.interfaces;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, String>{

	@Query(value = "{call sp_MantListarProfesores()}", nativeQuery = true)
	List<Profesor> listarProfesores();

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarProfesor(:idpersona, :idusuario)}", nativeQuery = true)
	void RegistrarProfesor(@Param("idpersona") String idpersona, @Param("idusuario") String idusuario);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarProfesor(:idprofesor, :idpersona, :idusuario)}", nativeQuery = true)
	void ActualizarProfesor(@Param("idprofesor") String idprofesor, @Param("idpersona") String idpersona, @Param("idusuario") String idusuario);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantEliminarProfesor(:idprofesor)}", nativeQuery = true)
	void EliminarProfesor(@Param("idprofesor") String idprofesor);
	
	@Query(value = "{call sp_MantListarEstadoXPersona(:idpersona)}", nativeQuery = true)
	String listarEstado(@Param("idpersona") String idpersona);	
}
