import java.util.ArrayList;

public class Turma {
	private String nome;
	private Professor professor;
	private ArrayList<Aluno> alunos;
	private ArrayList<DiasSemana> dias_semana;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	public ArrayList<DiasSemana> getDias_semana() {
		return dias_semana;
	}
	public void setDias_semana(ArrayList<DiasSemana> dias_semana) {
		this.dias_semana = dias_semana;
	}
	
	
}
