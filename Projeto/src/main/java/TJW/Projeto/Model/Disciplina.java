package TJW.Projeto.Model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Disciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL)
	private List<Estudante> turma;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public List<Estudante> getEstudantes() {
        return turma;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.turma = estudantes;
    }
}
