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

import golondrinas.com.model.Bimestre;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.BimestreService;

@Controller
@RequestMapping("/Bimestre")
public class BimestreController {

	@Autowired
	private BimestreService service;
	
	@GetMapping("/frmBimestres")
	public String listarBimestre(Model model) {
		
		List<Bimestre> listarBimestre = service.listarBimestres();
		model.addAttribute("lstBimestre",listarBimestre);
		return "Bimestre/frmBimestre";
	}
	
	@PostMapping("/registrarBimestre")
	@ResponseBody
	public ResultadoResponse resgistrarBimestre(@RequestBody Bimestre objBimestre) {
		
		String mensaje = "Bimestre registrado correctamente";
		Boolean respuesta = true;
		
		try {
			
			service.registrarBimestre(objBimestre);
		}
		
		catch(Exception ex) {
			
			mensaje = "Bimestre no registrado";
			respuesta = false;
		}
		
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	@GetMapping("/listarBimestre")
	@ResponseBody
	public List<Bimestre> listarBimestre(){
		
		return service.listarBimestres();
	}
	
	@DeleteMapping("/eliminarBimestre")
	@ResponseBody
	public ResultadoResponse eliminarBimestre(@RequestBody Bimestre objBimestre) {
		
		String mensaje = "Bimestre eliminado de forma logica";
		Boolean respuesta = true;
		try {
			
			service.eliminarBimestre(objBimestre);
		}
		
		catch (Exception e) {
			
			mensaje = "Bimestre no eliminado";
			respuesta = false;
		}
		
		return new ResultadoResponse(respuesta, mensaje);
	}
}
