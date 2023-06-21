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
		return String.format("%d | %s", getId(), getNome()); 
	}
}
