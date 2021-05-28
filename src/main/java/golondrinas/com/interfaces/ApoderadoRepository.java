package golondrinas.com.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Apoderado;

@Repository
public interface ApoderadoRepository  extends JpaRepository<Apoderado, String>{

	@Query(value = "{call sp_MantListarApoderados()}", nativeQuery = true)
	List<Apoderado> listarApoderado();
	
	
}
