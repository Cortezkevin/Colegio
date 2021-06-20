package golondrinas.com.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.NBimestreXAlumno;

@Repository
public interface NBimestreXAlumnoRepository extends JpaRepository<NBimestreXAlumno, String>{

	@Query(value = "{call sp_MantListarNotaBimestre(:idalumno)}", nativeQuery = true)
	List<NBimestreXAlumno> listarNotaBimestreXAlumno(@Param("idalumno") String idalumno);


}
