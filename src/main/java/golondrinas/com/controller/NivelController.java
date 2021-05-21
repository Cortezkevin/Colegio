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

import golondrinas.com.model.Nivel;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.NivelService;

@Controller
@RequestMapping("/Nivel")
public class NivelController {

	@Autowired
	private NivelService service;
	
	
	@GetMapping("/frmNivel")
	public String ListaNivel(Model model) {
		List<Nivel> listaNiveles = service.listarNivel();
		model.addAttribute("lstniveles", listaNiveles);
		return "Nivel/frmNivel";
	}
	
	@PostMapping("/registrarNivel")
	@ResponseBody
	public ResultadoResponse registrarNivel(@RequestBody Nivel objNivel) {
		
		String mensaje = "Nivel no registrado";
		Boolean respuesta = true;
		
		try {
			service.registrarNivel(objNivel);
		}
		
		catch(Exception ex) {
			
			mensaje = "Nivel registado";
			respuesta = false;
		}
		
		return new ResultadoResponse(respuesta, mensaje);
	}
	
		
	@GetMapping("/listaNivel")
	@ResponseBody
	public List<Nivel> listarNivel(){
		
		return service.listarNivel();
	}
	
	
	@DeleteMapping("/eliminarNivel")
	@ResponseBody
	public ResultadoResponse eliminarNivel(@RequestBody Nivel objNivel) {
		
		String mensaje = "Nivel eliminado de forma logica";
		Boolean respuesta = true;
		
		try {
			service.eliminarNivel(objNivel);
		}
		
		catch (Exception ex){
			
			mensaje = "Nivel no eliminado";
			respuesta = false;
		}
		
		return new ResultadoResponse(respuesta, mensaje);
	}
}
