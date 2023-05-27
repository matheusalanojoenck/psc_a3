
public class Aluno extends Pessoa{
	private String matricula;
	
	public Aluno(String nome, String cpf, String matricula) {
		super();
		super.setNome(nome);
		super.setCpf(cpf);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", getCpf()=" + getCpf() + ", getNome()=" + getNome()
				+ ", getEndereco()=" + getEndereco() + ", getEmail()=" + getEmail() + ", getCelular()=" + getCelular()
				+ "]";
	}	
}
