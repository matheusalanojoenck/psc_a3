package visualizacao;

import java.awt.EventQueue;
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
public class AlunoTurmaView {

	private JFrame frame;
	private JTable table;
	private JComboBox turmaComboBox;
	private JComboBox alunoComboBox;
	private int id = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoTurmaView window = new AlunoTurmaView();
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
	public AlunoTurmaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelButtons = new JPanel();
		frame.getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		JButton adicionarButton = new JButton("Adicionar");
		adicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String turma = turmaComboBox.getSelectedItem().toString();
				String aluno = alunoComboBox.getSelectedItem().toString();

				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.addRow(new Object [] {id, turma, aluno});
				
				turmaComboBox.setSelectedItem("");
				alunoComboBox.setSelectedItem("");

				
			}
		});
		panelButtons.add(adicionarButton);
		
		JButton editarButton = new JButton("Editar");
		editarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelButtons.add(editarButton);
		
		JButton deletarButton = new JButton("Deletar");
		deletarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelButtons.add(deletarButton);
		
		JPanel panelTextFields = new JPanel();
		frame.getContentPane().add(panelTextFields, BorderLayout.WEST);
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
		turmaComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Segunda", "Terça", "Quarta", "Quinta", "Sexta"}));
		GridBagConstraints gbc_turmaComboBox = new GridBagConstraints();
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
		
		alunoComboBox = new JComboBox(new DefaultComboBoxModel(new String[] {"", "prof_1"}));
		GridBagConstraints gbc_alunoComboBox = new GridBagConstraints();
		gbc_alunoComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_alunoComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_alunoComboBox.gridx = 1;
		gbc_alunoComboBox.gridy = 1;
		panelTextFields.add(alunoComboBox, gbc_alunoComboBox);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setEnabled(false);
		frame.getContentPane().add(scrollPaneTable, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				nomeTextField.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
//				cpfTextField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
//				enderecoTextField.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
//				emailTextField.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
//				celularTextField.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				
				turmaComboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(), 1).toString());
				alunoComboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(), 2).toString());

			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome Aluno"
			}
		));
		scrollPaneTable.setViewportView(table);
	}

}
