package golondrinas.com.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.ReporteNotas;

@Repository
public interface ReporteNotasRepository extends JpaRepository<ReporteNotas, String>{

	
	@Query(value = "{call sp_MantListarNotasXBimestre_1(:idalumno)}", nativeQuery = true)
	List<ReporteNotas> listarNotasXBimestre_1(@Param("idalumno") String idalumno);
	
	@Query(value = "{call sp_MantListarNotasXBimestre_2(:idalumno)}", nativeQuery = true)
	List<ReporteNotas> listarNotasXBimestre_2(@Param("idalumno") String idalumno);
	
	@Query(value = "{call sp_MantListarNotasXBimestre_3(:idalumno)}", nativeQuery = true)
	List<ReporteNotas> listarNotasXBimestre_3(@Param("idalumno") String idalumno);
	
	@Query(value = "{call sp_MantListarNotasXBimestre_4(:idalumno)}", nativeQuery = true)
	List<ReporteNotas> listarNotasXBimestre_4(@Param("idalumno") String idalumno);

}
