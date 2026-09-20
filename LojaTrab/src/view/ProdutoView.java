package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import model.FaixaEtaria;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ProdutoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField IdField;
	private JTextField qntDisponivelField;
	private JTextField valorField;
	private JLabel descricaoLabel;
	private JTextField descricaoField;
	private JTable produtoTable;
	private JButton cadastrarButton;
	private JButton excluirButton;
	private JButton limparButton;
	private JButton atualizarButton;
	private JComboBox faixaEtariaBox;

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
		nomeLabel.setBounds(10, 71, 89, 14);
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
		
		qntDisponivelField = new JTextField();
		qntDisponivelField.setBounds(146, 109, 76, 20);
		contentPane.add(qntDisponivelField);
		qntDisponivelField.setColumns(10);
		
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
		
		cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setBounds(10, 275, 89, 23);
		contentPane.add(cadastrarButton);
		
		excluirButton = new JButton("Excluir");
		excluirButton.setBounds(123, 275, 89, 23);
		contentPane.add(excluirButton);
		
		atualizarButton = new JButton("Atualizar");
		atualizarButton.setBounds(242, 275, 89, 23);
		contentPane.add(atualizarButton);
		
		limparButton = new JButton("Limpar campos");
		limparButton.setBounds(341, 275, 109, 23);
		contentPane.add(limparButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 309, 774, 191);
		contentPane.add(scrollPane);
		
		produtoTable = new JTable();
		scrollPane.setViewportView(produtoTable);
		
		//this.getExcluirButton().addActionListener(e-> System.out.println("teste"));

	}
	
	
	public JComboBox getFaixaEtariaBox() {
		return faixaEtariaBox;
	}

	public void setFaixaEtariaBox(JComboBox faixaEtariaBox) {
		this.faixaEtariaBox = faixaEtariaBox;
	}

	public JButton getCadastrarButton() {
		return cadastrarButton;
	}

	public void setCadastrarButton(JButton cadastrarButton) {
		this.cadastrarButton = cadastrarButton;
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

	public JButton getAtualizarButton() {
		return atualizarButton;
	}

	public void setAtualizarButton(JButton atualizarButton) {
		this.atualizarButton = atualizarButton;
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

	public JTextField getQntDisponivelField() {
		return qntDisponivelField;
	}

	public void setQntDisponivelField(JTextField qntDisponivelField) {
		this.qntDisponivelField = qntDisponivelField;
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
