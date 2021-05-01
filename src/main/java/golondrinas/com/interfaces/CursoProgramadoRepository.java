package golondrinas.com.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.CursoProgramado;

@Repository
public interface CursoProgramadoRepository extends JpaRepository<CursoProgramado, Integer>{

}
