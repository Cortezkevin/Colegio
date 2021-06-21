package golondrinas.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping({"/","/login"})
	public String holaMundo() {
		return "login";
	}
	
	@GetMapping("/menu2")
	public String menu2() {
		return "menu2";
	}
	@GetMapping("/Calificaciones/frmcalificaciones")
	public String Calificaciones() {
		return "Calificaciones/frmcalificaciones";
	}
	@GetMapping("/Perfil/perfilEstudiante")
	public String perfilEstudiante() {
		return "/Perfil/miPerfil";
	}
	@GetMapping("/Perfil/cambioContraseña")
	public String cambioContraseña() {
		return "/Perfil/cambioContraseña";
	}
}
