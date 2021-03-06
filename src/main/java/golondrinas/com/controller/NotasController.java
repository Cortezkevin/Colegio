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

import golondrinas.com.model.AlumnosXAula;
import golondrinas.com.model.AsistenciaAlumno;
import golondrinas.com.model.Justificaciones;
import golondrinas.com.model.NBimestreXAlumno;
import golondrinas.com.model.NotaBimestre;
import golondrinas.com.model.NotaXCurso;
import golondrinas.com.model.Notas;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.AlumnosXAulaService;
import golondrinas.com.service.AsistenciaAlumnoService;
import golondrinas.com.service.BimestreService;
import golondrinas.com.service.CursoService;
import golondrinas.com.service.GradoService;
import golondrinas.com.service.JustificacionService;
import golondrinas.com.service.NBimestreXAlumnoService;
import golondrinas.com.service.NivelService;
import golondrinas.com.service.NotaBimestreService;
import golondrinas.com.service.NotaXCursoService;
import golondrinas.com.service.NotasService;
import golondrinas.com.service.SeccionService;

@Controller
@RequestMapping("/Notas")
public class NotasController {

	@Autowired
	private NivelService nivelservice;

	@Autowired
	private GradoService gradoservice;

	@Autowired
	private SeccionService seccionservice;

	@Autowired
	private NotasService service;

	@Autowired
	private AlumnosXAulaService alservice;


	@Autowired
	private CursoService cservice;

	@Autowired
	private NotaXCursoService ncservice;

	@Autowired
	private NBimestreXAlumnoService nbimestreservice;

	@Autowired
	private BimestreService bimestresservice;

	@Autowired
	private NotaBimestreService notabservice;
	
	@Autowired
	private AsistenciaAlumnoService asitenciaService;
	
	@Autowired
	private JustificacionService justificacionService;

	@GetMapping("/frmNotas")
	public String frmNota(Model model) {
		model.addAttribute("lstnivel", nivelservice.listarNivelValidos());
		model.addAttribute("lstgrado", gradoservice.listarGradoValidos());
		model.addAttribute("lstseccion", seccionservice.listarSeccionValidos());
		model.addAttribute("lstcurso", cservice.listarCursosValidos());
		model.addAttribute("lstbimestre", bimestresservice.listarBimestreValidos());
		
		return "Notas/frmNotas";
	}

	@GetMapping("/frmAlumnosxAula")
	@ResponseBody
	public List<AlumnosXAula> listarAlumno(@RequestParam("nivel") String n, @RequestParam("grado") String g,
			@RequestParam("seccion") String s, Model model) {
		model.addAttribute("lstalu", alservice.listarAlumnoxAula(n, g, s));
		return alservice.listarAlumnoxAula(n, g, s);
	}

	@GetMapping("/frmCursoXNota")
	@ResponseBody
	public List<NotaXCurso> listarNotas(@RequestParam("idalumno") String idalumno,
			@RequestParam("idbimestre") String idbimestre) {
		return ncservice.listarNotaXCurso(idalumno, idbimestre);
	}

	@GetMapping("/frmNotaBimestreXAlumno")
	@ResponseBody
	public List<NBimestreXAlumno> listarNotaBimestreXAlumno(@RequestParam("idalumno") String idalumno) {
		return nbimestreservice.listarNotaBimestreXAlumno(idalumno);
	}

	@PostMapping("/registrarNotas")
	@ResponseBody
	public ResultadoResponse registrarNotas(@RequestBody Notas objnota) {
		String mensaje = "Nota registrada correctamente";
		Boolean respuesta = true;
		try {
			if (service.validarCursos(objnota) == true) {
				service.registrarNotasv2(objnota);
			} else {
				mensaje = "El curso seleccionado ya esta registrado";
				respuesta = false;
			}

		} catch (Exception ex) {
			mensaje = "Nota no registrada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	@PostMapping("/registrarNotaBimestre")
	@ResponseBody
	public ResultadoResponse registrarNotaBimestre(@RequestBody NotaBimestre objnota) {
		String mensaje = "Nota Bimestral registrada correctamente";
		Boolean respuesta = true;
		try {
			if (notabservice.validarCurso(objnota) == true) {
				notabservice.RegistrarNotaBimestral(objnota);
			} else {
				mensaje = "El curso seleccionado ya esta registrado";
				respuesta = false;
			}
		} catch (Exception ex) {
			mensaje = "Nota Bimestral no registrada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	@PostMapping("/actualizarNotas")
	@ResponseBody
	public ResultadoResponse actualizarNotas(@RequestBody Notas objnota) {
		String mensaje = "Nota actualizada correctamente";
		Boolean respuesta = true;
		try {
			service.actualizarNotasv2(objnota);
		} catch (Exception ex) {
			mensaje = "Nota no actualizada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	@PostMapping("/actualizarNotaBimestre")
	@ResponseBody
	public ResultadoResponse actualizarNotaBimestre(@RequestBody NotaBimestre objnota) {
		String mensaje = "Nota Bimestral actualizada correctamente";
		Boolean respuesta = true;
		try {
			notabservice.ActualizarNotaBimestral(objnota);
		} catch (Exception ex) {
			mensaje = "Nota Bimestral no actualizada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	@GetMapping("/listarNotas")
	@ResponseBody
	public List<Notas> listarNotas() {

		return service.listarNotas();
	}
	
	@GetMapping("/frmAsistencia")
	@ResponseBody
	public List<AsistenciaAlumno> listarAsistencia(@RequestParam("idalumno") String n, Model model) {
		model.addAttribute("lstasitencia", asitenciaService.asistenciaXAlumno(n));
		return asitenciaService.asistenciaXAlumno(n);
	}
	
	@GetMapping("/frmJustificaciones")
	@ResponseBody
	public List<Justificaciones> listarJustificaciones(@RequestParam("idalumno") String n, Model model) {
		model.addAttribute("lstasitencia", justificacionService.ListarJustificaciones(n));
		return justificacionService.ListarJustificaciones(n);
	}	

}
