package golondrinas.com.controller;

import java.util.ArrayList;
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

import golondrinas.com.model.Persona;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.PersonaService;

@Controller
@RequestMapping("/Persona")
public class PersonaController {
	@Autowired
	public PersonaService service;

	@GetMapping("/frmlistarPersona")
	public String frmlistarPersona(Model model) {
		List<String> lstGenero = new ArrayList<String>();
		lstGenero.add("Masculino");
		lstGenero.add("Femenino");
		model.addAttribute("lstG", lstGenero);
		model.addAttribute("listPersona", service.listarPersona());
		return "Persona/frmlistarPersona";
	}
	
	@PostMapping("/registrarPersona")
	@ResponseBody
	public ResultadoResponse registrarPersona(@RequestBody Persona objPersona) {
		String mensaje = "Persona "+objPersona.getNombres()+" registrado correctamente";
		Boolean respuesta = true;
		try {
			if(service.validarDNI(objPersona)==0 && service.validarTelefono(objPersona) == false && service.validarEmail(objPersona) == 0) {
				service.registrarPersona(objPersona);
			}else if(service.validarDNI(objPersona) == 1) { 
				mensaje = "El DNI "+objPersona.getDni().toString()+" ya existe";
				respuesta = false;
			}else if(service.validarTelefono(objPersona) == true) {
				mensaje = "El Telefono "+objPersona.getTelefono().toString()+" ya existe";
				respuesta = false;
			}else if(service.validarEmail(objPersona) == 1){
				mensaje = "El Email "+objPersona.getEmail().toString()+" ya existe";
				respuesta = false;
			}
			
		} catch (Exception ex) {
			mensaje = "Persona no registrada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	@PostMapping("/actualizarPersona")
	@ResponseBody
	public ResultadoResponse actualizarPersona(@RequestBody Persona objPersona) {
		String mensaje = "Persona "+ objPersona.getNombres() +" actualizado correctamente";
		Boolean respuesta = true;
		try {
			service.actualizarPersona(objPersona);
		}catch (Exception ex) {
			mensaje = "Persona "+objPersona.getNombres()+" no actualizado";
			respuesta = false;
		}
		
		return new ResultadoResponse(respuesta, mensaje);
	}
	

	@GetMapping("/listarPersona")
	@ResponseBody
	public List<Persona> listarPersona() {
		return service.listarPersona();
	}

	@DeleteMapping("/eliminarPersona")
	@ResponseBody
	public ResultadoResponse eliminarPersona(@RequestBody Persona objPersona) {
		String mensaje = "Persona eliminado correctamente";
		Boolean respuesta = true;
		try {
			if(service.validarEstado(objPersona) == false) {
				service.eliminarPersona(objPersona);
			}
			else {
			mensaje = "La persona a eliminar esta siendo ocupada";
			respuesta = false;}
			
		} catch (Exception ex) {
			mensaje = "Persona no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

}
