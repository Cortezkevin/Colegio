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


import golondrinas.com.model.response.ResultadoResponse;

import golondrinas.com.model.Cargo;

import golondrinas.com.service.CargoService;

@Controller
@RequestMapping("/Cargo")
public class CargoController {

	@Autowired
	private CargoService service;

	@GetMapping("/frmCargos")
	public String listaCargo(Model model) {
		List<Cargo> listaCargos = service.listarCargos();
		model.addAttribute("lstcargos", listaCargos);
		return "Cargo/frmCargos";
	}

	@PostMapping("/registrarCargo")
	@ResponseBody
	public ResultadoResponse registrarCargo(@RequestBody Cargo objCargo) {
		String mensaje = "Curso registrado correctamente";
		Boolean respuesta = true;
			try {
				service.registrarCargo(objCargo);
			} catch (Exception ex) {
				mensaje = "Cargo no registrado";
				respuesta = false;
			}
	return new ResultadoResponse(respuesta, mensaje);
	}

	@GetMapping("/listarCargos")
	@ResponseBody
	public List<Cargo> listarCargos() {
		return service.listarCargos();
	}

	@DeleteMapping("/eliminarCargo")
	@ResponseBody
	public ResultadoResponse eliminarCargo(@RequestBody Cargo objCargo) {
		String mensaje = "Cargo eliminado de forma logica";
		Boolean respuesta = true;
		try {
			service.eliminarCargo(objCargo);
		} catch (Exception ex) {
			mensaje = "Cargo no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

}
