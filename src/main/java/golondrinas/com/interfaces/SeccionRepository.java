package golondrinas.com.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Seccion;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Integer>{

}
