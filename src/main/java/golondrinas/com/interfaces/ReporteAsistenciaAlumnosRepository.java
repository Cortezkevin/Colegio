package golondrinas.com.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.ReporteAsistenciaAlumnos;

@Repository
public interface ReporteAsistenciaAlumnosRepository extends JpaRepository<ReporteAsistenciaAlumnos, String>{

	@Query(value = "{call sp_MantListarReporteAsistencias(:nivel, :grado, :seccion)}", nativeQuery = true)
	List<ReporteAsistenciaAlumnos> listarReporteAsistenciaAlumnos(@Param("nivel") String nivel,
			@Param("grado") String grado,@Param("seccion") String seccion);
}
