package golondrinas.com.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Curso;

@Repository
public interface CursoRepository  extends JpaRepository<Curso, Integer>{

}
