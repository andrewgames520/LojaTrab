package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.FaixaEtaria;
import model.Ocupacao;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.function.Function;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ConsultaFuncionarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton consultarButton;
	private JScrollPane scrollPane;
	private JTable funcionariosTable;
	private DefaultTableModel funcionariosTableModel;
	private JLabel ocupacaoLabel;
	private JComboBox ocupacaoBox;
	private DefaultComboBoxModel ocupacaoBoxModel;
	private JLabel minimoLabel;
	private JLabel maximoLabel;
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
					ConsultaFuncionarioView frame = new ConsultaFuncionarioView();
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
	public ConsultaFuncionarioView() {
		setTitle("Consulta Funcionarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		consultarButton = new JButton("Consultar");
		consultarButton.setBounds(21, 268, 101, 23);
		contentPane.add(consultarButton);
		
		limparButton = new JButton("Limpar Filtros");
		limparButton.setBounds(158, 268, 127, 23);
		contentPane.add(limparButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 334, 864, 187);
		contentPane.add(scrollPane);
		
		funcionariosTableModel = new DefaultTableModel(new Object[]{"ID","Nome","Salário","Ocupação","CPF"},0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		
		funcionariosTable = new JTable(funcionariosTableModel);
		scrollPane.setViewportView(funcionariosTable);
		
		funcionariosTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		funcionariosTable.getTableHeader().setReorderingAllowed(false);
		funcionariosTable.setAutoCreateRowSorter(true);
		
		ocupacaoLabel = new JLabel("Filtrar por ocupação:");
		ocupacaoLabel.setBounds(21, 100, 148, 14);
		contentPane.add(ocupacaoLabel);
		
		ocupacaoBoxModel = new DefaultComboBoxModel<>();
		ocupacaoBoxModel.addElement("Todas as ocupações");
		
		Function<Ocupacao,String> ocupar = o-> o.toString();
		
		for(Ocupacao ocupacao: Ocupacao.values()) {
			ocupacaoBoxModel.addElement(ocupar.apply(ocupacao));;
		}
		
		ocupacaoBox = new JComboBox(ocupacaoBoxModel);
		ocupacaoBox.setBounds(139, 96, 108, 22);
		contentPane.add(ocupacaoBox);
		
		minimoLabel = new JLabel("Salario minimo R$:");
		minimoLabel.setBounds(21, 148, 118, 14);
		contentPane.add(minimoLabel);
		
		maximoLabel = new JLabel("Salario máximo R$:");
		maximoLabel.setBounds(21, 201, 118, 14);
		contentPane.add(maximoLabel);
		
		minimoField = new JTextField();
		minimoField.setBounds(139, 145, 86, 20);
		contentPane.add(minimoField);
		minimoField.setColumns(10);
		
		maximoField = new JTextField();
		maximoField.setBounds(139, 201, 86, 20);
		contentPane.add(maximoField);
		maximoField.setColumns(10);

	}
	
	public JTable getFuncionariosTable() {
		return funcionariosTable;
	}

	public DefaultTableModel getFuncionariosTableModel() {
		return funcionariosTableModel;
	}

	public DefaultComboBoxModel getOcupacaoBoxModel() {
		return ocupacaoBoxModel;
	}
	

	public JComboBox getOcupacaoBox() {
		return ocupacaoBox;
	}

	public JTextField getMinimoField() {
		return minimoField;
	}

	public JTextField getMaximoField() {
		return maximoField;
	}

	public JButton getConsultarButton() {
		return consultarButton;
	}
	public JButton getLimparButton() {
		return limparButton;
	}
}
