package TJW.Projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TJW.Projeto.Exception.DisciplinaException;
import TJW.Projeto.Model.Disciplina;
import TJW.Projeto.Repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	@Autowired
	DisciplinaRepository disciplina;
	
	public Disciplina salvar(Disciplina d) {
		return disciplina.save(d);
	}
	
	public Disciplina busca(Long id) {
		return disciplina.findById(id).orElseThrow(() -> new DisciplinaException("Disciplina não encontrada"));
	}
	
	public List<Disciplina> listar() {
		return disciplina.findAll();
	}
	
	public Disciplina editar(Long id, Disciplina alteracao) {
		Disciplina materia = busca(id);
		materia.setNome(alteracao.getNome());
		return materia;
	}

	public void excluir(Long id){
		disciplina.deleteById(id);
	}
}
