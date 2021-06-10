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

import golondrinas.com.model.Apoderado;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.ApoderadoService;
import golondrinas.com.service.PersonaService;


@Controller
@RequestMapping("/Apoderado")
public class ApoderadoController {
	
	@Autowired
	private PersonaService pservice;
	
	@Autowired
	private ApoderadoService service;
	

	@GetMapping("/frmApoderado")
	public String ListarApodrado(Model model) {
		List<Apoderado> listarApoderado = service.listarApoderado();
		model.addAttribute("lstApoderado", listarApoderado);
		model.addAttribute("lstpersona", pservice.listarPersona());
		return "Apoderado/frmApoderado";
	}
	
	@PostMapping("/registrarApoderado")
	@ResponseBody
	public ResultadoResponse registrarApoderado(@RequestBody Apoderado objApoderado) {
		
		String mensaje = "Apoderado registrado correctamente";
		Boolean respuesta = true;
		try {
			
				service.registrarApoderado(objApoderado);

		}
		catch(Exception ex){
			
			mensaje = "Apoderado no registrado";
			respuesta = false;
			
		}
		
		return new ResultadoResponse(respuesta, mensaje);
		
	}
	
	
	@GetMapping("/listarApoderado")
	@ResponseBody
	public List<Apoderado> listarApoderado(){
		
		return service.listarApoderado();
	}
	
	@DeleteMapping("/eliminarApoderado")
	@ResponseBody
	public ResultadoResponse eliminarApoderado(@RequestBody Apoderado obApoderado) {
		
		String mensaje = "Apoderado eliminado de form logica";
		Boolean respuesta = true;
		try {
			
			service.elliminarApoderado(obApoderado);
		}
		
		catch (Exception ex) {
			
			mensaje = "Apoderado no eliminado";
			respuesta = false;
		}
		
		return new ResultadoResponse(respuesta, mensaje);
	}

}
