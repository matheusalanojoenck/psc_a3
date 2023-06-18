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
		//SELECT * FROM alunos 
		return null;
	}
	
	public Aluno listarAluno(int id) {
		// SELECT * FROM alunos WHERE id=?
		return null;
	}
	
	public void inserirAluno(Aluno aluno) {
		//INSERT INTO alunos (nome, cpf, endereco, email, celular) VALUES (?, ?, ?, ?, ?)
	}
	
	public void editarAluno(int id, Aluno aluno) {
		//UPDATE alunos SET nome=?, cpf=?, endereco=?, email=?, celular=? WHERE id=?; 
	}
	
	public void deletarAluno(int id) {
		//DELETE FROM alunos WHERE id=?
	}
	
	//Query Professor
	public List<Professor> listarProfessores() {
		//SELECT * FROM professores
		return null;
	}
	
	public Professor listarProfessor(int id) {
		//SELECT * FROM professores WHERE id=?
		return null;
	}
	
	public void inserirProfessor(Professor professor) {
		//INSERT INTO professores (nome, cpf, endereco, email, celular) VALUES (?, ?, ?, ?, ?)
		
	}
	
	public void editarProfessor(int id, Professor professor) {
		//UPDATE professores SET nome=?, cpf=?, endereco=?, email=?, celular=? WHERE id=?; 
		
	}
	
	public void deletarProfessor(int id) {
		//DELETE FROM professores WHERE id=?
		
	}
	
	//Query Curso
	public List<Curso> listarCursos() {
		//SELECT * FROM cursos
		return null;
	}
	
	public Curso listarCurso(int id) {
		//SELECT * FROM cursos WHERE id=?
		return null;
	}
	
	public void inserirCurso(Curso curso) {
		//INSERT INTO cursos (nome, carga_horaria, descricao) VALUES (?, ?, ?)
	}
	
	public void editarCurso(int id, Curso curso) {
		//UPDATE cursos SET nome=?, craga_horaria=?, descricao=? WHERE id=?; 
		
	}
	
	public void deletarCurso(int id) {
		//DELETE FROM cursos WHERE id=?
	}
	
	//Query Sala
	public List<Sala> listarSalas() {
		//SELECT * FROM cursos
		return null;
	}
	
	public Sala listarSala(int id) {
		//SELECT * FROM cursos WHERE id=?
		return null;
	}
	
	public void inserirSala(Sala sala) {
		//INSERT INTO salas (local, capacidade) VALUES ('B-114', 20); 
		
	}
	
	public void editarSala(int id, Sala sala) {
		//UPDATE salas SET local=?, capacidade=? WHERE id=?; 
	}
	
	public void deletarSala(int id) {
		//DELETE FROM salas WHERE id=?
	}
	
	//Query Turma
	public List<Turma> listarTurmas() {
		//SELECT * FROM turmas
		return null;
	}
	
	public Turma listarTurma(int id) {
		//SELECT * FROM turmas WHERE id=?
		return null;
	}
	
	public void inserirTurma(Turma turma) {
		//INSERT INTO turmas (diaSemana, professor, curso, sala) VALUES (?, ?, ?, ?); 
		
	}
	
	public void editarTurma(int id, Turma turma) {
		//UPDATE turmas SET diaSemana=?, professor=?, curso=?, salas=? WHERE id=?; 
	}
	
	public void deletarTurma(int id) {
		//DELETE FROM turmas WHERE id=?
	}
	
	//Query aluno_turma
	public void inserirAluno_turma(int id_aluno, int id_turma) {
		//INSERT INTO aluno_turma (alunos_id, turmas_id) VALUES (?, ?); 
		
	}
	
	public void deletarAluno_turma(int id_aluno, int id_turma) {
		//DELETE FROM turmas WHERE aluno_id=? AND turmas_id=?
	}
	
	public List<Aluno> listarAluno_turma(int id_turma){
		//SELECT * FROM `aluno_turma` WHERE turmas_id=?
		return null;
	}
	
}
