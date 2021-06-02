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

import golondrinas.com.model.Grado;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.GradoService;

@Controller
@RequestMapping("/Grado")
public class GradoController {

	@Autowired
	private GradoService service;

	@GetMapping("/ListaGrado")
	public String ListaGrado(Model model) {
		// List<Grado> lst= service.listarGrado();
		model.addAttribute("lstgrado", service.listarGrado());
		model.addAttribute("gradoForm", new Grado());
		return "Grado/listadoGrado";
	}

	/*
	 * @GetMapping("/RegistrarGrado") public String RegistrarGrado(Model model) {
	 * model.addAttribute("gradoForm", new Grado()); return "Grado/registroGrado"; }
	 */

	@PostMapping("/ListaGrado")
	public String RegistrarGrado(@ModelAttribute("gradoForm") Grado gradoForm) {
		if (service.validarNombre(gradoForm) == true) {
			return "redirect:/Grado/ListaGrado";
		} else if (gradoForm.getNombre() == null || gradoForm.getNombre().isEmpty()) {
			return "redirect:/Grado/ListaGrado";
		} else {
			service.registrarGrado(gradoForm);
		}
		return "redirect:/Grado/ListaGrado";
	}

	@PostMapping("/actualizarGrado")
	@ResponseBody
	public ResultadoResponse actualizar(@RequestBody Grado objGrado) {
		String mensaje = "Grado Actualizado correctamente";
		Boolean respuesta = true;
		try {
			service.actualizarGrado(objGrado);
		} catch (Exception ex) {
			mensaje = "Grado no Actualizado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	@PostMapping("/eliminarGrado")
	@ResponseBody
	public ResultadoResponse eliminarGrado(@RequestBody Grado objGrado) {
		String mensaje = "Grado eliminado correctamente";
		Boolean respuesta = true;
		try {
			service.eliminarGrado(objGrado);
		} catch (Exception ex) {
			mensaje = "Grado no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	@GetMapping("/ListasGrado")
	@ResponseBody
	public List<Grado> listarGrado() {
		return service.listarGrado();
	}

}
