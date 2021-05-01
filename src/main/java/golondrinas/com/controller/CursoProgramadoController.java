package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import golondrinas.com.model.CursoProgramado;
import golondrinas.com.service.CursoProgramadoService;

@Controller
@RequestMapping("/CursoProgramado")
public class CursoProgramadoController {

	@Autowired
	private CursoProgramadoService service;
	
	@GetMapping("/ListaCursoProgramado")
	public String ListaCursoProgramado(Model model) {
		List<CursoProgramado> lst = service.listarCursoProgramado();
		model.addAttribute("lstcursoprogramado", lst);
		return "CursoProgramado/listadoCursoProgramado";
	}

	@GetMapping("/RegistrarCursoProgramado")
	public String RegistrarCursoProgramado(Model model) {
		model.addAttribute("cursoProgramadoForm", new CursoProgramado());
		return "CursoProgramado/registroCursoProgramado";
	}

	@PostMapping("/RegistrarCursoProgramado")
	public String RegistrarCursoProgramado(@ModelAttribute("cursoProgramadoForm") CursoProgramado cursoProgramadoForm) {
		service.registrarCursoProgramado(cursoProgramadoForm);
		return "redirect:/CursoProgramado/ListaCursoProgramado";
	}
}
