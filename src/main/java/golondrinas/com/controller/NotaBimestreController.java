package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import golondrinas.com.model.NotaBimestre;
import golondrinas.com.service.NotaBimestreService;

@Controller
@RequestMapping("/NotaBimestre") 
public class NotaBimestreController {
/*
	@Autowired
	private NotaBimestreService service;

	@GetMapping("/ListaNotaBimestre")
	public String ListaNotaBimestre(Model model) {
		List<NotaBimestre> lst = service.listarNotaBimestre();
		model.addAttribute("lstnotabimestre", lst);
		return "NotaBimestre/listadoNotaBimestre";
	}

	@GetMapping("/RegistrarNotaBimestre")
	public String RegistrarNotaBimestre(Model model) {
		model.addAttribute("notaBimestreForm", new NotaBimestre());
		return "NotaBimestre/registroNotaBimestre";
	}

	@PostMapping("/RegistrarNotaBimestre")
	public String RegistrarNotaBimestre(@ModelAttribute("notaBimestreForm") NotaBimestre notaBimestreForm) {
		service.registrarNotaBimestre(notaBimestreForm);
		return "redirect:/NotaBimestre/ListaNotaBimestre";
	}*/
}
