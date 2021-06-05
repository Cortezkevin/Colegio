package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import golondrinas.com.model.Alumno;
import golondrinas.com.model.Notas;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.AlumnoService;
import golondrinas.com.service.CursoService;
import golondrinas.com.service.NotaBimestreService;
import golondrinas.com.service.NotasService;

@Controller
@RequestMapping("/Notas")
public class NotasController {

	@Autowired
	private NotasService service;

	@Autowired
	private AlumnoService aservice;

	@Autowired
	private CursoService cservice;

	@Autowired
	private NotaBimestreService nbservice;

	@GetMapping("/frmNotas")
	public String frmNotas(Model model) {
		List<Notas> lst = service.listarNotas();
		model.addAttribute("lstnotas", lst);
		model.addAttribute("lstalumnos", aservice.listarALumno());
		model.addAttribute("lstcursos", cservice.listarCurso());
		model.addAttribute("lstnotasbimestre", nbservice.listarNotaBimestre());
		return "Notas/frmNotas";
	}

	@PostMapping("/registrarNotas")
	@ResponseBody
	public ResultadoResponse registrarNotas(@RequestBody Notas objnota) {
		String mensaje = "Nota registrada correctamente";
		Boolean respuesta = true;
		try {		
			service.registrarNotas(objnota);
		}
		catch (Exception ex) {
			mensaje = "Nota no registrada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	@GetMapping("/listarNotas")
	@ResponseBody
	public List<Notas> listarNotas() {

		return service.listarNotas();
	}
/*
	@DeleteMapping("/eliminarNota")
	@ResponseBody
	public ResultadoResponse eliminarAlumno(@RequestBody Alumno objAlumno) {

		String mensaje = "Alumnon elimando correctamente";
		Boolean respuesta = true;

		try {
			service.eliminarAlumno(objAlumno);
		}

		catch (Exception ex) {

			mensaje = "Alumno no eliminado";
			respuesta = false;
		}

		return new ResultadoResponse(respuesta, mensaje);
	}*/
}
