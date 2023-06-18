package dados;

public class Curso {
	private int id;
	private String nome;
	private float carga_horaria;
	private String descricao;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getCarga_horaria() {
		return carga_horaria;
	}
	public void setCarga_horaria(float carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", carga_horaria=" + carga_horaria + ", descricao=" + descricao
				+ "]";
	}
}
