package TJW.Projeto.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Estudante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private double av1;
	private double av2;
	private double av3;
	private double av4;
	@ManyToOne
	private Disciplina disciplina;
	
	public double getAv1(){
		return av1;
	}

	public void setAv1(double av1){
		this.av1 = av1;
	}

	public double getAv2(){
		return av2;
	}

	public void setAv2(double av2){
		this.av2 = av2;
	}

	public double getAv3(){
		return av3;
	}

	public void setAv3(double av3){
		this.av3 = av3;
	}

	public double getAv4(){
		return av4;
	}

	public void setAv4(double av4){
		this.av4 = av4;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}

	public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
