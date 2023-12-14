package TJW.Projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TJW.Projeto.Exception.ProfessorException;
import TJW.Projeto.Model.Professor;
import TJW.Projeto.Repository.ProfessorRepository;

@Service
public class ProfessorService {
    	@Autowired
	ProfessorRepository professor;
	
	public Professor salvar(Professor d) {
		return professor.save(d);
	}
	
	public Professor busca(Long id) {
		return professor.findById(id).orElseThrow(() -> new ProfessorException("professor não encontrada"));
	}
	
	public List<Professor> listar() {
		return professor.findAll();
	}
	
	public Professor editar(Long id, Professor alteracao) {
		Professor instrutor = busca(id);
		instrutor.setName(alteracao.getName());
		instrutor.setEmail(alteracao.getEmail());
        instrutor.setDisciplina(alteracao.getDisciplina());
		return instrutor;
	}

	public void excluir(Long id){
		professor.deleteById(id);
	}
}
