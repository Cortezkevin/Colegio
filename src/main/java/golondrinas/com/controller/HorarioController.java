package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import golondrinas.com.model.Horario;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.CursoService;
import golondrinas.com.service.GradoService;
import golondrinas.com.service.HorarioService;
import golondrinas.com.service.NivelService;
import golondrinas.com.service.SeccionService;

@Controller
@RequestMapping("/Horario")
public class HorarioController {

	@Autowired
	private HorarioService service;
	
	@Autowired
	private NivelService nservice;
	
	@Autowired
	private GradoService gservice;
	
	@Autowired
	private SeccionService sservice;
	
	@Autowired
	private CursoService cservice;

	
	@GetMapping("/frmHorario")
	public String frmHorario(Model model) {
		model.addAttribute("lstnivel", nservice.listarNivelValidos());
		model.addAttribute("lstgrado", gservice.listarGradoValidos());
		model.addAttribute("lstseccion", sservice.listarSeccionValidos());
		model.addAttribute("lstcurso", cservice.listarCursosValidos());
		return "Horario/frmHorario";
	}
	
	@PostMapping("/registrarHorario")
	@ResponseBody
	public ResultadoResponse registrarHorario(@RequestBody Horario objHorario) {
		String mensaje = "Horario registrado correctamente";
		Boolean respuesta = true;
		try {
			if(service.validarHorario(objHorario) == false) {
				service.registrarHorario(objHorario);
			}
			else {
			mensaje = "Ya se registro el curso "+objHorario.getCurso()+" en el dia "+objHorario.getDia();
			respuesta = false;
			}
		} catch (Exception ex) {
			mensaje = "No se registro";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	@PostMapping("/actualizarHorario")
	@ResponseBody
	public ResultadoResponse actualizarHorario(@RequestBody Horario objHorario) {
		String mensaje = "Horario Actualizado correctamente";
		Boolean respuesta = true;
		try {
			service.ActualizarHorario(objHorario);
		} catch (Exception ex) {
			mensaje = "Horario no Actualizado";
			respuesta = false;
		}
		
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	@GetMapping("/listarHorario")
	@ResponseBody
	public List<Horario> listaHorario(@RequestParam("nivel") String n,@RequestParam("grado") String g,@RequestParam("seccion") String s){
		return service.listarHorario(n, g, s);
	}
	

	

	
}

