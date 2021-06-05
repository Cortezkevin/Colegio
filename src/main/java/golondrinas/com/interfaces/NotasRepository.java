package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import golondrinas.com.model.Notas;

@Controller
public interface NotasRepository extends JpaRepository<Notas, Integer>{

	@Query(value = "{call sp_MantListarNotas()}", nativeQuery = true)
	List<Notas> listarNotas();
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarNotas(:idalumno, :idcurso, :idnotabimestre, :examen1, :examen2, :examen3, :examen4, :promedio)}", nativeQuery = true)
	void RegistrarNotas(@Param("idalumno") String idalumno, @Param("idcurso") String idcurso, @Param("idnotabimestre") String idnotabimestre,
			@Param("examen1") Double examen1, @Param("examen2") Double examen2,@Param("examen3") Double examen3, @Param("examen4") Double examen4,
			@Param("promedio") Double promedio);
	
	@Query(value = "{call sp_MantActualizarNotas(:idnotas,:idalumno, :idcurso, :idnotabimestre, :examen1, :examen2, :examen3, :examen4, :promedio)}", nativeQuery = true)
	void ActualizarNotas(@Param("idnotas") String idnotas,@Param("idalumno") String idalumno, @Param("idcurso") String idcurso, @Param("idnotabimestre") String idnotabimestre,
			@Param("examen1") Double examen1, @Param("examen2") Double examen2,@Param("examen3") Double examen3, @Param("examen4") Double examen4,
			@Param("promedio") Double promedio);
}
