package golondrinas.com.service;

import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.transaction.annotation.Transactional;

import golondrinas.com.interfaces.CargoRepository;
import golondrinas.com.interfaces.UsuarioRepository;
import golondrinas.com.model.Cargo;
import golondrinas.com.model.Usuario;

@Service
@Transactional
public class userDetailService implements UserDetailsService{
	@Autowired
	UsuarioRepository userrepo;
	
	@Autowired
	CargoRepository cargorepo;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario appUser= userrepo.findByNombreusuario(username).orElseThrow(() -> new UsernameNotFoundException("User does not exist!"));
		UserDetails user = null;
		if(appUser.getEstado().equals("Eliminado")) {
			new UsernameNotFoundException("User does not exist!");
		}else if(appUser.getEstado().equals("Activo") || appUser.getEstado().equals("Ocupado")) {
			Set<GrantedAuthority> grantList=new HashSet<GrantedAuthority>();
			//Cargo aea= cargorepo.findAll();
		
			//System.out.println(aea);
			//Set <Cargo> aea=(Set<Cargo>) cargorepo.findAll();
			//System.out.println(aea);
			for(Cargo cargo: appUser.getRoles()) {
				System.out.println(cargo);
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(cargo.getNombre());
				
				//System.out.println(grantList+"***********************************");
	            grantList.add(grantedAuthority);
	    
			}
			 user=(UserDetails)new User(username,appUser.getContrasena(),grantList);
		}
		
		
		
		return user;
	}
	
}
