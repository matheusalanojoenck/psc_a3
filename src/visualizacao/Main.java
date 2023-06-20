package visualizacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton alunoButton = new JButton("Aluno");
		alunoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AlunosView();
				frame.dispose();
			}
		});
		panel.add(alunoButton);
		
		JButton professorButton = new JButton("Professor");
		professorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProfessoresView();
				frame.dispose();
			}
		});
		panel.add(professorButton);
		
		JButton cursoButton = new JButton("Curso");
		cursoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CursosView();
				frame.dispose();
			}
		});
		panel.add(cursoButton);
		
		JButton salaButton = new JButton("Sala");
		salaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalasView();
				frame.dispose();
			}
		});
		panel.add(salaButton);
		
		JButton turmaButton = new JButton("Turma");
		turmaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TurmasView();
				frame.dispose();
			}
		});
		panel.add(turmaButton);
		
		JButton alunoTurmaButton = new JButton("Aluno Turma");
		alunoTurmaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AlunoTurmaView();
				frame.dispose();
			}
		});
		panel.add(alunoTurmaButton);
		
	}

}
