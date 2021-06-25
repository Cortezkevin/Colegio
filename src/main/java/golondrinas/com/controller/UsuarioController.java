package golondrinas.com.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.jsoup.select.Evaluator.IsEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



import golondrinas.com.model.DetalleUsuario;
import golondrinas.com.model.Usuario;
import golondrinas.com.model.response.ResultadoResponse;
import golondrinas.com.service.CargoService;
import golondrinas.com.service.DetallerUsuarioService;
import golondrinas.com.service.PersonaService;
import golondrinas.com.service.UserRoleService;
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
	private UserRoleService UserRole;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	

	@GetMapping("/frmUsuario")
	public String listar(Model model,Authentication auth, Usuario objusuario) {
		model.addAttribute("usuariolst", service.listarUsuarios());
		System.out.println(service.listarSelectUsuario());
		model.addAttribute("lstCargos",cargoservice.listarCargos());
		model.addAttribute("lstPersonas",personaservice.listarPersona());
		model.addAttribute("usuarioForm", new Usuario());
		String cargo="";
		String UserName=auth.getName();
		for(GrantedAuthority rol:auth.getAuthorities()) {
			cargo=rol.getAuthority();
		}
		model.addAttribute("role",cargo);
		model.addAttribute("listUserRole", service.buscarUserCargo(UserName, cargo));
		return "Usuario/frmUsuario";
	}

	@GetMapping("/registrarUsuario")
	public String registrarUsuario(Model model) {
		model.addAttribute("usuarioForm", new Usuario());
		model.addAttribute("lstCargos",cargoservice.listarCargos());
		model.addAttribute("lstPersonas",personaservice.listarPersona());
		return "Usuario/registrarUsuario";
	}
	
	
	@GetMapping("/actualizarUsuario")
	public String actualizarUsuario(Model model) {
		model.addAttribute("usuarioForm", new Usuario());
		model.addAttribute("lstCargos",cargoservice.listarCargos());
		model.addAttribute("lstPersonas",personaservice.listarPersona());
		return "Usuario/actualizarUsuario";
	}
	@PostMapping("/actualizarUsuario")
	public String actualizarUsuario(@RequestParam("picture") MultipartFile foto, Usuario objUsuario) throws IOException{
		
		if(!foto.isEmpty()) {
			
			StringBuilder builder=new StringBuilder();
			builder.append(System.getProperty("user.home"));
			builder.append(File.separator);
			builder.append("uploadsFotos");
			builder.append(File.separator);
			builder.append(foto.getOriginalFilename());
			
			byte[] bytes= foto.getBytes();
			Path path=Paths.get(builder.toString());
			Files.write(path,bytes);
			objUsuario.setFoto(foto.getOriginalFilename());
			objUsuario.setContrasena(encoder.encode(objUsuario.getContrasena()));
		}
		if(objUsuario.getIdusuario().equals("0")) {
			
			service.registrarUsuario(objUsuario);
		}else {
			service.actualizarUsuario(objUsuario);
		}
		
		
		System.out.println("**************"+objUsuario.getIdcargo());
		System.out.println("**************"+objUsuario.getEstado());
		System.out.println("**************"+objUsuario.getFoto());
		System.out.println("**************"+objUsuario.getIdpersona());
		System.out.println("**************"+objUsuario.getIdusuario());
		
		UserRole.registrarUserRole(objUsuario.getIdcargo());
		
		return "redirect:/Usuario/frmUsuario";
	}
	
	
	@PostMapping("eliminarUsuario")
	@ResponseBody
	public ResultadoResponse eliminarUsuario(@RequestBody Usuario objUsuario) {
		String mensaje = "Usuario eliminado correctamente";
		Boolean respuesta = true;
		try {
			service.eliminarUsuario(objUsuario);
		}catch (Exception ex) {
			mensaje= "Usuario no eliminado";
			respuesta=false;
		}
		return new ResultadoResponse(respuesta,mensaje);
	}

	@GetMapping("/listarUsuarios")
	@ResponseBody
	public List<Usuario> listarUsuarios() {	
		return service.listarUsuarios();
	}
	
}
