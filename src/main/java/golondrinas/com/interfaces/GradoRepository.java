package golondrinas.com.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Integer>{

}
