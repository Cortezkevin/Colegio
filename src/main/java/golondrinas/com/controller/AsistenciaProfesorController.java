package golondrinas.com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import golondrinas.com.model.AsistenciaProfesor;
import golondrinas.com.model.ReporteAsistenciaProfesor;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.AsistenciaProfesorService;
import golondrinas.com.service.ProfesoreService;
import golondrinas.com.service.ReporteAsistenciaProfesorService;

@Controller
@RequestMapping ("/AsistenciaProfesor")
public class AsistenciaProfesorController {

	@Autowired
	private AsistenciaProfesorService service;
	
	@Autowired
	private ProfesoreService pservice;
	
	@Autowired
	private ReporteAsistenciaProfesorService rpservice;
	
	@GetMapping("/frmAsistenciaProfesor")
	public String frmAsistencia(Model model) {
		List<String> lstEstadoA = new ArrayList<String>(); 
		lstEstadoA.add("Presente");
		lstEstadoA.add("Ausente");
		lstEstadoA.add("Tarde"); 
		//var f = new Date().toLocaleString();
		//String hoy = (new Date().getDay());
		model.addAttribute("fecha", new Date().getDate() + "/7/2021");
		model.addAttribute("lstreporte", rpservice.listarReporteAsistencia());
		model.addAttribute("listadoAsistencia", pservice.listarProfesor());
		model.addAttribute("estado", lstEstadoA);
		return "AsistenciaProfesor/frmAsistenciaProfesor";
	}
	
	@PostMapping("/registrarAsistencia")
	@ResponseBody
	public ResultadoResponse registrarAsistencia(@RequestBody AsistenciaProfesor obj) {
		String mensaje = "Asistencia registrada correctamente";
		Boolean respuesta = true;
		try {
			if(service.validarAsistenciaXFecha(obj) == true) {
				mensaje = "Ya se registro la asistencia del profesor seleccionado";
				respuesta = false;
			}else {
				service.RegistrarAsistenciaProfesor(obj);
			}

		} catch (Exception ex) {
			mensaje = "Asistencia no registrada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	@GetMapping("/frmReporteAsistencia")
	@ResponseBody
	public List<ReporteAsistenciaProfesor> listarReporte() {
		return rpservice.listarReporteAsistencia();
	} 
}
