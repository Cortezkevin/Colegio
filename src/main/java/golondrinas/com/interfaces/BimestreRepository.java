package golondrinas.com.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.Bimestres;

@Repository
public interface BimestreRepository extends JpaRepository<Bimestres, String>{
	
}
