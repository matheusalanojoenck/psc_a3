package visualizacao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
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

public class TurmasView {

	private JFrame frmTurmas;
	private JTable table;
	private JComboBox diaSemanaComboBox;
	private JComboBox professorComboBox;
	private JComboBox cursoComboBox;
	private JComboBox salaComboBox;
	private DBConnection db;

	/**
	 * Create the application.
	 */
	public TurmasView() {
		initialize();
		frmTurmas.setVisible(true);
	}
	
	private void atualizaTable() {
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Dia", "Professor", "Curso", "Sala"
				}
			));
		List<Turma> turmas = new ArrayList<Turma>();
		
		db = new DBConnection();
		db.conectarMariaDB();
		turmas = db.listarTurmas();
		db.desconectar();
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		//model.addRow(new Object [] {id, diaSemana, professor, curso, sala});
		
		for (Turma turma : turmas) {
			model.addRow(new Object [] {
					turma.getId(), 
					turma.getDiaSemana().toString(), 
					turma.getProfessor().toString(), 
					turma.getCurso().toString(), 
					turma.getSala().toString()});
		}
	}
	
	private String[] professores() {
		List<Professor> profs = new ArrayList<Professor>();
		db = new DBConnection();
		db.conectarMariaDB();
		profs = db.listarProfessores();
		db.desconectar();
		String[] profsReturn = new String[profs.size()+1];
		
		profsReturn[0] = "";
		for (int i = 0; i < profs.size(); i++) {
			profsReturn[i+1] = profs.get(i).toString();
		}
		
		return profsReturn;
	}
	
	private String[] cursos() {
		
		List<Curso> c = new ArrayList<Curso>();
		db = new DBConnection();
		db.conectarMariaDB();
		c = db.listarCursos();
		db.desconectar();
		String[] cursosReturn = new String[c.size()+1];
		
		cursosReturn[0] = "";
		for (int i = 0; i < c.size(); i++) {
			cursosReturn[i+1] = c.get(i).toString();
		}
		
		return cursosReturn;
	}
	
	private String[] salas() {
		
		List<Sala> s = new ArrayList<Sala>();
		db = new DBConnection();
		db.conectarMariaDB();
		s = db.listarSalas();
		db.desconectar();
		String[] salaReturn = new String[s.size()+1];
		
		salaReturn[0] = "";
		for (int i = 0; i < s.size(); i++) {
			salaReturn[i+1] = s.get(i).toString();
		}
		
		return salaReturn;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTurmas = new JFrame();
		frmTurmas.setTitle("Turmas");
		frmTurmas.setBounds(100, 100, 450, 300);
		frmTurmas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelButtons = new JPanel();
		frmTurmas.getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		JButton adicionarButton = new JButton("Adicionar");
		adicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String diaSemana = diaSemanaComboBox.getSelectedItem().toString();
				String professor = professorComboBox.getSelectedItem().toString();
				String curso = cursoComboBox.getSelectedItem().toString();
				String sala = salaComboBox.getSelectedItem().toString();
				
				int id_professor = Integer.parseInt(professor.split(" | ")[0]);
				int id_curso = Integer.parseInt(curso.split(" | ")[0]);
				int id_sala = Integer.parseInt(sala.split(" | ")[0]);
				
				db = new DBConnection();
				db.conectarMariaDB();
				Professor p = db.listarProfessor(id_professor);
				Curso c = db.listarCurso(id_curso);
				Sala s = db.listarSala(id_sala);
				
				
				Turma turma = new Turma();
				turma.setDiaSemana(DiasSemana.valueOf(diaSemana));
				turma.setProfessor(p);
				turma.setCurso(c);
				turma.setSala(s);
				
				db.inserirTurma(turma);
				db.desconectar();
				
				diaSemanaComboBox.setSelectedItem("");
				professorComboBox.setSelectedItem("");
				cursoComboBox.setSelectedItem("");
				salaComboBox.setSelectedItem("");
				
				atualizaTable();
			}
		});
		panelButtons.add(adicionarButton);
		
		JButton editarButton = new JButton("Editar");
		editarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				String diaSemana = diaSemanaComboBox.getSelectedItem().toString();
				String professor = professorComboBox.getSelectedItem().toString();
				String curso = cursoComboBox.getSelectedItem().toString();
				String sala = salaComboBox.getSelectedItem().toString();
				
				int id_professor = Integer.parseInt(professor.split(" | ")[0]);
				int id_curso = Integer.parseInt(curso.split(" | ")[0]);
				int id_sala = Integer.parseInt(sala.split(" | ")[0]);
				
				db = new DBConnection();
				db.conectarMariaDB();
				Professor p = db.listarProfessor(id_professor);
				Curso c = db.listarCurso(id_curso);
				Sala s = db.listarSala(id_sala);
				
				Turma turma = new Turma();
				turma.setDiaSemana(DiasSemana.valueOf(diaSemana));
				turma.setProfessor(p);
				turma.setCurso(c);
				turma.setSala(s);
				
				db.editarTurma(id, turma);
				db.desconectar();
				
				diaSemanaComboBox.setSelectedItem("");
				professorComboBox.setSelectedItem("");
				cursoComboBox.setSelectedItem("");
				salaComboBox.setSelectedItem("");
				
				atualizaTable();
				
			}
		});
		panelButtons.add(editarButton);
		
		JButton deletarButton = new JButton("Deletar");
		deletarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				
				db = new DBConnection();
				db.conectarMariaDB();
				db.deletarTurma(id);
				db.desconectar();
				
				atualizaTable();
			}
		});
		panelButtons.add(deletarButton);
		
		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main();
				frmTurmas.dispose();
			}
		});
		panelButtons.add(voltarButton);
		
		JPanel panelTextFields = new JPanel();
		frmTurmas.getContentPane().add(panelTextFields, BorderLayout.WEST);
		GridBagLayout gbl_panelTextFields = new GridBagLayout();
		gbl_panelTextFields.columnWidths = new int[]{46, 86, 46, 0};
		gbl_panelTextFields.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_panelTextFields.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelTextFields.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelTextFields.setLayout(gbl_panelTextFields);
		
		JLabel diaSemanaLabel = new JLabel("Dia");
		GridBagConstraints gbc_diaSemanaLabel = new GridBagConstraints();
		gbc_diaSemanaLabel.anchor = GridBagConstraints.EAST;
		gbc_diaSemanaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_diaSemanaLabel.gridx = 0;
		gbc_diaSemanaLabel.gridy = 0;
		panelTextFields.add(diaSemanaLabel, gbc_diaSemanaLabel);
		
		diaSemanaComboBox = new JComboBox<>();
		diaSemanaComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"", "SEGUNDA", "TERÇA", "QUARTA", "QUINTA", "SEXTA"}));
		GridBagConstraints gbc_diaSemanaComboBox = new GridBagConstraints();
		gbc_diaSemanaComboBox.gridwidth = 2;
		gbc_diaSemanaComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_diaSemanaComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_diaSemanaComboBox.gridx = 1;
		gbc_diaSemanaComboBox.gridy = 0;
		panelTextFields.add(diaSemanaComboBox, gbc_diaSemanaComboBox);
		
		JLabel professorLabel = new JLabel("Professor");
		GridBagConstraints gbc_professorLabel = new GridBagConstraints();
		gbc_professorLabel.anchor = GridBagConstraints.EAST;
		gbc_professorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_professorLabel.gridx = 0;
		gbc_professorLabel.gridy = 1;
		panelTextFields.add(professorLabel, gbc_professorLabel);
		
		professorComboBox = new JComboBox<>(new DefaultComboBoxModel<>(professores()));
		GridBagConstraints gbc_professorComboBox = new GridBagConstraints();
		gbc_professorComboBox.gridwidth = 2;
		gbc_professorComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_professorComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_professorComboBox.gridx = 1;
		gbc_professorComboBox.gridy = 1;
		panelTextFields.add(professorComboBox, gbc_professorComboBox);
		
		JLabel cursoLabel = new JLabel("Curso");
		GridBagConstraints gbc_cursoLabel = new GridBagConstraints();
		gbc_cursoLabel.anchor = GridBagConstraints.EAST;
		gbc_cursoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cursoLabel.gridx = 0;
		gbc_cursoLabel.gridy = 2;
		panelTextFields.add(cursoLabel, gbc_cursoLabel);
		
		cursoComboBox = new JComboBox<>(new DefaultComboBoxModel<>(cursos()));
		GridBagConstraints gbc_cursoComboBox = new GridBagConstraints();
		gbc_cursoComboBox.gridwidth = 2;
		gbc_cursoComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_cursoComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_cursoComboBox.gridx = 1;
		gbc_cursoComboBox.gridy = 2;
		panelTextFields.add(cursoComboBox, gbc_cursoComboBox);
		
		JLabel salaLabel = new JLabel("Sala");
		GridBagConstraints gbc_salaLabel = new GridBagConstraints();
		gbc_salaLabel.anchor = GridBagConstraints.EAST;
		gbc_salaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_salaLabel.gridx = 0;
		gbc_salaLabel.gridy = 3;
		panelTextFields.add(salaLabel, gbc_salaLabel);
		
		salaComboBox = new JComboBox<>(new DefaultComboBoxModel<>(salas()));
		GridBagConstraints gbc_salaComboBox = new GridBagConstraints();
		gbc_salaComboBox.gridwidth = 2;
		gbc_salaComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_salaComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_salaComboBox.gridx = 1;
		gbc_salaComboBox.gridy = 3;
		panelTextFields.add(salaComboBox, gbc_salaComboBox);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setEnabled(false);
		frmTurmas.getContentPane().add(scrollPaneTable, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				nomeTextField.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
//				cpfTextField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
//				enderecoTextField.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
//				emailTextField.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
//				celularTextField.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				
				diaSemanaComboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(), 1).toString());
				professorComboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(), 2).toString());
				cursoComboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(), 3).toString());
				salaComboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(), 4).toString());
			}
		});
		atualizaTable();
		scrollPaneTable.setViewportView(table);
	}

}
