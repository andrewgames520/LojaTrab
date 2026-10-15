package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import model.Ocupacao;

public class FuncionarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JTextField nomeField;
	private JTextField cpfField;
	private JTextField salarioField;
	private JButton salvarButton;
	private JButton excluirButton;
	private JButton limparButton;
	private JScrollPane scrollPane;
	private JTable funcionariosTable;
	private DefaultTableModel funcionariosTableModel;
	private JComboBox ocupacaoBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioView frame = new FuncionarioView();
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
	public FuncionarioView() {
		setTitle("Cadastro de funcionario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(10, 57, 46, 14);
		contentPane.add(idLabel);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(10, 86, 46, 14);
		contentPane.add(nomeLabel);
		
		JLabel salarioLabel = new JLabel("Salario:");
		salarioLabel.setBounds(10, 160, 67, 14);
		contentPane.add(salarioLabel);
		
		JLabel ocupacaoLabel = new JLabel("Ocupação:");
		ocupacaoLabel.setBounds(10, 199, 67, 14);
		contentPane.add(ocupacaoLabel);
		
		JLabel cpfLabel = new JLabel("CPF:");
		cpfLabel.setBounds(10, 118, 46, 14);
		contentPane.add(cpfLabel);
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(78, 54, 40, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		nomeField = new JTextField();
		nomeField.setBounds(78, 86, 86, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		cpfField = new JTextField();
		cpfField.setBounds(78, 118, 86, 20);
		contentPane.add(cpfField);
		cpfField.setColumns(10);
		
		salarioField = new JTextField();
		salarioField.setBounds(78, 160, 86, 20);
		contentPane.add(salarioField);
		salarioField.setColumns(10);
		
		salvarButton = new JButton("Salvar");
		salvarButton.setBounds(10, 270, 89, 23);
		contentPane.add(salvarButton);
		
		excluirButton = new JButton("Excluir");
		excluirButton.setBounds(126, 270, 89, 23);
		contentPane.add(excluirButton);
		
		limparButton = new JButton("Limpar Campos");
		limparButton.setBounds(243, 270, 112, 23);
		contentPane.add(limparButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 348, 774, 155);
		contentPane.add(scrollPane);
		
		ocupacaoBox = new JComboBox();
		ocupacaoBox.setModel(new DefaultComboBoxModel(Ocupacao.values()));
		ocupacaoBox.setBounds(87, 195, 77, 22);
		contentPane.add(ocupacaoBox);
		
		
		funcionariosTableModel = new DefaultTableModel(new Object[]{"ID","Nome","Salário","Ocupação","CPF"},0) {
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};		
		funcionariosTable = new JTable(funcionariosTableModel);
		scrollPane.setViewportView(funcionariosTable);
		
		funcionariosTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		funcionariosTable.getTableHeader().setReorderingAllowed(false);
		
	}
	
	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	public JTextField getCpfField() {
		return cpfField;
	}

	public void setCpfField(JTextField cpfField) {
		this.cpfField = cpfField;
	}

	public JTextField getSalarioField() {
		return salarioField;
	}

	public void setSalarioField(JTextField salarioField) {
		this.salarioField = salarioField;
	}

	

	public JComboBox getOcupacaoBox() {
		return ocupacaoBox;
	}

	public void setOcupacaoBox(JComboBox ocupacaoBox) {
		this.ocupacaoBox = ocupacaoBox;
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

	public JTable getFuncionariosTable() {
		return funcionariosTable;
	}

	public void setFuncionariosTable(JTable funcionariosTable) {
		this.funcionariosTable = funcionariosTable;
	}

	public DefaultTableModel getFuncionariosTableModel() {
		return funcionariosTableModel;
	}

	public void setFuncionariosTableModel(DefaultTableModel funcionariosTableModel) {
		this.funcionariosTableModel = funcionariosTableModel;
	}
}
