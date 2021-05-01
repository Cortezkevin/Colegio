package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import golondrinas.com.model.Nivel;
import golondrinas.com.service.NivelService;

@Controller
@RequestMapping("/Nivel")
public class NivelController {

	@Autowired
	private NivelService service;
	
	@GetMapping("/ListaNivel")
	public String ListaNivel(Model model) {
		List<Nivel> lst= service.listarNivel();
		model.addAttribute("lstnivel",lst);
		return "Nivel/listadoNivel";
	}
	
	@GetMapping("/RegistrarNivel")
	public String RegistrarNivel(Model model) {
		model.addAttribute("nivelForm", new Nivel());
		return "Nivel/registroNivel";
	}
	
	@PostMapping("/RegistrarNivel")
	public String RegistrarNivel(@ModelAttribute("nivelForm") Nivel nivelForm) {
		service.registrarNivel(nivelForm);
		return "redirect:/Nivel/ListaNivel";
	}
}
