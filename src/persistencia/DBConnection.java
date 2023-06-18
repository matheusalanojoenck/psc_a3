package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.swing.JOptionPane;
import dados.*;

public class DBConnection {
	private Connection connection = null;
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
		return null;
	}
	
	public Aluno listarAluno(int id) {
		return null;
	}
	
	public void inserirAluno(Aluno aluno) {
		
	}
	
	public void editarAluno(int id, Aluno aluno) {
		
	}
	
	public void deletarAluno(int id) {
		
	}
	
	//Query Professor
	public List<Professor> listarProfessores() {
		return null;
	}
	
	public Professor listarProfessor(int id) {
		return null;
	}
	
	public void inserirProfessor(Professor professor) {
		
	}
	
	public void editarProfessor(int id, Professor professor) {
		
	}
	
	public void deletarProfessor(int id) {
		
	}
	
	//Query Curso
	public List<Curso> listarCursos() {
		return null;
	}
	
	public Curso listarCurso(int id) {
		return null;
	}
	
	public void inserirCurso(Curso curso) {
		
	}
	
	public void editarCurso(int id, Curso curso) {
		
	}
	
	public void deletarCurso(int id) {
		
	}
	
	//Query Sala
	public List<Sala> listarSalas() {
		return null;
	}
	
	public Sala listarSala(int id) {
		return null;
	}
	
	public void inserirSala(Sala sala) {
		
	}
	
	public void editarSala(int id, Sala sala) {
		
	}
	
	public void deletarSala(int id) {
		
	}
	
	//Query Turma
	public List<Turma> listarTurmas() {
		return null;
	}
	
	public Turma listarTurma(int id) {
		return null;
	}
	
	public void inserirTurma(Turma turma) {
		
	}
	
	public void editarTurma(int id, Turma turma) {
		
	}
	
	public void deletarTurma(int id) {
		
	}
	
	//Query aluno_turma
	public void inserirAluno_turma(int id_aluno, int id_turma) {
		
	}
	
	public void deletarAluno_turma(int id_aluno, int id_turma) {
		
	}
	
	public List<Aluno> listarAluno_turma(int id_turma){
		return null;
	}
	
}
