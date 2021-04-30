package golondrinas.com.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import golondrinas.com.model.Matricula;

@Controller
public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{

}
