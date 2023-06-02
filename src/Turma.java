import java.util.List;

public class Turma {
	private String nome;
	private Professor professor;
	private Sala sala;
	private List<Aluno> alunos;
	private List<DiasSemana> dias_semana;
	
	public Turma(){
		
	}
	public boolean addAluno(Aluno aluno) {
		if (alunos.size() == sala.getCapacidade()) {
			return false;
		}
		alunos.add(aluno);
		return true;
	}
	
}
