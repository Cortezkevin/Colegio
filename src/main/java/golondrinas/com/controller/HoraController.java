package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import golondrinas.com.model.Hora;
import golondrinas.com.service.HoraService;

@Controller
@RequestMapping("/Hora")
public class HoraController {

	@Autowired
	private HoraService service;

	@GetMapping("/ListaHora")
	public String ListaHora(Model model) {
		List<Hora> lst = service.listarHora();
		model.addAttribute("lsthora", lst);
		return "Hora/listadoHora";
	}

	@GetMapping("/RegistrarHora")
	public String RegistrarHora(Model model) {
		model.addAttribute("horaForm", new Hora());
		return "Hora/registroHora";
	}
	
	@PostMapping("/RegistrarHora")
	public String RegistrarHora(@ModelAttribute("horaForm") Hora horaForm) {
		service.registrarHora(horaForm);
		return "redirect:/Hora/ListaHora";
	}
}
