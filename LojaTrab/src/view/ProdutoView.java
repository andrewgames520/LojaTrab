package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import model.FaixaEtaria;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ProdutoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField IdField;
	private JTextField valorField;
	private JLabel descricaoLabel;
	private JTextField descricaoField;
	private JButton salvarButton;
	private JButton excluirButton;
	private JButton limparButton;
	private JComboBox faixaEtariaBox;
	private JSpinner qntSpinner;
	private JTable produtoTable;
	private DefaultTableModel produtoTableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoView frame = new ProdutoView();
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
	public ProdutoView() {
		setTitle("Cadastro Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeLabel = new JLabel("Nome do produto:");
		nomeLabel.setBounds(10, 71, 103, 14);
		contentPane.add(nomeLabel);
		
		nomeField = new JTextField();
		nomeField.setBounds(136, 68, 86, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel qntDisponivelLabel = new JLabel("Quantidade disponivel:");
		qntDisponivelLabel.setBounds(10, 112, 135, 14);
		contentPane.add(qntDisponivelLabel);
		
		JLabel IdLabel = new JLabel("ID:");
		IdLabel.setBounds(10, 27, 23, 14);
		contentPane.add(IdLabel);
		
		IdField = new JTextField();
		IdField.setEditable(false);
		IdField.setBounds(33, 27, 23, 14);
		contentPane.add(IdField);
		IdField.setColumns(10);
		
		JLabel faixaEtariaLabel = new JLabel("Faixa Etaria:");
		faixaEtariaLabel.setBounds(10, 157, 61, 14);
		contentPane.add(faixaEtariaLabel);
		
		JLabel valorLabel = new JLabel("Preço:");
		valorLabel.setBounds(10, 198, 46, 14);
		contentPane.add(valorLabel);
		
		valorField = new JTextField();
		valorField.setBounds(81, 195, 86, 20);
		contentPane.add(valorField);
		valorField.setColumns(10);
		
		descricaoLabel = new JLabel("Descrição:");
		descricaoLabel.setBounds(10, 233, 61, 14);
		contentPane.add(descricaoLabel);
		
		descricaoField = new JTextField();
		descricaoField.setBounds(81, 230, 86, 20);
		contentPane.add(descricaoField);
		descricaoField.setColumns(10);
		
		faixaEtariaBox = new JComboBox();
		faixaEtariaBox.setModel(new DefaultComboBoxModel(FaixaEtaria.values()));
		
		faixaEtariaBox.setBounds(81, 153, 141, 22);
		contentPane.add(faixaEtariaBox);
		
		salvarButton = new JButton("Salvar");
		salvarButton.setBounds(10, 275, 103, 23);
		contentPane.add(salvarButton);
		
		excluirButton = new JButton("Excluir");
		excluirButton.setBounds(123, 275, 99, 23);
		contentPane.add(excluirButton);
		
		limparButton = new JButton("Limpar campos");
		limparButton.setBounds(232, 275, 123, 23);
		contentPane.add(limparButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 309, 774, 191);
		contentPane.add(scrollPane);
		
		produtoTableModel = new DefaultTableModel(new Object[]{"ID","Produto","Quantidade Disponivel","Faixa etaria","Valor","Descrição"},0) {
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};
		produtoTable = new JTable(produtoTableModel);
		scrollPane.setViewportView(produtoTable);
		
		produtoTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		produtoTable.getTableHeader().setReorderingAllowed(false);
		
		qntSpinner = new JSpinner();
		qntSpinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		qntSpinner.setBounds(146, 109, 61, 20);
		contentPane.add(qntSpinner);
		
		//this.getExcluirButton().addActionListener(e-> System.out.println("teste"));

	}
	
	
	public DefaultTableModel getProdutoTableModel() {
		return produtoTableModel;
	}

	public void setProdutoTableModel(DefaultTableModel produtoTableModel) {
		this.produtoTableModel = produtoTableModel;
	}

	public JComboBox getFaixaEtariaBox() {
		return faixaEtariaBox;
	}

	public void setFaixaEtariaBox(JComboBox faixaEtariaBox) {
		this.faixaEtariaBox = faixaEtariaBox;
	}

	public JButton getCadastrarButton() {
		return salvarButton;
	}

	public void setCadastrarButton(JButton cadastrarButton) {
		this.salvarButton = cadastrarButton;
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
	
	public JSpinner getQntSpinner() {
		return qntSpinner;
	}

	public void setQntSpinner(JSpinner qntSpinner) {
		this.qntSpinner = qntSpinner;
	}

	public JTextField getValorField() {
		return valorField;
	}

	public void setValorField(JTextField valorField) {
		this.valorField = valorField;
	}

	public JTextField getDescricaoField() {
		return descricaoField;
	}

	public void setDescricaoField(JTextField descricaoField) {
		this.descricaoField = descricaoField;
	}

	public JTable getProdutoTable() {
		return produtoTable;
	}

	public void setProdutoTable(JTable produtoTable) {
		this.produtoTable = produtoTable;
	}
}
