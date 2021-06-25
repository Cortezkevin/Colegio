package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import golondrinas.com.model.Alumno;
import golondrinas.com.model.AlumnosXAula;
import golondrinas.com.model.NBimestreXAlumno;
import golondrinas.com.model.NotaBimestre;
import golondrinas.com.model.NotaXCurso;
import golondrinas.com.model.Notas;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.AlumnoService;
import golondrinas.com.service.AlumnosXAulaService;
import golondrinas.com.service.BimestreService;
import golondrinas.com.service.CursoService;
import golondrinas.com.service.GradoService;
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
	private AlumnosXAulaService alservice;

	@Autowired
	private AlumnoService aservice;

	@Autowired
	private CursoService cservice;
	
	@Autowired
	private NotaXCursoService ncservice;
	
	@Autowired
<<<<<<< HEAD
	private NBimestreXAlumnoService nbimestreservice;
	
	@Autowired
	private BimestreService bimestresservice;
	
=======
	private NotaXCursoService ncservice;

	@Autowired
	private NBimestreXAlumnoService nbimestreservice;

	@Autowired
	private BimestreService bimestresservice;

>>>>>>> e802e48cbd5ea1283d7a5662c72fd04f9ff8e418
	@Autowired
	private NotaBimestreService notabservice;

	@GetMapping("/frmNotas")
	public String frmNota(Model model) {
		model.addAttribute("lstnivel", nivelservice.listarNivel());
		model.addAttribute("lstgrado", gradoservice.listarGrado());
		model.addAttribute("lstseccion", seccionservice.listarSeccion());
		model.addAttribute("lstcurso", cservice.listarCursos());
		model.addAttribute("lstbimestre", bimestresservice.listarBimestres());
		return "Notas/frmNotas";
	}

	@GetMapping("/frmAlumnosxAula")
	@ResponseBody
<<<<<<< HEAD
	public List<AlumnosXAula> listarAlumno(@RequestParam("nivel") String n,
			@RequestParam("grado") String g, @RequestParam("seccion") String s
			, Model model) {
		model.addAttribute("lstalu",alservice.listarAlumnoxAula(n, g, s));
		return alservice.listarAlumnoxAula(n, g, s);
	}
	
	@GetMapping("/frmCursoXNota")
	@ResponseBody
	public List<NotaXCurso> listarNotas(@RequestParam("idalumno") String idalumno, @RequestParam("idbimestre") String idbimestre) {
		return ncservice.listarNotaXCurso(idalumno, idbimestre);
	}
	
	@GetMapping("/frmNotaBimestreXAlumno")
	@ResponseBody
	public List<NBimestreXAlumno> listarNotaBimestreXAlumno(@RequestParam("idalumno") String idalumno) {
		return nbimestreservice.listarNotaBimestreXAlumno(idalumno);
=======
	public List<AlumnosXAula> listarAlumno(@RequestParam("nivel") String n, @RequestParam("grado") String g,
			@RequestParam("seccion") String s, Model model) {
		model.addAttribute("lstalu", alservice.listarAlumnoxAula(n, g, s));
		return alservice.listarAlumnoxAula(n, g, s);
>>>>>>> e802e48cbd5ea1283d7a5662c72fd04f9ff8e418
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
<<<<<<< HEAD
		try {		
			if(service.validarCursos(objnota) == true) {
				service.registrarNotasv2(objnota);
				}else {
			mensaje = "El curso seleccionado ya esta registrado";
			respuesta = false;}
			
		}
		catch (Exception ex) {
=======
		try {
			if (service.validarCursos(objnota) == true) {
				service.registrarNotasv2(objnota);
			} else {
				mensaje = "El curso seleccionado ya esta registrado";
				respuesta = false;
			}

		} catch (Exception ex) {
>>>>>>> e802e48cbd5ea1283d7a5662c72fd04f9ff8e418
			mensaje = "Nota no registrada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
<<<<<<< HEAD
	
	@PostMapping("/registrarNotaBimestre")
	@ResponseBody
	public ResultadoResponse registrarNotaBimestre(@RequestBody NotaBimestre objnota) {
		String mensaje = "Nota Bimestral registrada correctamente";
		Boolean respuesta = true;
		try {		
			if(notabservice.validarCurso(objnota) == true) {
				notabservice.RegistrarNotaBimestral(objnota);
			}else {
				mensaje = "El curso seleccionado ya esta registrado";
				respuesta = false;
			}
		}
		catch (Exception ex) {
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
		}
		catch (Exception ex) {
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
		}
		catch (Exception ex) {
			mensaje = "Nota Bimestral no actualizada";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	
	@GetMapping("/listarNotas")
	@ResponseBody
	public List<Notas> listarNotas() {
=======
>>>>>>> e802e48cbd5ea1283d7a5662c72fd04f9ff8e418

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
	/*
	 * @DeleteMapping("/eliminarNota")
	 * 
	 * @ResponseBody public ResultadoResponse eliminarAlumno(@RequestBody Alumno
	 * objAlumno) {
	 * 
	 * String mensaje = "Alumnon elimando correctamente"; Boolean respuesta = true;
	 * 
	 * try { service.eliminarAlumno(objAlumno); }
	 * 
	 * catch (Exception ex) {
	 * 
	 * mensaje = "Alumno no eliminado"; respuesta = false; }
	 * 
	 * return new ResultadoResponse(respuesta, mensaje); }
	 */
}
