package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;
import dados.*;

public class DBConnection {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	private String banco = "programacao_terca";
	private String porta = "3306";
	private String IpHost = "//localhost";
	
	public void conectarMariaDB() {
		String servidor = "jdbc:mariadb:" + this.IpHost + ":" + this.porta + "/" + this.banco;
		String usuario = "root";
		String senha = "";
		try {
			this.connection = DriverManager.getConnection(servidor,usuario,senha);
			this.connection.createStatement();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,
			"Ocorreu um erro na tentativa de conectar com o banco de dados !!" +
			"\nErro ocorrido: " + e.getMessage());
		}
	}
	
	public boolean estaConectado() {
		if (this.connection != null) {
			return (true);
		}
		else {
			return (false);
		}
	}
	
	public void desconectar() {
		try {
			this.connection.close();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,
			"Ocorreu um na tentativa de fechar o banco de dados: " +
			e.getMessage());
		}
	}
	
	// Query Alunos
	public List<Aluno> listarAlunos() {
		//SELECT * FROM alunos 
		String query = "SELECT * FROM alunos;";
		ResultSet resultset = executeQuery(query);
		return null;
	}
	
	public Aluno listarAluno(int id) {
		// SELECT * FROM alunos WHERE id=?
		String query = String.format("SELECT * FROM alunos WHERE id=%d;", id);
		ResultSet resultset = executeQuery(query);
		return null;
	}
	
	public void inserirAluno(Aluno aluno) {
		//INSERT INTO alunos (nome, cpf, endereco, email, celular) VALUES (?, ?, ?, ?, ?)
		String query = String.format("INSERT INTO alunos (nome, cpf, endereco, email, celular) VALUES (%s, %s, %s, %s, %s);", 
				aluno.getNome(),
				aluno.getCpf(),
				aluno.getEndereco(),
				aluno.getEmail(),
				aluno.getCelular());
		executeUpdate(query);
	}
	
	public void editarAluno(int id, Aluno aluno) {
		//UPDATE alunos SET nome=?, cpf=?, endereco=?, email=?, celular=? WHERE id=?;
		String query = String.format("UPDATE alunos SET nome=%s, cpf=%s, endereco=%s, email=%s, celular=%s WHERE id=%d;",
				aluno.getNome(),
				aluno.getCpf(),
				aluno.getEndereco(),
				aluno.getEmail(),
				aluno.getCelular(),
				id);
		executeUpdate(query);
	}
	
	public void deletarAluno(int id) {
		//DELETE FROM alunos WHERE id=?
		String query = String.format("DELETE FROM alunos WHERE id=%d;", id);
		executeUpdate(query);
	}
	
	//Query Professor
	public List<Professor> listarProfessores() {
		//SELECT * FROM professores
		String query = "SELECT * FROM professores;";
		ResultSet resultset = executeQuery(query);
		return null;
	}
	
	public Professor listarProfessor(int id) {
		//SELECT * FROM professores WHERE id=?
		String query = String.format("SELECT * FROM professores WHERE id=%d;", id);
		ResultSet resultset = executeQuery(query);
		return null;
	}
	
	public void inserirProfessor(Professor professor) {
		//INSERT INTO professores (nome, cpf, endereco, email, celular) VALUES (?, ?, ?, ?, ?)
		String query = String.format("INSERT INTO professores (nome, cpf, endereco, email, celular) VALUES (%s, %s, %s, %s, %s);", 
				professor.getNome(),
				professor.getCpf(),
				professor.getEndereco(),
				professor.getEmail(),
				professor.getCelular());
		executeUpdate(query);
		
	}
	
	public void editarProfessor(int id, Professor professor) {
		//UPDATE professores SET nome=?, cpf=?, endereco=?, email=?, celular=? WHERE id=?;
		String query = String.format("UPDATE professores SET nome=%s, cpf=%s, endereco=%s, email=%s, celular=%s WHERE id=%d;",
				professor.getNome(),
				professor.getCpf(),
				professor.getEndereco(),
				professor.getEmail(),
				professor.getCelular(),
				id);
		executeUpdate(query);
		
	}
	
	public void deletarProfessor(int id) {
		//DELETE FROM professores WHERE id=?
		String query = String.format("DELETE FROM professores WHERE id=%d;", id);
		executeUpdate(query);
	}
	
	//Query Curso
	public List<Curso> listarCursos() {
		//SELECT * FROM cursos
		String query = "SELECT * FROM cursos;";
		ResultSet resultset = executeQuery(query);
		return null;
	}
	
	public Curso listarCurso(int id) {
		//SELECT * FROM cursos WHERE id=?
		String query = String.format("SELECT * FROM cursos WHERE id=%d;", id);
		ResultSet resultset = executeQuery(query);
		return null;
	}
	
	public void inserirCurso(Curso curso) {
		//INSERT INTO cursos (nome, carga_horaria, descricao) VALUES (?, ?, ?)
		String query = String.format("INSERT INTO cursos (nome, carga_horaria, descricao) VALUES (%s, %s, %s)", 
				curso.getNome(),
				curso.getCarga_horaria(),
				curso.getDescricao());
		executeUpdate(query);
	}
	
	public void editarCurso(int id, Curso curso) {
		//UPDATE cursos SET nome=?, craga_horaria=?, descricao=? WHERE id=?;
		String query = String.format("UPDATE cursos SET nome=%s, craga_horaria=%s, descricao=%s WHERE id=%d;", 
				curso.getNome(),
				curso.getCarga_horaria(),
				curso.getDescricao(),
				id);
		executeUpdate(query);
	}
	
	public void deletarCurso(int id) {
		//DELETE FROM cursos WHERE id=?;
		String query = String.format("DELETE FROM cursos WHERE id=%d;", id);
		executeUpdate(query);
	}
	
	//Query Sala
	public List<Sala> listarSalas() {
		//SELECT * FROM cursos;
		String query = "SELECT * FROM cursos;";
		ResultSet resultset = executeQuery(query);
		return null;
	}
	
	public Sala listarSala(int id) {
		//SELECT * FROM cursos WHERE id=?;
		String query = String.format("SELECT * FROM cursos WHERE id=%d;", id);
		ResultSet resultset = executeQuery(query);
		return null;
	}
	
	public void inserirSala(Sala sala) {
		//INSERT INTO salas (local, capacidade) VALUES (?, ?); 
		String query = String.format("INSERT INTO salas (local, capacidade) VALUES (%s, %d);", 
				sala.getLocal(),
				sala.getCapacidade());
		executeUpdate(query);
	}
	
	public void editarSala(int id, Sala sala) {
		//UPDATE salas SET local=?, capacidade=? WHERE id=?;
		String query = String.format("UPDATE salas SET local=%s, capacidade=%d WHERE id=%d;", 
				sala.getLocal(),
				sala.getCapacidade(),
				id);
		executeUpdate(query);
	}
	
	public void deletarSala(int id) {
		//DELETE FROM salas WHERE id=?
		String query = String.format("DELETE FROM salas WHERE id=%d", id);
		executeUpdate(query);
	}
	
	//Query Turma
	public List<Turma> listarTurmas() {
		//SELECT * FROM turmas;
		String query = "SELECT * FROM turmas;";
		ResultSet resultset = executeQuery(query);
		return null;
	}
	
	public Turma listarTurma(int id) {
		//SELECT * FROM turmas WHERE id=?
		String query = String.format("SELECT * FROM turmas WHERE id=%s", id);
		ResultSet resultset = executeQuery(query);
		return null;
	}
	
	public void inserirTurma(Turma turma) {
		//INSERT INTO turmas (diaSemana, professor, curso, sala) VALUES (?, ?, ?, ?);
		String query = String.format("INSERT INTO turmas (diaSemana, professor, curso, sala) VALUES (%s, %s, %s, %s);", 
				turma.getDiaSemana(),
				turma.getProfessor(),
				turma.getCurso(),
				turma.getSala());
		executeUpdate(query);
	}
	
	public void editarTurma(int id, Turma turma) {
		//UPDATE turmas SET diaSemana=?, professor=?, curso=?, salas=? WHERE id=?;
		String query = String.format("UPDATE turmas SET diaSemana=%s, professor=%s, curso=%s, salas=%s WHERE id=%d;", 
				turma.getDiaSemana(),
				turma.getProfessor(),
				turma.getCurso(),
				turma.getSala(),
				id);
		executeUpdate(query);
	}
	
	public void deletarTurma(int id) {
		//DELETE FROM turmas WHERE id=?
		String query = String.format("DELETE FROM turmas WHERE id=%s", id);
		executeUpdate(query);
	}
	
	//Query aluno_turma
	public List<Aluno> listarAluno_turma(int id_turma){
		//SELECT * FROM aluno_turma WHERE turmas_id=?
		String query = String.format("SELECT * FROM aluno_turma WHERE turmas_id=%d;", 
				id_turma);
		ResultSet resultset = executeQuery(query);
		return null;
	}
	public void inserirAluno_turma(int id_aluno, int id_turma) {
		//INSERT INTO aluno_turma (alunos_id, turmas_id) VALUES (?, ?);
		String query = String.format("INSERT INTO aluno_turma (alunos_id, turmas_id) VALUES (%d, %d);", 
				id_aluno,
				id_turma);
		executeUpdate(query);
		
	}
	
	public void deletarAluno_turma(int id_aluno, int id_turma) {
		//DELETE FROM turmas WHERE aluno_id=? AND turmas_id=?;
		String query = String.format("DELETE FROM turmas WHERE aluno_id=%d AND turmas_id=%d;", 
				id_aluno,
				id_turma);
		executeUpdate(query);
	}
	
	private void executeUpdate(String query) {
		try {
			statement.executeUpdate(query);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	private ResultSet executeQuery(String query) {
		ResultSet resultset = null;
		try {
			resultset = statement.executeQuery(query);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return resultset;
	}
	
	
}
