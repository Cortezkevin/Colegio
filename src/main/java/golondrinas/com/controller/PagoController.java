package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import golondrinas.com.model.Pago;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.MatriculaService;
import golondrinas.com.service.PagoService;

@Controller
@RequestMapping("/Pago")
public class PagoController {

	@Autowired
	private PagoService service;
	
	@Autowired
	private MatriculaService mservice;

	@GetMapping("/frmPago")
	public String frmPago(Model model) {
		List<Pago> lst = service.listarPago();
		model.addAttribute("lstpago", lst);
		model.addAttribute("lstmatricula", mservice.listarMatriculas());
		return "Pago/frmPago";
	}

	@PostMapping("/registrarPago")
	@ResponseBody
	public ResultadoResponse registrarPago(@RequestBody Pago obj) {
		String mensaje = "Pago registrado correctamente";
		Boolean respuesta = true;
		try {
			service.registrarPago(obj);
		} catch (Exception e) {
			mensaje = "Pago no registrado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	@GetMapping("/listarPago")
	@ResponseBody
	public List<Pago> listarPago() {
		return service.listarPago();
	}

	@DeleteMapping("/eliminarPago")
	public ResultadoResponse eliminarPago(@RequestBody Pago obj) {
		String mensaje = "Pago eliminado de forma logica, correctamente";
		Boolean respuesta = true;
		try {
			service.eliminarPago(obj);
		} catch (Exception e) {
			mensaje = "Pago no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
}
