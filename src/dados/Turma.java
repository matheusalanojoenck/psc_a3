package dados;
import java.util.List;

public class Turma {
	private int id;
	private DiasSemana diaSemana;
	private Professor professor;
	private Curso curso;
	private Sala sala;
	private List<Aluno> alunos;
	private List<Aluno> listaDeEspera;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DiasSemana getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(DiasSemana diaSemana) {
		this.diaSemana = diaSemana;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<Aluno> getListaDeEspera() {
		return listaDeEspera;
	}
	public void setlistaDeEspera(List<Aluno> listaDeEspera) {
		this.listaDeEspera = listaDeEspera;
	}
	
	@Override
	public String toString() {
		return getId() + " | " + getProfessor().getNome() + " | " + getCurso().getNome(); 
	}
}
