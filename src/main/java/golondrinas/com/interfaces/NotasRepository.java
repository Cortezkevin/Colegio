package golondrinas.com.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import golondrinas.com.model.Notas;

@Controller
public interface NotasRepository extends JpaRepository<Notas, Integer>{

}
