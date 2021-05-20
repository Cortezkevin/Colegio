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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import golondrinas.com.model.DetalleUsuario;
import golondrinas.com.model.Usuario;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.CargoService;
import golondrinas.com.service.DetallerUsuarioService;
import golondrinas.com.service.PersonaService;
import golondrinas.com.service.UsuarioService;

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private CargoService cargoservice;
	
	@Autowired
	private PersonaService personaservice;
	
	@Autowired
	private DetallerUsuarioService detalleservice; 

	@GetMapping("/frmUsuario")
	public String listar(Model model) {
		List<Usuario> usuarios = service.listarUsuarios();
		model.addAttribute("usuariolst", usuarios);
		model.addAttribute("lstCargos",cargoservice.listarCargos());
		model.addAttribute("lstPersonas",personaservice.listarPersona());
		return "Usuario/frmUsuario";
	}

	@PostMapping("/registrarUsuario")
	@ResponseBody
	public ResultadoResponse registrarUsuario(@RequestBody Usuario objUsuario) {
		String mensaje = "Usuario registrado correctamente";
		Boolean respuesta = true;
		try {
			service.registrarUsuario(objUsuario);
		}catch(Exception ex){
			mensaje = "Usuario no registrado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	@GetMapping("/listarUsuarios")
	@ResponseBody
	public List<Usuario> listarUsuarios() {	
		return service.listarUsuarios();
	}
	
	@DeleteMapping("/eliminarUsuario")
	public ResultadoResponse eliminarUsuario(@RequestBody Usuario objUsuario) {
		String mensaje = "Usuario eliminado correctamente";
		Boolean respuesta = true;
		try {
			service.eliminarUsuario(objUsuario);
		}catch(Exception ex){
			mensaje = "Usuario no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	@GetMapping("/listarDetalleUsuario")
	@ResponseBody
	public List<DetalleUsuario> listarDetalleUsuario(@RequestParam("idusuario") String idusuario){
		return detalleservice.listarDetalleUsuario(idusuario);
	}

}
