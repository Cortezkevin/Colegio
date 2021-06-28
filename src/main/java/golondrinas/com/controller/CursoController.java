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

import golondrinas.com.model.Curso;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.CursoService;
import golondrinas.com.service.GradoService;
import golondrinas.com.service.NivelService;



@Controller
@RequestMapping("/Curso")
public class CursoController {
	
	@Autowired 
	private CursoService service;
	
	@Autowired 
	private NivelService nservice;
	
	@Autowired 
	private GradoService gservice;
	
	@GetMapping("/frmListarCurso")
	public String frmListarCurso(Model model) {
		model.addAttribute("listcursos", service.listarCursos());
		model.addAttribute("lstnivel", nservice.listarNivel());
		model.addAttribute("lstgrado", gservice.listarGrado());
		return "Curso/frmListarCurso";
	}
	
	@PostMapping("/registrarCurso")
	@ResponseBody
	public ResultadoResponse registrarCurso(@RequestBody Curso objCurso) {
		String mensaje = "Curso registrado correctamente";
		Boolean respuesta = true;
		try {
			if(service.validarNombre(objCurso) == false) {
				service.registrarCurso(objCurso);
			}
			mensaje = "El nombre del curso ingresado ya esta registrado";
			respuesta = false;
		}catch(Exception ex) {
			mensaje = "Curso no registrado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	@GetMapping("/listarCursos")
	@ResponseBody
	public List<Curso> listarCursos(){
		return service.listarCursos();
	}
	
	@DeleteMapping("/eliminarCurso")
	@ResponseBody
	public ResultadoResponse eliminarCurso(@RequestBody Curso objCurso) {
		String mensaje = "Curso eliminado correctamente";
		Boolean respuesta = true;
		try {
			service.eliminarCurso(objCurso);
		}catch(Exception ex) {
			mensaje = "Curso no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	

}
