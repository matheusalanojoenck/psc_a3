package dados;

public class Aluno extends Pessoa{
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getId() + " | " + super.getNome(); 
	}
}
