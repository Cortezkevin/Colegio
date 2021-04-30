package golondrinas.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import golondrinas.com.interfaceService.IUsuarioService;
import golondrinas.com.model.Usuario;

@Controller
//@RequestMapping
public class UsuarioController {

		@Autowired
		private IUsuarioService service;

		@GetMapping("/listar")
		public String listar(Model model) {
			List<Usuario> usuarios=service.listar();
			model.addAttribute("usuariolst",usuarios);
				return "usuario";
		}
		
		@GetMapping("/Registrar")
		public String registrar(Model model) {
			model.addAttribute("usuarioForm",new Usuario());
			return "registrarUsuario";
		}
		
		@PostMapping("/Registrar")
		public String registrar(@ModelAttribute("usuarioForm") Usuario usuarioForm, Model model) {
			service.save(usuarioForm);
			return "redirect:/listar";
		}
		
		
		
}
