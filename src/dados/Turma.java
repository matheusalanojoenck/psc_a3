package dados;
import java.util.List;

public class Turma {
	private int id;
	private DiasSemana dias_semana;
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
	public DiasSemana getDias_semana() {
		return dias_semana;
	}
	public void setDias_semana(DiasSemana dias_semana) {
		this.dias_semana = dias_semana;
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
		return "Turma [id=" + id + ", dias_semana=" + dias_semana + ", professor=" + professor + ", curso=" + curso
				+ ", sala=" + sala + "]";
	}
}
