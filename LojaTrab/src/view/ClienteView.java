package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class ClienteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField IdField;
	private JTextField cpfField;
	private JTable clienteTable;
	private DefaultTableModel clienteTableModel;
	private JButton salvarButton;
	private JButton excluirButton;
	private JButton limparButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteView frame = new ClienteView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteView() {
		setTitle("Cadastro Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeLabel = new JLabel("Nome do cliente:");
		nomeLabel.setBounds(10, 110, 95, 14);
		contentPane.add(nomeLabel);
		
		nomeField = new JTextField();
		nomeField.setBounds(103, 107, 86, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel cpfLabel = new JLabel("CPF:");
		cpfLabel.setBounds(10, 151, 49, 14);
		contentPane.add(cpfLabel);
		
		JLabel IdLabel = new JLabel("ID:");
		IdLabel.setBounds(10, 85, 23, 14);
		contentPane.add(IdLabel);
		
		IdField = new JTextField();
		IdField.setEditable(false);
		IdField.setBounds(43, 85, 49, 14);
		contentPane.add(IdField);
		IdField.setColumns(10);
		
		cpfField = new JTextField();
		cpfField.setBounds(49, 148, 86, 20);
		contentPane.add(cpfField);
		cpfField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 301, 763, 199);
		contentPane.add(scrollPane);
		
		clienteTableModel = new DefaultTableModel(new Object[]{"ID","Nome","CPF"},0) {
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};
		
		clienteTable = new JTable(clienteTableModel);
		scrollPane.setViewportView(clienteTable);
		clienteTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		clienteTable.getTableHeader().setReorderingAllowed(false);
		
		salvarButton = new JButton("Salvar");
		salvarButton.setBounds(21, 267, 89, 23);
		contentPane.add(salvarButton);
		
		excluirButton = new JButton("Excluir");
		excluirButton.setBounds(138, 267, 89, 23);
		contentPane.add(excluirButton);
		
		limparButton = new JButton("Limpar Campos");
		limparButton.setBounds(263, 267, 128, 23);
		contentPane.add(limparButton);

	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	public JTextField getIdField() {
		return IdField;
	}

	public void setIdField(JTextField idField) {
		IdField = idField;
	}

	public JTextField getCpfField() {
		return cpfField;
	}

	public void setCpfField(JTextField cpfField) {
		this.cpfField = cpfField;
	}

	public JTable getClienteTable() {
		return clienteTable;
	}

	public void setClienteTable(JTable clienteTable) {
		this.clienteTable = clienteTable;
	}

	public DefaultTableModel getClienteTableModel() {
		return clienteTableModel;
	}

	public void setClienteTableModel(DefaultTableModel clienteTableModel) {
		this.clienteTableModel = clienteTableModel;
	}

	public JButton getSalvarButton() {
		return salvarButton;
	}

	public void setSalvarButton(JButton salvarButton) {
		this.salvarButton = salvarButton;
	}

	public JButton getExcluirButton() {
		return excluirButton;
	}

	public void setExcluirButton(JButton excluirButton) {
		this.excluirButton = excluirButton;
	}

	public JButton getLimparButton() {
		return limparButton;
	}

	public void setLimparButton(JButton limparButton) {
		this.limparButton = limparButton;
	}
	
}
