package golondrinas.com.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.ProfesoresForm;

@Repository
public interface ProfesoresRepository extends JpaRepository<ProfesoresForm, Integer>{

	/*public void RegistrarProfesor(String nombre, String apellido, String dni, String email, String cargo, Integer telefono,
			String usuario, String contraseña, String estado);*/
	
}
