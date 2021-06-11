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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import golondrinas.com.model.Alumno;
import golondrinas.com.model.DetalleAlumno;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.AlumnoService;
import golondrinas.com.service.ApoderadoService;
import golondrinas.com.service.DetalleAlumnoService;
import golondrinas.com.service.GradoService;
import golondrinas.com.service.MatriculaService;
import golondrinas.com.service.NivelService;
import golondrinas.com.service.PersonaService;
import golondrinas.com.service.UsuarioService;

@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

	@Autowired
	private UsuarioService uservice;
	
	@Autowired
	private PersonaService pservice;

	@Autowired
	private AlumnoService service;

	@Autowired
	private MatriculaService mservice;
	
	@Autowired
	private DetalleAlumnoService daservice;

	@GetMapping("/frmAlumno")
	public String ListaAlumno(Model model) {
		model.addAttribute("lstalumno", service.listarALumno());
		model.addAttribute("lstpersona", pservice.listarPersona());
		model.addAttribute("lstusuario", uservice.listarUsuarios());
		model.addAttribute("lstmatricula", mservice.listarMatriculas());
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
	
	@GetMapping("/listarDetalleAlumno")
	@ResponseBody
	public List<DetalleAlumno> listarDetalleAlumnos(@RequestParam("idalumno") String idalumno) {
		return daservice.listarDetalleAlumnos(idalumno);
	}

}
