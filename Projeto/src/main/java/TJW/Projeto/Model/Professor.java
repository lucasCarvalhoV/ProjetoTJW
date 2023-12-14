package TJW.Projeto.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Professor {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String name;
	private String email;
	@OneToOne
    private Disciplina disciplina;
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

    public Disciplina getDisciplina(){
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina){
		this.disciplina = disciplina;
	}
}
