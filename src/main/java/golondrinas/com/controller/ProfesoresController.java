package golondrinas.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import golondrinas.com.model.ProfesoresForm;
import golondrinas.com.service.ProfesoresService;

@Controller
@RequestMapping("/Profesores")
public class ProfesoresController {

	@Autowired
	private ProfesoresService service; 
	
	@GetMapping("/Listado")
	public String ListadoProfesores(Model model) {
		List<ProfesoresForm> profesores=service.listarProfesores();
		model.addAttribute("lstprofesores", profesores);
		return "Profesores/listadoProfesores";
	};
	
	@GetMapping("/RegistrarProfesores")
	public String RegistrarProfesores(Model model) {	
		model.addAttribute("registrarprofesorform", new ProfesoresForm());
		return "Profesores/registrarProfesores"; 
	}
	
	@PostMapping("/RegistrarProfesores")
	public String RegistrarProfesores(@ModelAttribute("registrarprofesorform") ProfesoresForm registrarProfesorForm,
			Model model) {
		service.RegistrarProfesores(registrarProfesorForm);
		return "redirect:/Profesores/Listado";
	}
	@GetMapping("/EditarProfesores")
	public String EditarProfesores(Model model, @PathVariable Integer idProfesor ) {
		Optional<ProfesoresForm> profesormodel = service.BuscarPorId(idProfesor);
		model.addAttribute("profesor", profesormodel);
		return "Profesores/editarProfesores";
	}
	@PostMapping("/EditarProfesores")
	public String EditarProfesores(@PathVariable Integer idProfesor, Model model ) {
		Optional<ProfesoresForm> profesormodel = service.BuscarPorId(idProfesor);
		model.addAttribute("profesor", profesormodel);
		return "Profesores/editarProfesores";
	}
}
