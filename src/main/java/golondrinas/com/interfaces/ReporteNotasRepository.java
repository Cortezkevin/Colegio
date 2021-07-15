package golondrinas.com.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.ReporteNotas;

@Repository
public interface ReporteNotasRepository extends JpaRepository<ReporteNotas, String>{

	
	@Query(value = "{call sp_MantListarNotasXBimestre1(:idalumno)}", nativeQuery = true)
	List<ReporteNotas> listarNotasXBimestre1(@Param("idalumno") String idalumno);
	
	@Query(value = "{call sp_MantListarNotasXBimestre2(:idalumno)}", nativeQuery = true)
	List<ReporteNotas> listarNotasXBimestre2(@Param("idalumno") String idalumno);
	
	@Query(value = "{call sp_MantListarNotasXBimestre3(:idalumno)}", nativeQuery = true)
	List<ReporteNotas> listarNotasXBimestre3(@Param("idalumno") String idalumno);
	
	@Query(value = "{call sp_MantListarNotasXBimestre4(:idalumno)}", nativeQuery = true)
	List<ReporteNotas> listarNotasXBimestre4(@Param("idalumno") String idalumno);

}
