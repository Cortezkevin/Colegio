package golondrinas.com.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import golondrinas.com.model.Usuario;
import golondrinas.com.service.UserRoleService;
import golondrinas.com.service.UsuarioService;

@Controller
public class HomeController {
	
	
	@Autowired
	private UsuarioService UserService;
	
	@GetMapping({"/","/login"})
	public String holaMundo() {
		return "login";
	}
	
	@GetMapping("/menu2")
	public String menu2(Authentication auth, Model model, Usuario objusuario) {
		String cargo="";
		String UserName=auth.getName();
		for(GrantedAuthority rol:auth.getAuthorities()) {
			cargo=rol.getAuthority();
		}
		model.addAttribute("role",cargo);
		for(Object[] a : UserService.buscarUserCargo(UserName, cargo)) {
			int i=0;
			i+=1;
			System.out.println( a[0]);
			System.out.println( a[1]);
			System.out.println( a[2]);
			System.out.println( a[3]);
			System.out.println( a[4]);
			System.out.println( a[5]);
			System.out.println( a[6]);
			System.out.println(i);
		}
		model.addAttribute("listUserRole", UserService.buscarUserCargo(UserName, cargo));
		return "menu2";
	}
	@GetMapping("/Calificaciones/frmcalificaciones")
	public String Calificaciones(Authentication auth, Model model, Usuario objusuario) {
		String cargo="";
		String UserName=auth.getName();
		for(GrantedAuthority rol:auth.getAuthorities()) {
			cargo=rol.getAuthority();
		}
		model.addAttribute("role",cargo);
		model.addAttribute("listUserRole", UserService.buscarUserCargo(UserName, cargo));
		return "Calificaciones/frmcalificaciones";
	}
	@GetMapping("/Perfil/perfilEstudiante")
	public String perfilEstudiante(Authentication auth, Model model, Usuario objusuario) {
		String cargo="";
		String UserName=auth.getName();
		for(GrantedAuthority rol:auth.getAuthorities()) {
			cargo=rol.getAuthority();
		}
		model.addAttribute("role",cargo);
		model.addAttribute("listUserRole", UserService.buscarUserCargo(UserName, cargo));
		return "/Perfil/miPerfil";
	}
	@GetMapping("/Perfil/cambioContraseña")
	public String cambioContraseña(Authentication auth, Model model, Usuario objusuario) {
		String cargo="";
		String UserName=auth.getName();
		for(GrantedAuthority rol:auth.getAuthorities()) {
			cargo=rol.getAuthority();
		}
		model.addAttribute("role",cargo);
		model.addAttribute("listUserRole", UserService.buscarUserCargo(UserName, cargo));
		return "/Perfil/cambioContraseña";
	}
}
