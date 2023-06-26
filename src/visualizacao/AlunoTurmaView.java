package visualizacao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.util.List;
import java.util.ArrayList;
import persistencia.DBConnection;
import dados.*;

public class AlunoTurmaView {

	private JFrame frmAlunosturma;
	private JTable table;
	private JComboBox turmaComboBox;
	private JComboBox alunoComboBox;
	private DBConnection db;

	/**
	 * Create the application.
	 */
	public AlunoTurmaView() {
		initialize();
		frmAlunosturma.setVisible(true);
	}
	
	private void atualizaTable(int id_turma) {
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome Aluno"
				}
			));
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		db = new DBConnection();
		db.conectarMariaDB();
		alunos = db.listarAluno_turma(id_turma);
		db.desconectar();
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		for (Aluno aluno : alunos) {
			model.addRow(new Object [] {
					aluno.getId(),
					aluno.getNome()
			});
		}
	}
	
	private String[] turmas() {
		List<Turma> t = new ArrayList<Turma>();
		db = new DBConnection();
		db.conectarMariaDB();
		t = db.listarTurmas();
		db.desconectar();
		String[] turmasReturn = new String[t.size()+1];
		
		for (int i = 0; i < t.size(); i++) {
			turmasReturn[i+1] = t.get(i).toString();
		}
		
		return turmasReturn;
	}
	
	private String[] alunos() {
		List<Aluno> a = new ArrayList<Aluno>();
		db = new DBConnection();
		db.conectarMariaDB();
		a = db.listarAlunos();
		db.desconectar();
		String[] alunosReturn = new String[a.size()+1];
		
		alunosReturn[0] = "";
		for (int i = 0; i < a.size(); i++) {
			alunosReturn[i+1] = a.get(i).toString();
		}
		
		return alunosReturn;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlunosturma = new JFrame();
		frmAlunosturma.setTitle("Alunos/Turma");
		frmAlunosturma.setBounds(100, 100, 450, 300);
		frmAlunosturma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelButtons = new JPanel();
		frmAlunosturma.getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		JButton adicionarButton = new JButton("Adicionar");
		adicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String turma = turmaComboBox.getSelectedItem().toString();
				String aluno = alunoComboBox.getSelectedItem().toString();

				int id_turma = Integer.parseInt(turma.split(" | ")[0]);
				int id_aluno = Integer.parseInt(aluno.split(" | ")[0]);
				
				db = new DBConnection();
				db.conectarMariaDB();
				
				if(db.capacidadeSala(id_turma) == db.qtdAlunosTurma(id_turma)) {
					JOptionPane.showMessageDialog(null, "Turma já esta com capacidade maxima!");
					db.desconectar();
				}else {
					db.inserirAluno_turma(id_aluno, id_turma);
					db.desconectar();
				}
				
				
				
				atualizaTable(id_turma);
			}
		});
		panelButtons.add(adicionarButton);
		
		JButton deletarButton = new JButton("Deletar");
		deletarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String turma = turmaComboBox.getSelectedItem().toString();
				
				int id_turma = Integer.parseInt(turma.split(" | ")[0]);
				int id_aluno = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				
				db = new DBConnection();
				db.conectarMariaDB();
				db.deletarAluno_turma(id_aluno, id_turma);
				db.desconectar();
				
				atualizaTable(id_turma);
			}
		});
		panelButtons.add(deletarButton);
		
		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main();
				frmAlunosturma.dispose();
			}
		});
		panelButtons.add(voltarButton);
		
		JPanel panelTextFields = new JPanel();
		frmAlunosturma.getContentPane().add(panelTextFields, BorderLayout.WEST);
		GridBagLayout gbl_panelTextFields = new GridBagLayout();
		gbl_panelTextFields.columnWidths = new int[]{46, 86, 46, 0};
		gbl_panelTextFields.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_panelTextFields.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelTextFields.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelTextFields.setLayout(gbl_panelTextFields);
		
		JLabel turmaLabel = new JLabel("Turma");
		GridBagConstraints gbc_turmaLabel = new GridBagConstraints();
		gbc_turmaLabel.anchor = GridBagConstraints.EAST;
		gbc_turmaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_turmaLabel.gridx = 0;
		gbc_turmaLabel.gridy = 0;
		panelTextFields.add(turmaLabel, gbc_turmaLabel);
		
		turmaComboBox = new JComboBox();
		turmaComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_turma = Integer.parseInt(turmaComboBox.getSelectedItem().toString().split(" | ")[0]);
				atualizaTable(id_turma);
			}
		});
		turmaComboBox.setModel(new DefaultComboBoxModel(turmas()));
		GridBagConstraints gbc_turmaComboBox = new GridBagConstraints();
		gbc_turmaComboBox.gridwidth = 2;
		gbc_turmaComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_turmaComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_turmaComboBox.gridx = 1;
		gbc_turmaComboBox.gridy = 0;
		panelTextFields.add(turmaComboBox, gbc_turmaComboBox);
		
		JLabel alunoLabel = new JLabel("Aluno");
		GridBagConstraints gbc_alunoLabel = new GridBagConstraints();
		gbc_alunoLabel.anchor = GridBagConstraints.EAST;
		gbc_alunoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_alunoLabel.gridx = 0;
		gbc_alunoLabel.gridy = 1;
		panelTextFields.add(alunoLabel, gbc_alunoLabel);
		
		alunoComboBox = new JComboBox(new DefaultComboBoxModel(alunos()));
		GridBagConstraints gbc_alunoComboBox = new GridBagConstraints();
		gbc_alunoComboBox.gridwidth = 2;
		gbc_alunoComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_alunoComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_alunoComboBox.gridx = 1;
		gbc_alunoComboBox.gridy = 1;
		panelTextFields.add(alunoComboBox, gbc_alunoComboBox);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setEnabled(false);
		frmAlunosturma.getContentPane().add(scrollPaneTable, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				turmaComboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(), 1).toString());
//				alunoComboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(), 2).toString());

			}
		});
		scrollPaneTable.setViewportView(table);
	}

}
