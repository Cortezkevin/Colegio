package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import golondrinas.com.model.Notas;
import golondrinas.com.service.NotasService;

@Controller
@RequestMapping("/Notas")
public class NotasController {

	@Autowired
	private NotasService service;
	
	@GetMapping("/ListaNotas")
	public String ListaNotas(Model model) {
		List<Notas> lst = service.listarNotas();
		model.addAttribute("lstnotas",lst);
		return "Notas/listadoNotas";
	}
	
	@GetMapping("/RegistrarNotas")
	public String RegistrarNotas(Model model) {
		model.addAttribute("notasForm", new Notas());
		return "Notas/registroNotas";
	}
	
	@PostMapping("/RegistrarNotas")
	public String RegistrarNotas(@ModelAttribute("notasForm") Notas notasForm) {
		service.registrarNotas(notasForm);
		return "redirect:/Notas/ListaNotas";
	}
}
