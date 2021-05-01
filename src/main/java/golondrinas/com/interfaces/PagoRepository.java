package golondrinas.com.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {

}
