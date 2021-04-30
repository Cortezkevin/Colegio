package golondrinas.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/login")
	public String holaMundo() {
		return "login";
	}
	
	@PostMapping("/login")
	public String menu2() {
		return "menu2";
	}
}
