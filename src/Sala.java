
public class Sala {
	private  String nome;
	private String local;
	private int capacidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
		return "Sala [nome=" + nome + ", local=" + local + ", capacidade=" + capacidade + "]";
	}
	
}
