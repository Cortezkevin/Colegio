package golondrinas.com.interfaces;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.AsistenciaAlumno;

@Repository
public interface AsistenciaAlumnoRepository extends JpaRepository<AsistenciaAlumno, String>{
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantAsistenciaAlumno(:idasistencia, :idalumno, :asis, :inasis, :dia)}", nativeQuery = true)
	void AsistenciaAlumno(@Param("idasistencia") String idasistencia, @Param("idalumno") String idalumno, @Param("asis") Integer asis,
			@Param("inasis") Integer inasis, @Param("dia") Integer dia);
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarAsistenciaAlumno(:idalumno, :fecha, :estado, :comentario)}", nativeQuery = true)
	void RegistrarAsistenciaAlumno(@Param("idalumno") String idalumno, @Param("fecha") String fecha,
			@Param("estado") String estado, @Param("comentario") String comentario);
	
	/*@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarAsistenciaAlumno(:idasistencia, :estado, :comentario)}", nativeQuery = true)
	void ActualizarAsistenciaAlumno(@Param("idasistencia") String idasistencia,
			@Param("estado") String estado, @Param("comentario") String comentario);*/
	
	/*@Query(value = "{call sp_MantIdAsistenciaAlumnoXFecha(:idalumno, :fecha)}", nativeQuery = true)
	String IdAsistenciaAlumnoXFecha(@Param("idalumno") String idalumno, @Param("fecha") Date fecha);*/
	
	
	@Query(value = "{call sp_MantValidarAsistenciaXFecha(:fecha, :idalumno)}", nativeQuery = true)
	List<String> validarAsistenciaXFecha(@Param("fecha") String fecha, @Param("idalumno") String idalumno);
	
	@Query(value = "{call sp_MantListarAsistenciasFaltas(:idalumno)}", nativeQuery = true)
	List<AsistenciaAlumno> asistenciaFaltas( @Param("idalumno") String idalumno);
	
	@Query(value = "{call sp_MantListarAsistenciasXAlumno(:idalumno)}", nativeQuery = true)
	List<AsistenciaAlumno> asistenciasXAlumno( @Param("idalumno") String idalumno);
	
}
