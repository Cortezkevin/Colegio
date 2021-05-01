package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import golondrinas.com.model.Seccion;
import golondrinas.com.service.SeccionService;

@Controller
@RequestMapping("/Seccion")
public class SeccionController {

	
	@Autowired
	private SeccionService service;
	
	@GetMapping("/ListaSeccion")
	public String ListaSeccion(Model model) {
		List<Seccion> lst= service.listarSeccion();
		model.addAttribute("lstseccion",lst);
		return "Seccion/listadoSeccion";
	}
	
	@GetMapping("/RegistrarSeccion")
	public String RegistrarSeccion(Model model) {
		model.addAttribute("seccionForm", new Seccion());
		return "Seccion/registroSeccion";
	}
	
	@PostMapping("/RegistrarSeccion")
	public String RegistrarSeccion(@ModelAttribute("seccionForm") Seccion seccionForm) {
		service.registrarSeccion(seccionForm);
		return "redirect:/Seccion/ListaSeccion";
	}
}
