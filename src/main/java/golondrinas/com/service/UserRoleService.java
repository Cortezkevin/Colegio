package golondrinas.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import golondrinas.com.interfaces.UserRoleRepository;


@Service
public class UserRoleService {
	
	@Autowired
	private UserRoleRepository userRepo;
	
	public void registrarUserRole(String idcargo) {
		userRepo.registrarUserRole(idcargo);
	}
	
	public void ActualizarUserRole(String idusuario,String idcargo) {
		userRepo.actualizarUserRole(idusuario, idcargo);
	}
	
}
