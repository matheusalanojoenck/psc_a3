package dados;

public class Sala {
	private int id;
	private String local;
	private int capacidade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	@Override
	public String toString() {
		return "Sala [id=" + id + ", local=" + local + ", capacidade=" + capacidade + "]";
	}
}
