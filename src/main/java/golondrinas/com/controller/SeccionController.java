package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import golondrinas.com.model.Cargo;
import golondrinas.com.model.Seccion;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.SeccionService;

@Controller
@RequestMapping("/Seccion")
public class SeccionController {

	@Autowired
	private SeccionService service;

	@GetMapping("/ListaSeccion")
	public String ListaSeccion(Model model) {
		List<Seccion> lst = service.listarSeccion();
		model.addAttribute("seccionForm", new Seccion());
		model.addAttribute("lstseccion", lst);
		return "Seccion/listadoSeccion";
	}

	/*
	 * @GetMapping("/RegistrarSeccion") public String RegistrarSeccion(Model model)
	 * { model.addAttribute("seccionForm", new Seccion()); return
	 * "Seccion/registroSeccion"; }
	 */

	@PostMapping("/ListaSeccion")
	public String RegistrarSeccion(@ModelAttribute("seccionForm") Seccion seccionForm) {
		if (service.validarNombre(seccionForm) == true) {

			return "redirect:/Seccion/ListaSeccion";

		} else if (seccionForm.getNombre() == null || seccionForm.getNombre().isEmpty()) {

			return "redirect:/Seccion/ListaSeccion";
		} else {
			service.registrarSeccion(seccionForm);
		}
		return "redirect:/Seccion/ListaSeccion";
	}

	@PostMapping("/actualizarSeccion")
	@ResponseBody
	public ResultadoResponse actualizar(@RequestBody Seccion objSeccion) {
		String mensaje = "Seccion Actualizado correctamente";
		Boolean respuesta = true;
		try {
			service.actualizarSeccion(objSeccion);
		} catch (Exception ex) {
			mensaje = "Seccion no Actualizada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	@PostMapping("/eliminarSeccion")
	@ResponseBody
	public ResultadoResponse eliminar(@RequestBody Seccion objSeccion) {
		String mensaje = "Seccion Eliminada";
		Boolean respuesta = true;
		try {
			service.eliminarSeccion(objSeccion);
		} catch (Exception e) {
			mensaje = "Seccion no eliminada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	@GetMapping("/listarSecciones")
	@ResponseBody
	public List<Seccion> listarSecciones() {
		return service.listarSeccion();
	}
	
}
