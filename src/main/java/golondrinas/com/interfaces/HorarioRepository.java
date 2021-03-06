package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, String> {

	@Query(value = "{call sp_MantListarHorario(:nivel, :grado, :seccion)}", nativeQuery = true)
	List<Horario> listarHorario(@Param("nivel") String nivel, @Param("grado") String grado,
			@Param("seccion") String seccion);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarHorario(:nivel, :grado, :seccion, :dia, :curso, :hora_inicio, :hora_fin)}", nativeQuery = true)
	void RegistrarHorario(@Param("nivel") String nivel, @Param("grado") String grado, @Param("seccion") String seccion,
			@Param("dia") String dia, @Param("curso") String curso, @Param("hora_inicio") String hora_inicio,
			@Param("hora_fin") String hora_fin);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarHorario(:idhorario, :dia, :curso, :hora_inicio, :hora_fin)}", nativeQuery = true)
	void ActualizarHorario(@Param("idhorario") String horario, @Param("dia") String dia, @Param("curso") String curso,
			@Param("hora_inicio") String hora_inicio, @Param("hora_fin") String hora_fin);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantEliminarHorario(:idhorario)}", nativeQuery = true)
	void EliminarHorario(@Param("idhorario") String idhorario);

	@Query(value = "{call sp_MantValidarHorario(:curso, :dia, :nivel, :grado, :seccion)}", nativeQuery = true)
	String validarHorario(@Param("curso") String curso, @Param("dia") String dia, @Param("nivel") String nivel,
			@Param("grado") String grado, @Param("seccion") String seccion);

	@Query(value = "{call sp_MantValidarNombre(:idcurso, :idnivel, :idgrado, :idseccion, :hora_inicio, :hora_fin, :dia, :estado)}", nativeQuery = true)
	List<String> validarNombre(@Param("idcurso") String idcurso, @Param("idnivel") String idnivel,
			@Param("idgrado") String idgrado, @Param("idseccion") String idseccion,
			@Param("hora_inicio") String hora_inicio, @Param("hora_fin") String hora_fin,
			@Param("estado") String estado, @Param("dia") String dia);

}