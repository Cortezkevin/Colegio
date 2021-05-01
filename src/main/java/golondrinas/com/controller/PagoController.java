package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import golondrinas.com.model.Pago;
import golondrinas.com.service.PagoService;

@Controller
@RequestMapping("/Pago")
public class PagoController {

	@Autowired
	private PagoService service;
	
	@GetMapping("/ListaPago")
	public String ListaPago(Model model) {
		List<Pago> lst= service.listarPago();
		model.addAttribute("lstpago",lst);
		return "Pago/listadoPago";
	}
	
	@GetMapping("/RegistrarPago")
	public String RegistrarPago(Model model) {
		model.addAttribute("pagoForm", new Pago());
		return "Pago/registroPago";
	}
	
	@PostMapping("/RegistrarPago")
	public String RegistrarPago(@ModelAttribute("pagoForm") Pago pagoForm) {
		service.registrarPago(pagoForm);
		return "redirect:/Pago/ListaPago";
	}
}
