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
import golondrinas.com.service.DetalleAlumnoService;
import golondrinas.com.service.MatriculaService;
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
		model.addAttribute("lstpersona", pservice.listarPersonaxtipo3());
		model.addAttribute("lstusuario", uservice.listarUsuarioXR001());
		model.addAttribute("lstmatricula", mservice.listarMatriculas());
		return "Alumno/frmAlumno";
	}

	@PostMapping("/registrarAlumno")
	@ResponseBody
	public ResultadoResponse registrarAlumno(@RequestBody Alumno objAlumno) {

		String mensaje = "Alumno registrado correctamente";
		Boolean respuesta = true;

		try {
			if (service.validarPersona(objAlumno) == 0 && service.validarUsuario(objAlumno) == 0) {
				service.registrarAlumno(objAlumno);
			} else if (service.validarPersona(objAlumno) == 2) {
				mensaje = "La persona seleccionada ha sido eliminada";
				respuesta = false;
			} else if (service.validarUsuario(objAlumno) == 2) {
				mensaje = "El usuario seleccionado ha sido eliminado";
				respuesta = false;
			} else if (service.validarUsuario(objAlumno) == 1) {
				mensaje = "El usuario seleccionado ya esta siendo ocupado";
				respuesta = false;
			} else {
				mensaje = "La persona seleccionada ya esta siendo ocupada";
				respuesta = false;
			}
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
			if (service.validarEstadoAlumno(objAlumno) == false) {
				service.eliminarAlumno(objAlumno);
			} else {
				mensaje = "El Alumno a eliminar esta siendo ocupado";
				respuesta = false;
			}
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
