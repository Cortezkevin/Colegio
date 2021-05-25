package golondrinas.com.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.DetalleMatricula;

@Repository
public interface DetalleMatriculaRepository extends JpaRepository<DetalleMatricula, String> {

	@Query(value = "{call sp_MantListarDetalleMatriculas(:idmatricula)}", nativeQuery = true)
	List<DetalleMatricula> listarDetalleMatricula(@Param("idmatricula") String idmatricula);

}
