package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import golondrinas.com.model.AlumnosXAula;
import golondrinas.com.model.Notas;

@Controller
public interface NotasRepository extends JpaRepository<Notas, String>{
	
	@Query(value = "{call sp_MantListarNotas()}", nativeQuery = true)
	List<Notas> listarNotas();
	
	/*@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarNotas(:idalumno, :idcurso, :idnotabimestre, :examen1, :examen2, :examen3, :examen4, :promedio)}", nativeQuery = true)
	void RegistrarNotas(@Param("idalumno") String idalumno, @Param("idcurso") String idcurso, @Param("idnotabimestre") String idnotabimestre,
			@Param("examen1") Double examen1, @Param("examen2") Double examen2,@Param("examen3") Double examen3, @Param("examen4") Double examen4,
			@Param("promedio") Double promedio);*/
	

	@Transactional
	@Modifying
	@Query(value = "{call  sp_RegistrarNotaxCurso(:idalumno, :idcurso, :examen1, :examen2, :examen3, :examen4, :promedio)}", nativeQuery = true)
	void RegistrarNotasv2(@Param("idalumno") String idalumno,@Param("idcurso") String idcurso,  @Param("examen1") Double examen1, @Param("examen2") Double examen2,@Param("examen3") Double examen3, @Param("examen4") Double examen4,
			@Param("promedio") Double promedio);

	
	@Transactional
	@Modifying
	@Query(value = "{call sp_ActualizarNotaxCurso(:idnota,:idalumno, :idcurso, :examen1, :examen2, :examen3, :examen4, :promedio)}", nativeQuery = true)
	void ActualizarNotasv2(@Param("idnota") String idnota, @Param("idalumno") String idalumno,@Param("idcurso") String idcurso,
			@Param("examen1") Double examen1, @Param("examen2") Double examen2,@Param("examen3") Double examen3, @Param("examen4") Double examen4,
			@Param("promedio") Double promedio);
	
	
	/*@Transactional
	@Modifying
	@Query(value = "{call sp_ActualizarNotaxCursoV2(:idnota, :examen1, :examen2, :examen3, :examen4, :promedio)}", nativeQuery = true)
	void ActualizarN(@Param("idnota") String idnota,
			@Param("examen1") Double examen1, @Param("examen2") Double examen2,@Param("examen3") Double examen3, @Param("examen4") Double examen4,
			@Param("promedio") Double promedio);*/
	
	
	
}
