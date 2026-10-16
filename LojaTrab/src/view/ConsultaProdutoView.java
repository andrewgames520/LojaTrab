package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.function.Function;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import model.FaixaEtaria;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class ConsultaProdutoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable produtosTable;
	private JButton consultarButton;
	private JComboBox faixaEtariaBox;
	private DefaultComboBoxModel faixaEtariaBoxModel;
	private DefaultTableModel produtosTableModel;
	private JLabel minimoLabel;
	private JTextField minimoField;
	private JTextField maximoField;
	private JButton limparButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProdutoView frame = new ConsultaProdutoView();
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
	public ConsultaProdutoView() {
		setTitle("Consulta de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		consultarButton = new JButton("Consultar");
		consultarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		consultarButton.setBounds(10, 247, 89, 23);
		contentPane.add(consultarButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 301, 864, 122);
		contentPane.add(scrollPane);
		produtosTableModel = new DefaultTableModel(new Object[]{"ID","Produto","Quantidade Disponivel","Faixa etaria","Valor","Descrição"},0) {
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};
		
		produtosTable = new JTable(produtosTableModel);
		produtosTable.getTableHeader().setReorderingAllowed(false);
		
		produtosTable.getColumnModel().getColumn(0).setResizable(false);
		produtosTable.getColumnModel().getColumn(1).setResizable(false);
		produtosTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		produtosTable.getColumnModel().getColumn(2).setResizable(false);
		produtosTable.getColumnModel().getColumn(2).setPreferredWidth(90);
		produtosTable.getColumnModel().getColumn(3).setResizable(false);
		produtosTable.getColumnModel().getColumn(4).setResizable(false);
		produtosTable.getColumnModel().getColumn(5).setResizable(false);
		produtosTable.getColumnModel().getColumn(5).setPreferredWidth(90);
		scrollPane.setViewportView(produtosTable);
		produtosTable.setAutoCreateRowSorter(true);
		
		JLabel faixaEtariaLabel = new JLabel("Filtrar por faixa etária:");
		faixaEtariaLabel.setBounds(10, 149, 150, 14);
		contentPane.add(faixaEtariaLabel);
		
		faixaEtariaBoxModel = new DefaultComboBoxModel<>();
		faixaEtariaBoxModel.addElement("Todas as faixas");
		
		Function<FaixaEtaria,String> rotular = f-> f.getRotulo();
		
		for(FaixaEtaria faixa: FaixaEtaria.values()) {
			faixaEtariaBoxModel.addElement(rotular.apply(faixa));;
		}
		
		faixaEtariaBox = new JComboBox(faixaEtariaBoxModel);
		faixaEtariaBox.setBounds(143, 145, 106, 22);
		contentPane.add(faixaEtariaBox);
		
		minimoLabel = new JLabel("Valor Minimo R$:");
		minimoLabel.setBounds(10, 179, 111, 14);
		contentPane.add(minimoLabel);
		
		minimoField = new JTextField();
		minimoField.setBounds(114, 174, 86, 20);
		contentPane.add(minimoField);
		minimoField.setColumns(10);
		
		JLabel maximoLabel = new JLabel("Valor Maximo R$:");
		maximoLabel.setBounds(10, 204, 111, 14);
		contentPane.add(maximoLabel);
		
		maximoField = new JTextField();
		maximoField.setToolTipText("");
		maximoField.setBounds(114, 207, 86, 20);
		contentPane.add(maximoField);
		maximoField.setColumns(10);
		
		limparButton = new JButton("Limpar Filtros");
		limparButton.setBounds(124, 247, 125, 23);
		contentPane.add(limparButton);

	}
	public JButton getConsultarButton() {
		return consultarButton;
	}
	public JComboBox getfaixaEtariaBox() {
		return faixaEtariaBox;
	}

	public JTable getProdutosTable() {
		return produtosTable;
	}

	public DefaultTableModel getProdutosTableModel() {
		return produtosTableModel;
	}
	public JTextField getMinimoField() {
		return minimoField;
	}
	public JTextField getMaximoField() {
		return maximoField;
	}
	public JButton getLimparButton() {
		return limparButton;
	}
	
}
