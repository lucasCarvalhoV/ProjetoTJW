package TJW.Projeto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import TJW.Projeto.Service.EstudanteService;


@Controller
public class HomeController {
	@Autowired
	EstudanteService estudante;
	@GetMapping("/")
	public String home(ModelMap model) {
		model.addAttribute("estudantes",estudante.listar());
		return "home";
	}
}
