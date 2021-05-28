package golondrinas.com.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.DetalleAlumno;

@Repository
public interface DetalleAlumnoRepository extends JpaRepository<DetalleAlumno, String> {

	@Query(value = "{call  sp_MantListarDetalleAlumno(:idalumno)}", nativeQuery = true )
	List<DetalleAlumno> listarAlumnos(@Param("idalumno") String idalumno);
	
}
