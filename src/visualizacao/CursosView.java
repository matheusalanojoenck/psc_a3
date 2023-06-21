package visualizacao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.DBConnection;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import dados.Curso;

public class CursosView {

	private JFrame frmCursos;
	private JTextField nomeTextField;
	private JTextField cargaHorariaTextField;
	private JTextField descricaoTextField;
	private JTable table;
	private DBConnection db;

	/**
	 * Create the application.
	 */
	public CursosView() {
		initialize();
		frmCursos.setVisible(true);
	}
	
	private void atualizaTable() {
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "Nome", "Carga Hor\u00E1ria", "Descri\u00E7\u00E3o"
				}
			));
		List<Curso> cursos = new ArrayList<Curso>();
		
		db = new DBConnection();
		db.conectarMariaDB();
		cursos = db.listarCursos();
		db.desconectar();
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		for (Curso curso : cursos) {
			
			model.addRow(new Object [] {
					curso.getId(), 
					curso.getNome(), 
					curso.getCarga_horaria(),
					curso.getDescricao()});
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCursos = new JFrame();
		frmCursos.setTitle("Cursos");
		frmCursos.setBounds(100, 100, 450, 300);
		frmCursos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelButtons = new JPanel();
		frmCursos.getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		JButton adicionarButton = new JButton("Adicionar");
		adicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nomeTextField.getText();
				String cargaHoraria = cargaHorariaTextField.getText();
				String descricao = descricaoTextField.getText();
				
				Curso curso = new Curso();
				curso.setNome(nome);
				curso.setCarga_horaria(Float.parseFloat(cargaHoraria));
				curso.setDescricao(descricao);
				
				db = new DBConnection();
				db.conectarMariaDB();
				db.inserirCurso(curso);
				db.desconectar();
				
				nomeTextField.setText("");
				cargaHorariaTextField.setText("");
				descricaoTextField.setText("");
				
				atualizaTable();
			}
		});
		panelButtons.add(adicionarButton);
		
		JButton editarButton = new JButton("Editar");
		editarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				String nome = nomeTextField.getText();
				String cargaHoraria = cargaHorariaTextField.getText();
				String descricao = descricaoTextField.getText();
				
				Curso curso = new Curso();
				curso.setNome(nome);
				curso.setCarga_horaria(Float.parseFloat(cargaHoraria));
				curso.setDescricao(descricao);
				
				db = new DBConnection();
				db.conectarMariaDB();
				db.editarCurso(id, curso);
				db.desconectar();
				
				nomeTextField.setText("");
				cargaHorariaTextField.setText("");
				descricaoTextField.setText("");
				
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
				db.deletarCurso(id);
				db.desconectar();
				
				atualizaTable();
			}
		});
		panelButtons.add(deletarButton);
		
		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main();
				frmCursos.dispose();
			}
		});
		panelButtons.add(voltarButton);
		
		JPanel panelTextFields = new JPanel();
		frmCursos.getContentPane().add(panelTextFields, BorderLayout.WEST);
		GridBagLayout gbl_panelTextFields = new GridBagLayout();
		gbl_panelTextFields.columnWidths = new int[]{46, 86, 46, 0};
		gbl_panelTextFields.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_panelTextFields.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTextFields.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelTextFields.setLayout(gbl_panelTextFields);
		
		JLabel nomeLabel = new JLabel("Nome");
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 0;
		gbc_nomeLabel.gridy = 0;
		panelTextFields.add(nomeLabel, gbc_nomeLabel);
		
		nomeTextField = new JTextField();
		nomeTextField.setColumns(10);
		GridBagConstraints gbc_nomeTextField = new GridBagConstraints();
		gbc_nomeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeTextField.gridwidth = 2;
		gbc_nomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTextField.gridx = 1;
		gbc_nomeTextField.gridy = 0;
		panelTextFields.add(nomeTextField, gbc_nomeTextField);
		
		JLabel cargaHorariaLabel = new JLabel("Carga Horária");
		GridBagConstraints gbc_cargaHorariaLabel = new GridBagConstraints();
		gbc_cargaHorariaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cargaHorariaLabel.gridx = 0;
		gbc_cargaHorariaLabel.gridy = 1;
		panelTextFields.add(cargaHorariaLabel, gbc_cargaHorariaLabel);
		
		cargaHorariaTextField = new JTextField();
		GridBagConstraints gbc_cargaHorariaTextField = new GridBagConstraints();
		gbc_cargaHorariaTextField.gridwidth = 2;
		gbc_cargaHorariaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_cargaHorariaTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cargaHorariaTextField.gridx = 1;
		gbc_cargaHorariaTextField.gridy = 1;
		panelTextFields.add(cargaHorariaTextField, gbc_cargaHorariaTextField);
		cargaHorariaTextField.setColumns(10);
		
		JLabel descricaoLabel = new JLabel("Descrição");
		GridBagConstraints gbc_descricaoLabel = new GridBagConstraints();
		gbc_descricaoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_descricaoLabel.gridx = 0;
		gbc_descricaoLabel.gridy = 2;
		panelTextFields.add(descricaoLabel, gbc_descricaoLabel);
		
		descricaoTextField = new JTextField();
		GridBagConstraints gbc_descricaoTextField = new GridBagConstraints();
		gbc_descricaoTextField.gridwidth = 2;
		gbc_descricaoTextField.insets = new Insets(0, 0, 5, 5);
		gbc_descricaoTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_descricaoTextField.gridx = 1;
		gbc_descricaoTextField.gridy = 2;
		panelTextFields.add(descricaoTextField, gbc_descricaoTextField);
		descricaoTextField.setColumns(10);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setEnabled(false);
		frmCursos.getContentPane().add(scrollPaneTable, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nomeTextField.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				cargaHorariaTextField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				descricaoTextField.setText(table.getValueAt(table.getSelectedRow(), 3).toString());

			}
		});
		atualizaTable();
		scrollPaneTable.setViewportView(table);
	}

}
