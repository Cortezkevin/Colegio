package golondrinas.com.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.ReporteAsistenciaProfesor;

@Repository
public interface ReporteAsistenciaProfesorRepository  extends JpaRepository<ReporteAsistenciaProfesor, String>{

	@Query(value = "{call sp_MantListarReporteAsistenciasP()}", nativeQuery = true)
	List<ReporteAsistenciaProfesor> listarReporteAsistencia();
}
