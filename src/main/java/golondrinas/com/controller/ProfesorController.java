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
import golondrinas.com.model.Profesor;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.PersonaService;
import golondrinas.com.service.ProfesoreService;
import golondrinas.com.service.UsuarioService;



@Controller
@RequestMapping("/Profesor")
public class ProfesorController {
	
	@Autowired
	private ProfesoreService service;
	
	@Autowired
	private PersonaService pservice;
	
	@Autowired
	private UsuarioService uservice;
	
	@GetMapping("/frmProfesor")
	public String ListarProfesor(Model model) {
		
		List<Profesor> listProfesor = service.listarProfesor();
		model.addAttribute("lstprofesor",listProfesor);
		model.addAttribute("lstpersona",pservice.listarPersonaxtipo1());
		model.addAttribute("lstusuario",uservice.listarUsuarioXR002());
		return "Profesor/frmProfesor";
	}
	
	@PostMapping("/registrarProfesor")
	@ResponseBody
	public ResultadoResponse registrarProfesor(@RequestBody Profesor objProfesor) {
		String mensaje = "Profesor registrado correctamente";
		Boolean respuesta = true;
		try {
			if(service.validarProfesor(objProfesor) ==  0 && service.validarUsuario(objProfesor) == 0) {
				service.RegistrarProfesor(objProfesor);	
			}else if(service.validarProfesor(objProfesor) == 2) {
				mensaje = "La persona seleccionada ha sido eliminada";
				respuesta = false;}
			else if(service.validarUsuario(objProfesor) == 2) {
				mensaje = "El usuario seleccionado ha sido eliminado";
				respuesta = false;}
			else if(service.validarUsuario(objProfesor) == 1) {
				mensaje = "El usuario seleccionado ya esta siendo ocupado";
				respuesta = false;}
			else{
			mensaje = "La persona seleccionada ya esta siendo ocupada";
			respuesta = false;}

			
		}
		catch(Exception ex) {
			
			mensaje = "Profesor no registrado";
			respuesta = false;
		}
		
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	@GetMapping("/listarProfesores")
	@ResponseBody
	public List<Profesor> listarProfesor(){
		
		return service.listarProfesor();
		
	}
	
	@DeleteMapping("/eliminarProfesor")
	@ResponseBody
	public ResultadoResponse eliminarProfesor(@RequestBody Profesor objProfesor) {
		
		String mensaje = "Profesor eliminado correctamente";
		Boolean respuesta = true;
		
		try {
			service.eliminarProfesor(objProfesor);
		}
		
		catch (Exception ex) {
			
			mensaje = "Profesor no eliminado";
			respuesta = false;
		}
		
		return new ResultadoResponse(respuesta, mensaje);
	}
	

}
