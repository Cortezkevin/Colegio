package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import golondrinas.com.model.Horario;
import golondrinas.com.service.HorarioService;

@Controller
@RequestMapping("/Horario")
public class HorarioController {

	@Autowired
	private HorarioService service;
	
	@GetMapping("/ListaHorario")
	public String ListaHorario(Model model) {
		List<Horario> lst = service.listarHorario();
		model.addAttribute("lsthorario", lst);
		return "Horario/listadoHorario";
	}

	@GetMapping("/RegistrarHorario")
	public String RegistrarHorario(Model model) {
		model.addAttribute("horarioForm", new Horario());
		return "Horario/registroHorario";
	}

	@PostMapping("/RegistrarHorario")
	public String RegistrarHorario(@ModelAttribute("horarioForm") Horario horarioForm) {
		service.registrarHorario(horarioForm);
		return "redirect:/Horario/ListaHorario";
	}
}
