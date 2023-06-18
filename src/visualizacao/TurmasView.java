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
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class TurmasView {

	private JFrame frame;
	private JTextField nomeTextField;
	private JTextField cpfTextField;
	private JTextField enderecoTextField;
	private JTextField emailTextField;
	private JTextField celularTextField;
	private JTable table;
	private int id = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TurmasView window = new TurmasView();
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
	public TurmasView() {
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
				String nome = nomeTextField.getText();
				String cpf = cpfTextField.getText();
				String endereco = enderecoTextField.getText();
				String email = emailTextField.getText();
				String celular = celularTextField.getText();

				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.addRow(new Object [] {id, nome, cpf, endereco, email, celular});
				
				nomeTextField.setText("");
				cpfTextField.setText("");
				enderecoTextField.setText("");
				emailTextField.setText("");
				celularTextField.setText("");
				
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
		
		JLabel cpfLabel = new JLabel("CPF");
		GridBagConstraints gbc_cpfLabel = new GridBagConstraints();
		gbc_cpfLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cpfLabel.gridx = 0;
		gbc_cpfLabel.gridy = 1;
		panelTextFields.add(cpfLabel, gbc_cpfLabel);
		
		cpfTextField = new JTextField();
		GridBagConstraints gbc_cpfTextField = new GridBagConstraints();
		gbc_cpfTextField.gridwidth = 2;
		gbc_cpfTextField.insets = new Insets(0, 0, 5, 5);
		gbc_cpfTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cpfTextField.gridx = 1;
		gbc_cpfTextField.gridy = 1;
		panelTextFields.add(cpfTextField, gbc_cpfTextField);
		cpfTextField.setColumns(10);
		
		JLabel enderecoLabel = new JLabel("Endereço");
		GridBagConstraints gbc_enderecoLabel = new GridBagConstraints();
		gbc_enderecoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_enderecoLabel.gridx = 0;
		gbc_enderecoLabel.gridy = 2;
		panelTextFields.add(enderecoLabel, gbc_enderecoLabel);
		
		enderecoTextField = new JTextField();
		GridBagConstraints gbc_enderecoTextField = new GridBagConstraints();
		gbc_enderecoTextField.gridwidth = 2;
		gbc_enderecoTextField.insets = new Insets(0, 0, 5, 5);
		gbc_enderecoTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_enderecoTextField.gridx = 1;
		gbc_enderecoTextField.gridy = 2;
		panelTextFields.add(enderecoTextField, gbc_enderecoTextField);
		enderecoTextField.setColumns(10);
		
		JLabel emailLabel = new JLabel("E-mail");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 3;
		panelTextFields.add(emailLabel, gbc_emailLabel);
		
		emailTextField = new JTextField();
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.gridwidth = 2;
		gbc_emailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_emailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailTextField.gridx = 1;
		gbc_emailTextField.gridy = 3;
		panelTextFields.add(emailTextField, gbc_emailTextField);
		emailTextField.setColumns(10);
		
		JLabel celularLabel = new JLabel("Celular");
		GridBagConstraints gbc_celularLabel = new GridBagConstraints();
		gbc_celularLabel.insets = new Insets(0, 0, 0, 5);
		gbc_celularLabel.gridx = 0;
		gbc_celularLabel.gridy = 4;
		panelTextFields.add(celularLabel, gbc_celularLabel);
		
		celularTextField = new JTextField();
		GridBagConstraints gbc_celularTextField = new GridBagConstraints();
		gbc_celularTextField.gridwidth = 2;
		gbc_celularTextField.insets = new Insets(0, 0, 0, 5);
		gbc_celularTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_celularTextField.gridx = 1;
		gbc_celularTextField.gridy = 4;
		panelTextFields.add(celularTextField, gbc_celularTextField);
		celularTextField.setColumns(10);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setEnabled(false);
		frame.getContentPane().add(scrollPaneTable, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nomeTextField.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				cpfTextField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				enderecoTextField.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				emailTextField.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				celularTextField.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Endere\u00E7o", "E-mail", "Celular"
			}
		));
		scrollPaneTable.setViewportView(table);
	}

}
