package golondrinas.com.interfaces;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, String>{
	
	
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantActualizarGrado(:pidgrado, :pnombregrado, :pestado)}",
	nativeQuery=true)
	void actualizarGrado(@Param("pidgrado") String codgrado,
	@Param("pnombregrado")String pnombre,
	@Param("pestado")String estado);
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantRegistrarGrado(:nombregrado)}", nativeQuery = true)
	void registrarGrado(@Param("nombregrado")String  nombregrado);
	
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantEliminarGrado(:idgrado)}", nativeQuery = true)
	void eliminarGrado(@Param("idgrado")String idgrado);
}
