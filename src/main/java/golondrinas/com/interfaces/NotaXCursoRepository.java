package golondrinas.com.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.NotaXCurso;
import golondrinas.com.model.Notas;

@Repository
public interface NotaXCursoRepository extends JpaRepository<NotaXCurso, String>{

	@Query(value = "{call sp_MantListarNotaxCurso(:idalumno, :idbimestre)}", nativeQuery = true)
	List<NotaXCurso> listarNotasXCurso(@Param("idalumno") String idalumno, @Param("idbimestre") String idbimestre);
	

}
