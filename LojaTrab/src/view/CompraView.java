package view;

import java.awt.EventQueue;
import java.util.function.Function;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Produto;
import model.Cliente;
import model.ItemCompra;
import repository.ClientesRepository;
import repository.ProdutosRepository;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class CompraView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable carrinhoTable;
	private DefaultTableModel carrinhoTableModel;
	private JLabel totalLabel;
	private JButton salvarButton;
	private JButton excluirCarrinhoButton;
	private JButton limparButton;
	private JComboBox pagamentoBox;
	private JComboBox<Produto> produtoBox;
	private DefaultComboBoxModel<Produto> produtoBoxModel;
	private JComboBox<Cliente> clienteBox;
	private DefaultComboBoxModel<Cliente> clienteBoxModel;
	private JButton selecionarButton;
	private JLabel subtotalLabel;
	private JButton deletarCarrinhoButton;
	private JButton finalizarButton;
	private JSpinner qntSpinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompraView frame = new CompraView();
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
	public CompraView() {
		setTitle("Comprar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 732, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel produtoLabel = new JLabel("Selecione o produto:");
		produtoLabel.setBounds(22, 44, 132, 14);
		contentPane.add(produtoLabel);
		
		produtoBoxModel = new DefaultComboBoxModel<Produto>();
		produtoBoxModel.addAll(ProdutosRepository.getInstance().listarTodos());
		produtoBox = new JComboBox<Produto>(produtoBoxModel);
		
		
		produtoBox.setBounds(164, 40, 132, 22);
		contentPane.add(produtoBox);
		
		JLabel qntLabel = new JLabel("Selecione a quantidade:");
		qntLabel.setBounds(21, 92, 155, 14);
		contentPane.add(qntLabel);
		
		qntSpinner = new JSpinner();
		qntSpinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		qntSpinner.setBounds(171, 89, 48, 20);
		contentPane.add(qntSpinner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 696, 192);
		contentPane.add(scrollPane);
		
		
		carrinhoTableModel = new DefaultTableModel(new Object[]{"ID","Produto","Quantidade","Valor Unit","Subtotal"},0) {
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};
		
		carrinhoTable = new JTable(carrinhoTableModel);
		scrollPane.setViewportView(carrinhoTable);
		
		carrinhoTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		carrinhoTable.getTableHeader().setReorderingAllowed(false);
		
		salvarButton = new JButton("Salvar");
		salvarButton.setBounds(22, 134, 172, 23);
		contentPane.add(salvarButton);
		
		excluirCarrinhoButton = new JButton("Excluir Produto");
		excluirCarrinhoButton.setEnabled(false);
		excluirCarrinhoButton.setBounds(232, 134, 155, 23);
		contentPane.add(excluirCarrinhoButton);
		
		limparButton = new JButton("Limpar campos");
		limparButton.setBounds(415, 134, 142, 23);
		contentPane.add(limparButton);
		
		deletarCarrinhoButton = new JButton("Deletar carrinho");
		deletarCarrinhoButton.setEnabled(false);
		deletarCarrinhoButton.setBounds(23, 578, 132, 23);
		contentPane.add(deletarCarrinhoButton);
		
		finalizarButton = new JButton("Finalizar Compra");
		finalizarButton.setEnabled(false);
		finalizarButton.setBounds(233, 578, 155, 23);
		contentPane.add(finalizarButton);
		
		totalLabel = new JLabel("Total Final: R$");
		totalLabel.setBounds(23, 553, 154, 14);
		contentPane.add(totalLabel);
		
		JLabel pagamentoLabel = new JLabel("Forma de pagamento");
		pagamentoLabel.setBounds(20, 469, 132, 14);
		contentPane.add(pagamentoLabel);
		
		pagamentoBox = new JComboBox();
		pagamentoBox.setModel(new DefaultComboBoxModel(new String[] {"Cartão", "Pix"}));
		pagamentoBox.setBounds(146, 465, 101, 22);
		contentPane.add(pagamentoBox);
		
		subtotalLabel = new JLabel("SubTotal R$:");
		subtotalLabel.setBounds(575, 371, 131, 14);
		contentPane.add(subtotalLabel);
		
		selecionarButton = new JButton("Confirmar dados");
		selecionarButton.setBounds(10, 509, 197, 22);
		contentPane.add(selecionarButton);
		
		JLabel clienteLabel = new JLabel("Selecione o cliente:");
		clienteLabel.setBounds(10, 417, 116, 14);
		contentPane.add(clienteLabel);
		
		clienteBoxModel = new DefaultComboBoxModel<Cliente>();
		clienteBoxModel.addAll(ClientesRepository.getInstance().listarTodos());
		
		clienteBox = new JComboBox<Cliente>(clienteBoxModel);
		clienteBox.setBounds(136, 413, 126, 22);
		contentPane.add(clienteBox);

	}
	public JLabel getTotalLabel() {
		return totalLabel;
	}
	public JButton getSalvarButton() {
		return salvarButton;
	}
	public JButton getExcluirCarrinhoButton() {
		return excluirCarrinhoButton;
	}
	public JButton getLimparButton() {
		return limparButton;
	}
	public JComboBox getComboBox() {
		return pagamentoBox;
	}
	public JButton getSelecionarButton() {
		return selecionarButton;
	}
	public JLabel getSubtotalLabel() {
		return subtotalLabel;
	}
	public JButton getDeletarCarrinhoButton() {
		return deletarCarrinhoButton;
	}
	public JButton getBtnNewButton() {
		return finalizarButton;
	}
	public JSpinner getQntSpinner() {
		return qntSpinner;
	}
	public JComboBox getProdutoBox() {
		return produtoBox;
	}

	public JTable getCarrinhoTable() {
		return carrinhoTable;
	}

	public DefaultTableModel getCarrinhoTableModel() {
		return carrinhoTableModel;
	}

	public JComboBox getPagamentoBox() {
		return pagamentoBox;
	}

	public DefaultComboBoxModel getProdutoBoxModel() {
		return produtoBoxModel;
	}

	public JButton getFinalizarButton() {
		return finalizarButton;
	}
	public JComboBox getClienteBox() {
		return clienteBox;
	}
	
}
