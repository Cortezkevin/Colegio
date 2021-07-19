package golondrinas.com.interfaces;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.NotaBimestre;

@Repository
public interface NotaBimestreRepository extends JpaRepository<NotaBimestre, String> {

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarNotasBimestrales(:idalumno,:idcurso,:nota_bimestre1,:nota_bimestre2,:nota_bimestre3,:nota_bimestre4,:promedio_anual)}", nativeQuery = true)
	void RegistrarNotaBimestral(@Param("idalumno") String idalumno, @Param("idcurso") String idcurso,
			@Param("nota_bimestre1") Double nota_bimestre1, @Param("nota_bimestre2") Double nota_bimestre2,
			@Param("nota_bimestre3") Double nota_bimestre3, @Param("nota_bimestre4") Double nota_bimestre4,
			@Param("promedio_anual") Double promedio_anual);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarNotasBimestrales(:idnotabimestre,:idalumno,:idcurso,:nota_bimestre1,:nota_bimestre2,:nota_bimestre3,:nota_bimestre4,:promedio_anual)}", nativeQuery = true)
	void ActualizarNotaBimestral(@Param("idnotabimestre") String idnotabimestre, @Param("idalumno") String idalumno,
			@Param("idcurso") String idcurso, @Param("nota_bimestre1") Double nota_bimestre1,
			@Param("nota_bimestre2") Double nota_bimestre2, @Param("nota_bimestre3") Double nota_bimestre3,
			@Param("nota_bimestre4") Double nota_bimestre4, @Param("promedio_anual") Double promedio_anual);

	@Query(value = "{call sp_MantListarCursoXBimestre(:idalumno, :idcurso)}", nativeQuery = true)
	String CursoXBimestre(@Param("idalumno") String idalumno, @Param("idcurso") String idcurso);
}
