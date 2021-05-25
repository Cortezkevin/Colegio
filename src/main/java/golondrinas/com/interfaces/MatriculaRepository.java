package golondrinas.com.interfaces;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import golondrinas.com.model.Matricula;

@Controller
public interface MatriculaRepository extends JpaRepository<Matricula, String> {

	@Query(value = "{call sp_MantListarMatriculas()}", nativeQuery = true)
	List<Matricula> listarMatricula();

	@Query(value = "{call sp_MantRegistrarMatricula(:idalumno, :idnivel, :idgrado, :idseccion, :fecha)}", nativeQuery = true)
	void RegistrarMatricula(@Param("idalumno") String idalumno, @Param("idnivel") String idnivel,
			@Param("idgrado") String idgrado, @Param("idseccion") String idseccion, @Param("fecha") Date fecha);

	@Query(value = "{call sp_MantActualizarMatricula(:idmatricula, :idalumno, :idnivel, :idgrado, :idseccion, :fecha)}", nativeQuery = true)
	void ActualizarMatricula(@Param("idmatricula") String idmatricula, @Param("idalumno") String idalumno,
			@Param("idnivel") String idnivel, @Param("idgrado") String idgrado, @Param("idseccion") String idseccion,
			@Param("fecha") Date fecha);
	
	@Query(value = "{call sp_MantEliminarMatricula(:idmatricula)}", nativeQuery = true)
	void EliminarMatricula(@Param("idmatricula") String idmatricula);
}
