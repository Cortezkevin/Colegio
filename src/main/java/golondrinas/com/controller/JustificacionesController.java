package golondrinas.com.controller;

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
import golondrinas.com.model.Justificaciones;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.AlumnosXAulaService;
import golondrinas.com.service.AsistenciaAlumnoService;
import golondrinas.com.service.GradoService;
import golondrinas.com.service.JustificacionService;
import golondrinas.com.service.NivelService;
import golondrinas.com.service.SeccionService;

@Controller
@RequestMapping("/Justificaciones")
public class JustificacionesController {

	@Autowired
	private JustificacionService service;
	
	@Autowired
	private AlumnosXAulaService alservice;
	
	@Autowired
	private AsistenciaAlumnoService aaservice;
	
	@Autowired
	private NivelService nservice;
	
	@Autowired
	private GradoService gservice;
	
	@Autowired
	private SeccionService sservice;
	
	@GetMapping("/frmJustificaciones")
	public String frmJustificaciones(Model model) {
		model.addAttribute("lstnivel", nservice.listarNivel());
		model.addAttribute("lstgrado", gservice.listarGrado());
		model.addAttribute("lstseccion", sservice.listarSeccion());
		return "Justificaciones/frmJustificaciones";
	}
	
	@GetMapping("/frmAlumnosxAula")
	@ResponseBody
	public List<AlumnosXAula> listarAlumno(@RequestParam("nivel") String n, @RequestParam("grado") String g,
			@RequestParam("seccion") String s, Model model) {
		model.addAttribute("lstalu", alservice.listarAlumnoxAula(n, g, s) );
		return alservice.listarAlumnoxAula(n, g, s);
	} 
	
	
	@GetMapping("/frmFaltasXAlumno")
	@ResponseBody
	public List<AsistenciaAlumno> listarFaltas(@RequestParam("idalumno") String n,Model model) {
		model.addAttribute("lstalu", aaservice.listarFaltas(n));
		return aaservice.listarFaltas(n);
	} 
	
	
	@PostMapping("/registrarJustificacion")
	@ResponseBody
	public ResultadoResponse registrarJustificacion(@RequestBody Justificaciones obj) {
		String mensaje = "Justificacion registrada correctamente";
		Boolean respuesta = true;
		try {
			if(service.validarJustificacion(obj) == true) {
				mensaje = "Ya se registro la justificacion de esta asistencia";
				respuesta = false;
			}else {
				service.RegistrarJustificaion(obj);
			}
			//service.RegistrarJustificaion(obj);

		} catch (Exception ex) {
			mensaje = "Justificacion no registrada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
}
