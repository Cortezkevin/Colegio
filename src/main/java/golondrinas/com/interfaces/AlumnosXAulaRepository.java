package golondrinas.com.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.AlumnosXAula;

@Repository
public interface AlumnosXAulaRepository  extends JpaRepository<AlumnosXAula, String>{

	@Query(value = "{call sp_MantListarAlumnosxAula(:nivel, :grado, :seccion)}", nativeQuery = true)
	List<AlumnosXAula> listarAlumnoxAula(@Param("nivel") String nivel,
			@Param("grado") String grado, @Param("seccion") String seccion);
	
}
