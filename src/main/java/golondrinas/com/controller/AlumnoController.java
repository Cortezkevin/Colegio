package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import golondrinas.com.model.Alumno;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.AlumnoService;
import golondrinas.com.service.GradoService;
import golondrinas.com.service.NivelService;
import golondrinas.com.service.PersonaService;
import golondrinas.com.service.UsuarioService;

@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

	@Autowired
	private UsuarioService uservice;
	
	@Autowired
	private GradoService gservice;
	
	@Autowired
	private NivelService nservice;

	@Autowired
	private PersonaService pservice;

	@Autowired
	private AlumnoService service;

	@GetMapping("/frmAlumno")
	public String ListaAlumno(Model model) {
		model.addAttribute("lstalumno", service.listarALumno());
		model.addAttribute("lstpersona", pservice.listarPersona());
		model.addAttribute("lstusuario", uservice.listarUsuarios());
		model.addAttribute("lstnivel", nservice.listarNivel());
		model.addAttribute("lstgrado", gservice.listarGrado());
		return "Alumno/frmAlumno";
	}

	@PostMapping("/registrarAlumno")
	@ResponseBody
	public ResultadoResponse registrarAlumno(@RequestBody Alumno objAlumno) {

		String mensaje = "Alumno registrado correctamente";
		Boolean respuesta = true;

		try {
			service.registrarAlumno(objAlumno);
		}

		catch (Exception ex) {

			mensaje = "Alumno no registrado";
			respuesta = false;
		}

		return new ResultadoResponse(respuesta, mensaje);
	}

	@GetMapping("/listarAlumnos")
	@ResponseBody
	public List<Alumno> listarAlumnos() {

		return service.listarALumno();
	}

	@DeleteMapping("/eliminarAlumno")
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
	}

}
