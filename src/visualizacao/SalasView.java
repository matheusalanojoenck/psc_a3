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
public class SalasView {

	private JFrame frame;
	private JTextField localTextField;
	private JTextField capacidadeTextField;
	private JTable table;
	private int id = 0;

	/**
	 * Create the application.
	 */
	public SalasView() {
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
		
		JPanel panelButtons = new JPanel();
		frame.getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		JButton adicionarButton = new JButton("Adicionar");
		adicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String local = localTextField.getText();
				String capacidade = capacidadeTextField.getText();
			
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.addRow(new Object [] {id, local, capacidade});
				
				localTextField.setText("");
				capacidadeTextField.setText("");
					
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
		
		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main();
				frame.dispose();
			}
		});
		panelButtons.add(voltarButton);
		
		JPanel panelTextFields = new JPanel();
		frame.getContentPane().add(panelTextFields, BorderLayout.WEST);
		GridBagLayout gbl_panelTextFields = new GridBagLayout();
		gbl_panelTextFields.columnWidths = new int[]{46, 86, 46, 0};
		gbl_panelTextFields.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_panelTextFields.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTextFields.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelTextFields.setLayout(gbl_panelTextFields);
		
		JLabel localLabel = new JLabel("Local");
		GridBagConstraints gbc_localLabel = new GridBagConstraints();
		gbc_localLabel.insets = new Insets(0, 0, 5, 5);
		gbc_localLabel.gridx = 0;
		gbc_localLabel.gridy = 0;
		panelTextFields.add(localLabel, gbc_localLabel);
		
		localTextField = new JTextField();
		localTextField.setColumns(10);
		GridBagConstraints gbc_localTextField = new GridBagConstraints();
		gbc_localTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_localTextField.gridwidth = 2;
		gbc_localTextField.insets = new Insets(0, 0, 5, 5);
		gbc_localTextField.gridx = 1;
		gbc_localTextField.gridy = 0;
		panelTextFields.add(localTextField, gbc_localTextField);
		
		JLabel capacidadeLabel = new JLabel("Capacidade");
		GridBagConstraints gbc_capacidadeLabel = new GridBagConstraints();
		gbc_capacidadeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_capacidadeLabel.gridx = 0;
		gbc_capacidadeLabel.gridy = 1;
		panelTextFields.add(capacidadeLabel, gbc_capacidadeLabel);
		
		capacidadeTextField = new JTextField();
		GridBagConstraints gbc_capacidadeTextField = new GridBagConstraints();
		gbc_capacidadeTextField.gridwidth = 2;
		gbc_capacidadeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_capacidadeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_capacidadeTextField.gridx = 1;
		gbc_capacidadeTextField.gridy = 1;
		panelTextFields.add(capacidadeTextField, gbc_capacidadeTextField);
		capacidadeTextField.setColumns(10);
		
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setEnabled(false);
		frame.getContentPane().add(scrollPaneTable, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				localTextField.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				capacidadeTextField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Local", "Capacidade"
			}
		));
		scrollPaneTable.setViewportView(table);
	}

}
