package golondrinas.com.interfaces;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import golondrinas.com.model.Matricula;

@Controller
public interface MatriculaRepository extends JpaRepository<Matricula, String> {

	@Query(value = "{call sp_MantListarMatriculas()}", nativeQuery = true)
	List<Matricula> listarMatricula();
	
	@Query(value = "{call sp_MantListarEstadoXPersona(:idpersona)}", nativeQuery = true)
	String listarEstado(@Param("idpersona") String idpersona);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarMatricula(:idpersona, :idapoderado, :idnivel, :idgrado, :idseccion, :nombreusuario, :contrasena, :monto ,:fecha)}", nativeQuery = true)
	void RegistrarMatricula(@Param("idpersona") String idpersona,@Param("idapoderado") String idapoderado, @Param("idnivel") String idnivel,
			@Param("idgrado") String idgrado, @Param("idseccion") String idseccion, @Param("nombreusuario") String nombreusuario,@Param("contrasena") String contrasena,
			@Param("monto") Double monto, @Param("fecha") Date fecha);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarMatriculav2(:idmatricula,:idpersona, :idapoderado, :idnivel, :idgrado, :idseccion, :nombreusuario, :contrasena, :monto ,:fecha)}", nativeQuery = true)
	void ActualizarMatricula(@Param("idmatricula") String idmatricula, @Param("idpersona") String idpersona,@Param("idapoderado") String idapoderado, @Param("idnivel") String idnivel,
			@Param("idgrado") String idgrado, @Param("idseccion") String idseccion, @Param("nombreusuario") String nombreusuario,@Param("contrasena") String contrasena,
			@Param("monto") Double monto, @Param("fecha") Date fecha);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantEliminarMatriculav2(:idmatricula)}", nativeQuery = true)
	void EliminarMatricula(@Param("idmatricula") String idmatricula);
}
