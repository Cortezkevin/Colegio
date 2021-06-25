package golondrinas.com.interfaces;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import golondrinas.com.model.User_role;

@Repository
public interface UserRoleRepository extends JpaRepository<User_role, String>{

	@Transactional
	@Modifying
	@Query(value="{call sp_MantRegistrarRoles(:idcargo)}",
	nativeQuery = true)
	void registrarUserRole(@Param("idcargo")String idcargo);
	
	@Transactional
	@Modifying
	@Query(value="{call sp_MantActualizarUserRoles(:pidusuario,:pidcargo)}",
			nativeQuery=true)
	void actualizarUserRole(@Param("pidusuario")String idusuario,
			@Param("pidcargo")String idcargo);

	
	
	
}
