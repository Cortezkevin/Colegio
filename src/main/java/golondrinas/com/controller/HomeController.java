package golondrinas.com.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import golondrinas.com.service.AlumnoService;

import golondrinas.com.service.ReporteNotasService;
import golondrinas.com.service.UsuarioService;

@Controller
public class HomeController {

	@Autowired
	private UsuarioService Uservice;
	
	@Autowired
	private AlumnoService aservice;
	
	@Autowired
	private ReporteNotasService nservice;

	
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
	
	@GetMapping("/Calificaciones/frmcalificaciones")
	public String Calificaciones(Authentication auth, Model model) {
		
		model.addAttribute("hoy", new Date().toLocaleString());
		
		String UserName=auth.getName();
		
		model.addAttribute("listUser",Uservice.listUserLogin(UserName));
		
		String idalumno = aservice.CodigoAlumnoXUsuario(UserName);
		
		
		
		model.addAttribute("bimestre_1",nservice.listarNotasXBimestre_1(idalumno));
		
		model.addAttribute("bimestre_2",nservice.NotasBimestre_2(idalumno));
		
		model.addAttribute("bimestre_3",nservice.listarNotasXBimestre_3(idalumno));
		
		model.addAttribute("bimestre_4",nservice.listarNotasXBimestre_4(idalumno));
		
		return "Calificaciones/frmcalificaciones";
	}
	
	@GetMapping("/Perfil/perfilEstudiante")
	public String perfilEstudiante(Authentication auth, Model model) {
		String UserName=auth.getName();
		
		model.addAttribute("usuario", UserName);
		model.addAttribute("listUser",Uservice.listUserLogin(UserName));
		return "/Perfil/miPerfil";
	}
	@GetMapping("/Perfil/cambioContraseña")
	public String cambioContraseña() {
		return "/Perfil/cambioContraseña";
	}
}
