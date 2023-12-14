package TJW.Projeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TJW.Projeto.Exception.EstudanteException;
import TJW.Projeto.Model.Estudante;
import TJW.Projeto.Repository.EstudanteRepository;

@Service
public class EstudanteService {
	@Autowired
	EstudanteRepository estudante;
	
	public Estudante salvar(Estudante s) {
		return estudante.save(s);
	}
	
	public Estudante busca(Long id) {
		return estudante.findById(id).orElseThrow(() -> new EstudanteException("estudante não encontrada"));
	}
	
	public List<Estudante> listar() {
		return estudante.findAll();
	}
	
	public Estudante editar(Long id, Estudante alteracao) {
		Estudante aluno = busca(id);
		aluno.setName(alteracao.getName());
		aluno.setEmail(alteracao.getEmail());
		aluno.setAv1(alteracao.getAv1());
		aluno.setAv2(alteracao.getAv2());
		aluno.setAv3(alteracao.getAv3());
		aluno.setAv4(alteracao.getAv4());
		return aluno;
	}

	public void excluir(Long id){
		estudante.deleteById(id);
	}
}
