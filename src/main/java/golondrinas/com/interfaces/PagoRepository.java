package golondrinas.com.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, String> {

	@Query(value = "{call sp_MantListarPago()}",nativeQuery = true)
	List<Pago> listadoPagos();
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarPago(:idmatricula, :fechapago, :monto)}", nativeQuery = true)
	void RegistrarPago(@Param("idmatricula") String idmatricula,
						@Param("fechapago") String fechapago, @Param("monto") Double monto);
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarPago(:idpago,:idmatricula, :fechapago, :monto)}", nativeQuery = true)
	void ActualizarPago(@Param("idpago") String idpago,@Param("idmatricula") String idmatricula,
			@Param("fechapago") String fechapago, @Param("monto") Double monto);
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantEliminarPago(:idpago)}", nativeQuery = true)
	void EliminarPago(@Param("idpago") String idpago);
}
