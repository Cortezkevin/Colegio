package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Justificaciones;

@Repository
public interface JustificacionRepository extends JpaRepository<Justificaciones, String>{

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarJustificacion(:idasistencia, :fecha_falta, :fecha_justi, :descripcion)}", nativeQuery = true)
	void RegistrarJustificacion(@Param("idasistencia") String idasistencia,@Param("fecha_falta") String fecha_falta,
			@Param("fecha_justi") String fecha_justi,@Param("descripcion") String descripcion);
	
	@Query(value = "{call sp_MantListarJustificacion(:idalumno)}", nativeQuery = true) 
	List<Justificaciones> ListarJustificaciones(@Param("idalumno") String idalumno);
	
	@Query(value = "{call sp_MantValidarJustificacion(:idasistencia)}", nativeQuery = true)
	String validarJustificacion(@Param("idasistencia") String idasistencia);
}
