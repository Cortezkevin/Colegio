package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import golondrinas.com.model.Curso;
import golondrinas.com.service.CursoService;

@Controller
@RequestMapping("/Curso")
public class CursoController {

	@Autowired
	private CursoService service;

	@GetMapping("/ListaCurso")
	public String ListaCurso(Model model) {
		List<Curso> lst = service.listarCurso();
		model.addAttribute("lstcurso", lst);
		return "Curso/listadoCurso";
	}

	@GetMapping("/RegistrarCurso")
	public String RegistrarCurso(Model model) {
		model.addAttribute("cursoForm", new Curso());
		return "Curso/registroCurso";
	}

	@PostMapping("/RegistrarCurso")
	public String RegistrarCurso(@ModelAttribute("cursoForm") Curso cursoForm) {
		service.registrarCurso(cursoForm);
		return "redirect:/Curso/ListaCurso";
	}
}
