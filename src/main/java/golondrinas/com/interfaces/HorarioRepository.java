package golondrinas.com.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer>{

}
