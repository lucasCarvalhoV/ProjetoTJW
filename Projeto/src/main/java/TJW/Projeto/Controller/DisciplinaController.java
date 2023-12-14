package TJW.Projeto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import TJW.Projeto.Model.Disciplina;
import TJW.Projeto.Service.DisciplinaService;

@Controller
@RequestMapping("disciplina")
public class DisciplinaController {
	@Autowired
	DisciplinaService disciplina;
	
	@GetMapping("/listar")
	public String listarDisciplinas(ModelMap model) {
		model.addAttribute("disciplinas",disciplina.listar());
		return "/disciplina/listar";
	}
	
	@GetMapping("/cadastro")
	public String cadastrar(ModelMap model) {
		model.addAttribute("disciplina", new Disciplina());
		return "/disciplina/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Disciplina s) {
		disciplina.salvar(s);
		return "redirect:/disciplina/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, ModelMap model){
		model.addAttribute("estudante",disciplina.busca(id));
		return "/estudante/cadastro";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model){
		disciplina.excluir(id);
		return "redirect:/";
	}
}
