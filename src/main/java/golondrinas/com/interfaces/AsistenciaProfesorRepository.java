package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.AsistenciaProfesor;

@Repository
public interface AsistenciaProfesorRepository extends JpaRepository<AsistenciaProfesor, String> {
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarAsistenciaProfesor(:idprofesor, :fecha, :estado, :comentario)}", nativeQuery = true)
	void RegistrarAsistenciaProfesor(@Param("idprofesor") String idprofesor,@Param("fecha") String fecha,@Param("estado") String estado,
			@Param("comentario") String comentario);

	
	@Query(value = "{call sp_MantValidarAsistenciaXFechaProfesor(:fecha, :idprofesor)}", nativeQuery = true)
	List<String> validarAsistenciaXFecha(@Param("fecha") String fecha, @Param("idprofesor") String idprofesor);
}
