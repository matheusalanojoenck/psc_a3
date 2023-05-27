
public class Professor extends Pessoa{
	private String cod_funcionario;
	
	public Professor (String nome, String cpf, String cod_funcionario) {
		super();
		super.setNome(nome);
		super.setCpf(cpf);
		this.cod_funcionario = cod_funcionario;
	}

	public String getCod_funcionario() {
		return cod_funcionario;
	}

	public void setCod_funcionario(String cod_funcionario) {
		this.cod_funcionario = cod_funcionario;
	}

	@Override
	public String toString() {
		return "Professor [cod_funcionario=" + cod_funcionario + ", getCpf()=" + getCpf() + ", getNome()=" + getNome()
				+ ", getEndereco()=" + getEndereco() + ", getEmail()=" + getEmail() + ", getCelular()=" + getCelular()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
