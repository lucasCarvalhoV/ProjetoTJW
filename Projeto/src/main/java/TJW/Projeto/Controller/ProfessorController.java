package TJW.Projeto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import TJW.Projeto.Model.Professor;
import TJW.Projeto.Service.ProfessorService;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("professor")
public class ProfessorController {
    @Autowired
	ProfessorService professor;
	
	@GetMapping("/listar")
	public String listarprofessors(ModelMap model) {
		model.addAttribute("professores",professor.listar());
		return "/professor/listar";
	}
	
	@GetMapping("/cadastro")
	public String cadastrar(ModelMap model) {
		model.addAttribute("professor", new Professor());
		return "/professor/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Professor s) {
		professor.salvar(s);
		return "redirect:/professor/listar";
	}

		@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, ModelMap model){
		model.addAttribute("estudante",professor.busca(id));
		return "/estudante/cadastro";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model){
		professor.excluir(id);
		return "redirect:/professor/listar";
	}
}
