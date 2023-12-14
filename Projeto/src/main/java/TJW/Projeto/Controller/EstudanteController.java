package TJW.Projeto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import TJW.Projeto.Model.Estudante;
import TJW.Projeto.Service.EstudanteService;




@Controller
@RequestMapping("/estudante")
public class EstudanteController {

	@Autowired
	EstudanteService estudante;
	
	@GetMapping("/cadastro")
	public String cadastrar(ModelMap model) {
		model.addAttribute("estudante", new Estudante());
		return "/estudante/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Estudante s) {
		estudante.salvar(s);
		return "redirect:/";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, ModelMap model){
		model.addAttribute("estudante",estudante.busca(id));
		return "/estudante/cadastro";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model){
		estudante.excluir(id);
		return "redirect:/";
	}
	


}
