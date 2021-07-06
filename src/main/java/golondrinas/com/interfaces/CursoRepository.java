package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> {

	@Query(value = "{call sp_CursoXEstado()}", nativeQuery = true)
	List<Curso> listarCursoValidos();
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarCurso( :idnivel, :idgrado, :nombre, :descripcion)}", nativeQuery = true)
	void registrarCurso(@Param("idnivel") String idnivel,@Param("idgrado") String idgrado, @Param("nombre") String nombre, 
			@Param("descripcion") String descripcion);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarCurso(:idcurso, :idnivel, :idgrado, :nombre, :descripcion)}", nativeQuery = true)
	void actualizarCurso(@Param("idcurso") String idcurso, @Param("idnivel") String idnivel,
			@Param("idgrado") String idgrado, @Param("nombre") String nombre, @Param("descripcion") String descripcion);

	@Transactional
	@Modifying
	@Query(value = "{call sp_MantEliminarCurso(:idcurso)}", nativeQuery = true)
	void eliminarCurso(@Param("idcurso") String idcurso);
	
	@Query(value = "{call sp_ListarCursoXNombre(:nombre)}", nativeQuery = true)
	String validarCurso(@Param("nombre") String nombre);
	
	@Query(value = "{call sp_EstadoXCurso(:idcurso)}", nativeQuery = true)
	String ValidarEstadoCurso(@Param("idcurso") String idcurso);

}
