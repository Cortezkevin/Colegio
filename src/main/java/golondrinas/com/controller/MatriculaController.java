package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import golondrinas.com.model.Matricula;
import golondrinas.com.model.Nivel;
import golondrinas.com.service.GradoService;
import golondrinas.com.service.MatriculaService;
import golondrinas.com.service.NivelService;
import golondrinas.com.service.SeccionService;

@Controller
@RequestMapping("/Matriculas")
public class MatriculaController {

	@Autowired
	private MatriculaService service;
	
	@Autowired
	private NivelService nService;
	
	@Autowired
	private GradoService gService;
	
	@Autowired
	private SeccionService sService;
	
	@GetMapping("/ListadoMatricula") 
	public String ListaMatricula(Model model) {
		List<Matricula> lstMatriculas = service.listarMatriculas();
		model.addAttribute("lstMat",lstMatriculas);
		return "Matriculas/listadoMatriculas";
	}
	
	@GetMapping("/RegistrarMatricula")
	public String RegistrarMatricula(Model model) {
		model.addAttribute("lstNivel",nService.listarNivel());
		model.addAttribute("lstGrado",gService.listarGrado());
		model.addAttribute("lstSeccion",sService.listarSeccion());
		model.addAttribute("matriculaForm",new Matricula());
		return "Matriculas/registrarMatricula";
	}
	
	@PostMapping("/RegistrarMatricula")
	public String RegistrarMatricula(@ModelAttribute("matriculaForm") Matricula matriculaForm) {
		service.RegistrarMatricula(matriculaForm);
		return "redirect:/Matriculas/ListadoMatricula";
	}
	
	
}
