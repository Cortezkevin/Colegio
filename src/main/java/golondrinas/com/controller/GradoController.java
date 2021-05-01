package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import golondrinas.com.model.Grado;
import golondrinas.com.service.GradoService;

@Controller
@RequestMapping("/Grado")
public class GradoController {
	
	@Autowired
	private GradoService service;
	
	@GetMapping("/ListaGrado")
	public String ListaGrado(Model model) {
		List<Grado> lst= service.listarGrado();
		model.addAttribute("lstgrado",lst);
		return "Grado/listadoGrado";
	}
	
	@GetMapping("/RegistrarGrado")
	public String RegistrarGrado(Model model) {
		model.addAttribute("gradoForm", new Grado());
		return "Grado/registroGrado";
	}
	
	@PostMapping("/RegistrarGrado")
	public String RegistrarGrado(@ModelAttribute("gradoForm") Grado gradoForm) {
		service.registrarGrado(gradoForm);
		return "redirect:/Grado/ListaGrado";
	}
}
