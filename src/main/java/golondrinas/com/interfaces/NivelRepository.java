package golondrinas.com.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Nivel;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Integer>{

}
