package golondrinas.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import golondrinas.com.model.AlumnosXAula;
import golondrinas.com.model.AsistenciaAlumno;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.AlumnoService;
import golondrinas.com.service.AlumnosXAulaService;
import golondrinas.com.service.AsistenciaAlumnoService;
import golondrinas.com.service.GradoService;
import golondrinas.com.service.NivelService;
import golondrinas.com.service.SeccionService;

@Controller
@RequestMapping("/AsistenciaAlumno")
public class AsistenciaAlumnoController {

	@Autowired
	private AsistenciaAlumnoService service;
	
	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private AlumnosXAulaService alservice;
	
	@Autowired
	private NivelService nservice;
	
	@Autowired
	private GradoService gservice;
	
	@Autowired
	private SeccionService sservice;
	
	@GetMapping("/frmAsistenciaAlumno")
	public String frmAsistencia(Model model) {
		List<String> lstEstadoA = new ArrayList<String>(); 
		lstEstadoA.add("Presente");
		lstEstadoA.add("Ausente");
		lstEstadoA.add("Tarde");
		model.addAttribute("listadoAsistencia", alumnoService.listarALumno());
		model.addAttribute("lstnivel", nservice.listarNivel());
		model.addAttribute("lstgrado", gservice.listarGrado());
		model.addAttribute("lstseccion", sservice.listarSeccion());
		model.addAttribute("estado", lstEstadoA);
		return "AsistenciaAlumno/frmAsistenciaAlumno";
	}
	
	@GetMapping("/frmAlumnosxAula")
	@ResponseBody
	public List<AlumnosXAula> listarAlumno(@RequestParam("nivel") String n, @RequestParam("grado") String g,
			@RequestParam("seccion") String s, Model model) {
		model.addAttribute("lstalu", alservice.listarAlumnoxAula(n, g, s) );
		return alservice.listarAlumnoxAula(n, g, s);
	} 
	
	/*@GetMapping("/frmIdAsistenciaAlumnoXFecha")
	@ResponseBody
	public String idAsistenciaAlumnoXFecha(@RequestParam("idalumno") String a, @RequestParam("fecha") Date f, Model model) {
		return service.IdAsistenciaAlumnoXFecha(a,f);
	} 
	*/
	@PostMapping("/registrarAsistencia")
	@ResponseBody
	public ResultadoResponse registrarAsistencia(@RequestBody AsistenciaAlumno obj) {
		String mensaje = "Asistencia registrada correctamente";
		Boolean respuesta = true;
		try {
			if(service.validarAsistenciaXFecha(obj) == true) {
				mensaje = "Ya se registro la asistencia del alumno seleccionado";
				respuesta = false;
			}else {
				service.registrarAsistencia(obj);
			}

		} catch (Exception ex) {
			mensaje = "Asistencia no registrada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
}
