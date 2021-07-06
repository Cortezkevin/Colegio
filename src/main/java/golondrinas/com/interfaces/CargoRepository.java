package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, String>{

	@Query(value="{call sp_MantListarCargos()}",
			nativeQuery = true)
	List<Cargo> listarCargos(); 
	
	@Query(value = "{call sp_CargoXEstado()}", nativeQuery = true)
	List<Cargo> listarCargoValidos();
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantRegistrarCargo(:nombre)}",
			nativeQuery = true)
	void RegistrarCargo(@Param("nombre") String nombre);
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantActualizarCargo(:idcargo, :nombre)}",
			nativeQuery = true)
	void ActualizarCargo(@Param("idcargo") String idcargo, @Param("nombre") String nombre);
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantEliminarCargo(:idcargo)}",
			nativeQuery = true)
	void EliminarCargo(@Param("idcargo") String idcargo);
	
	
	@Query(value="{call sp_MantListarCargoxNombre(:nombre)}",nativeQuery = true)
	List<Cargo> listarCargoxNombre(@Param("nombre") String nombre);
	
	@Query(value = "{call sp_EstadoXCargo(:idcargo)}", nativeQuery = true)
	String ValidarEstadoCargo(@Param("idcargo") String idcargo);
}
