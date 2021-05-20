package golondrinas.com.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.NotaBimestre;

@Repository
public interface NotaBimestreRepository extends JpaRepository<NotaBimestre, Integer>{

}
