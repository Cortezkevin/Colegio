package golondrinas.com.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Hora;

@Repository
public interface HoraRepository extends JpaRepository<Hora, Integer>{

}
