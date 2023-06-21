package dados;

public class Professor extends Pessoa{
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Professor [id=" + getId() + ", getCpf()=" + getCpf() + ", getNome()=" + getNome() + ", getEndereco()="
				+ getEndereco() + ", getEmail()=" + getEmail() + ", getCelular()=" + getCelular() + "]";
	}
}
