package golondrinas.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import golondrinas.com.service.UsuarioService;

@Controller
public class HomeController {

	@Autowired
	private UsuarioService Uservice;
	
	@GetMapping({"/","/login"})
	public String holaMundo() {
		return "login";
	}
	
	@GetMapping("/menu2")
	public String menu2(Authentication auth, Model model) {
		String UserName=auth.getName();
		model.addAttribute("listUser",Uservice.listUserLogin(UserName));
		model.addAttribute("cargo",Uservice.cargoXUsuario(UserName));
		return "menu2";
	}
	

	/*@GetMapping("/menu2")
	public String menu2( Authentication  auth, Model model) {
		String UserName=auth.getName();
		model.addAttribute("listUser",Uservice.listUserLogin(UserName));
		return "menu2";
	}*/
	@GetMapping("/Calificaciones/frmcalificaciones")
	public String Calificaciones(Authentication auth, Model model) {
		String UserName=auth.getName();
		model.addAttribute("listUser",Uservice.listUserLogin(UserName));
		return "Calificaciones/frmcalificaciones";
	}
	@GetMapping("/Perfil/perfilEstudiante")
	public String perfilEstudiante(Authentication auth, Model model) {
		String UserName=auth.getName();
		model.addAttribute("listUser",Uservice.listUserLogin(UserName));
		return "/Perfil/miPerfil";
	}
	@GetMapping("/Perfil/cambioContraseña")
	public String cambioContraseña() {
		return "/Perfil/cambioContraseña";
	}
}
