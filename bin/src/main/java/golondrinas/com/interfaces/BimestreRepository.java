package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Bimestre;

@Repository
public interface BimestreRepository extends JpaRepository<Bimestre, String>{

	
	@Query(value = "{call sp_MantListarBimestre()}", nativeQuery = true)
	List<Bimestre> listarBimestre();
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantRegistrarBimestre(:nombre)}", nativeQuery = true)
	void RegistrarBimestre(@Param("nombre") String nombre);
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantActualizarBimestre(:idbimestre, :nombre)}", nativeQuery = true)
	void ActualizarBimestre(@Param("idbimestre") String idbimestre, @Param("nombre") String nombre);
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantEliminarBimestre(:idbimestre)}", nativeQuery = true)
	void EliminarBimestre(@Param("idbimestre") String idbimestre);
}
