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

public class AlunosView {

	private JFrame frame;
	private JTextField nomeTextField;
	private JTextField cpfTextField;
	private JTextField enderecoTextField;
	private JTextField EmailTextField;
	private JTextField celularTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunosView window = new AlunosView();
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
	public AlunosView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Adicionar");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Deletar");
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{46, 86, 46, 0};
		gbl_panel_1.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel nomeLabel = new JLabel("Nome");
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 0;
		gbc_nomeLabel.gridy = 0;
		panel_1.add(nomeLabel, gbc_nomeLabel);
		
		nomeTextField = new JTextField();
		nomeTextField.setColumns(10);
		GridBagConstraints gbc_nomeTextField = new GridBagConstraints();
		gbc_nomeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeTextField.gridwidth = 2;
		gbc_nomeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nomeTextField.gridx = 1;
		gbc_nomeTextField.gridy = 0;
		panel_1.add(nomeTextField, gbc_nomeTextField);
		
		JLabel cpfLabel = new JLabel("CPF");
		GridBagConstraints gbc_cpfLabel = new GridBagConstraints();
		gbc_cpfLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cpfLabel.gridx = 0;
		gbc_cpfLabel.gridy = 1;
		panel_1.add(cpfLabel, gbc_cpfLabel);
		
		cpfTextField = new JTextField();
		GridBagConstraints gbc_cpfTextField = new GridBagConstraints();
		gbc_cpfTextField.gridwidth = 2;
		gbc_cpfTextField.insets = new Insets(0, 0, 5, 5);
		gbc_cpfTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cpfTextField.gridx = 1;
		gbc_cpfTextField.gridy = 1;
		panel_1.add(cpfTextField, gbc_cpfTextField);
		cpfTextField.setColumns(10);
		
		JLabel enderecoLabel = new JLabel("Endereço");
		GridBagConstraints gbc_enderecoLabel = new GridBagConstraints();
		gbc_enderecoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_enderecoLabel.gridx = 0;
		gbc_enderecoLabel.gridy = 2;
		panel_1.add(enderecoLabel, gbc_enderecoLabel);
		
		enderecoTextField = new JTextField();
		GridBagConstraints gbc_enderecoTextField = new GridBagConstraints();
		gbc_enderecoTextField.gridwidth = 2;
		gbc_enderecoTextField.insets = new Insets(0, 0, 5, 5);
		gbc_enderecoTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_enderecoTextField.gridx = 1;
		gbc_enderecoTextField.gridy = 2;
		panel_1.add(enderecoTextField, gbc_enderecoTextField);
		enderecoTextField.setColumns(10);
		
		JLabel emailLabel = new JLabel("E-mail");
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 3;
		panel_1.add(emailLabel, gbc_emailLabel);
		
		EmailTextField = new JTextField();
		GridBagConstraints gbc_EmailTextField = new GridBagConstraints();
		gbc_EmailTextField.gridwidth = 2;
		gbc_EmailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_EmailTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_EmailTextField.gridx = 1;
		gbc_EmailTextField.gridy = 3;
		panel_1.add(EmailTextField, gbc_EmailTextField);
		EmailTextField.setColumns(10);
		
		JLabel celularLabel = new JLabel("Celular");
		GridBagConstraints gbc_celularLabel = new GridBagConstraints();
		gbc_celularLabel.insets = new Insets(0, 0, 0, 5);
		gbc_celularLabel.gridx = 0;
		gbc_celularLabel.gridy = 4;
		panel_1.add(celularLabel, gbc_celularLabel);
		
		celularTextField = new JTextField();
		GridBagConstraints gbc_celularTextField = new GridBagConstraints();
		gbc_celularTextField.gridwidth = 2;
		gbc_celularTextField.insets = new Insets(0, 0, 0, 5);
		gbc_celularTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_celularTextField.gridx = 1;
		gbc_celularTextField.gridy = 4;
		panel_1.add(celularTextField, gbc_celularTextField);
		celularTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Endere\u00E7o", "E-mail", "Celular"
			}
		));
		scrollPane.setViewportView(table);
	}

}
