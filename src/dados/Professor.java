package dados;

public class Professor extends Pessoa{
	private int id;

	public int getCod_funcionario() {
		return id;
	}

	public void setCod_funcionario(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", getCpf()=" + getCpf() + ", getNome()=" + getNome() + ", getEndereco()="
				+ getEndereco() + ", getEmail()=" + getEmail() + ", getCelular()=" + getCelular() + "]";
	}
}
