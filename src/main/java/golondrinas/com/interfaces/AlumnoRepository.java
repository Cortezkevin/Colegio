package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import golondrinas.com.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String> {

	@Query(value = "{call sp_MantListarAlumnos()}", nativeQuery = true)
	List<Alumno> listarAlumnos();

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarAlumno(:idpersona,:idusuario,:idmatricula, :nivel, :grado, :seccion, :apoderado)}", nativeQuery = true)
	void RegistrarAlumno(@Param("idpersona") String idpersona,@Param("idusuario") String idusuario, @Param("idmatricula") String idmatricula, @Param("nivel") String nivel,
			@Param("grado") String grado, @Param("seccion") String seccion,@Param("apoderado") String apoderado);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarAlumno(:idalumno,:idpersona,:idusuario,:idmatricula, :nivel, :grado, :seccion, :apoderado)}", nativeQuery = true)
	void ActualizarAlumno(@Param("idalumno") String idalumno,@Param("idpersona") String idpersona,@Param("idusuario") String idusuario, @Param("idmatricula") String idmatricula, @Param("nivel") String nivel,
			@Param("grado") String grado, @Param("seccion") String seccion,@Param("apoderado") String apoderado);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantEliminarAlumno(:idalumno)}", nativeQuery = true)
	void EliminarAlumno(@Param("idalumno") String idalumno);
	
	
	
	@Query(value = "{call sp_ManValidarPersonaxAlumno(:idpersona)}", nativeQuery = true)
	String listarPersona(@Param("idpersona") String idpersona);
	
	/*@Query(value = "{call sp_ManValidarUsuarioxAlumno(:idusuario)}", nativeQuery = true)
	String listarUsuario(@Param("idusuario") String idusuario);
	
	@Query(value = "{call sp_ManValidarMatriculaxAlumno(:idmatricula)}", nativeQuery = true)
	String listarMatricula(@Param("idmatricula") String idmatricula);
	*/
	
}
