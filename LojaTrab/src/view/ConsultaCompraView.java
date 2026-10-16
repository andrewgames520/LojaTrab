package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.Status;
import repository.ClientesRepository;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ConsultaCompraView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable compraTable;
	private DefaultTableModel compraTableModel;
	private JTextField minField;
	private JTextField maxField;
	private JComboBox<Status> statusBox;
	private DefaultComboBoxModel statusBoxModel;
	private JComboBox<Cliente> clienteBox;
	private DefaultComboBoxModel clienteBoxModel;
	private JButton consultarButton;
	private JButton finalizarButton;
	private JButton limparButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCompraView frame = new ConsultaCompraView();
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
	public ConsultaCompraView() {
		setTitle("Consulta Compras");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 790, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 246, 754, 141);
		contentPane.add(scrollPane);
		
		compraTableModel = new DefaultTableModel(new Object[]{"ID","Cliente","Total","Status"},0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		compraTable = new JTable(compraTableModel);
		scrollPane.setViewportView(compraTable);
		
		compraTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		compraTable.getTableHeader().setReorderingAllowed(false);
		compraTable.setAutoCreateRowSorter(true);
		
		JLabel clienteLabel = new JLabel("Cliente");
		clienteLabel.setBounds(10, 52, 46, 14);
		contentPane.add(clienteLabel);
		
		clienteBoxModel = new DefaultComboBoxModel<>();
		clienteBoxModel.addElement("TODOS CLIENTES");
		clienteBoxModel.addAll(ClientesRepository.getInstance().listarTodos());
		
		clienteBox = new JComboBox<Cliente>(clienteBoxModel);
		clienteBox.setBounds(66, 48, 88, 22);
		contentPane.add(clienteBox);
		
		JLabel statusLabel = new JLabel("Status da compra:");
		statusLabel.setBounds(10, 93, 104, 14);
		contentPane.add(statusLabel);
		
		statusBoxModel = new DefaultComboBoxModel<>();
		statusBoxModel.addElement("TODOS STATUS");
		
		for(Status s : Status.values()) {
			statusBoxModel.addElement(s);
		}
		
		statusBox = new JComboBox<Status>(statusBoxModel);
		statusBox.setBounds(124, 89, 139, 22);
		contentPane.add(statusBox);
		
		JLabel minLabel = new JLabel("Valor minimo:");
		minLabel.setBounds(10, 141, 104, 14);
		contentPane.add(minLabel);
		
		JLabel maxLabel = new JLabel("Valor maximo:");
		maxLabel.setBounds(10, 178, 104, 14);
		contentPane.add(maxLabel);
		
		minField = new JTextField();
		minField.setBounds(102, 138, 76, 20);
		contentPane.add(minField);
		minField.setColumns(10);
		
		maxField = new JTextField();
		maxField.setBounds(102, 175, 76, 20);
		contentPane.add(maxField);
		maxField.setColumns(10);
		
		consultarButton = new JButton("Consultar");
		consultarButton.setBounds(20, 212, 89, 23);
		contentPane.add(consultarButton);
		
		finalizarButton = new JButton("Finalizar compra");
		finalizarButton.setEnabled(false);
		finalizarButton.setBounds(266, 398, 171, 23);
		contentPane.add(finalizarButton);
		
		limparButton = new JButton("Limpar filtros");
		limparButton.setBounds(159, 212, 157, 23);
		contentPane.add(limparButton);

	}
	
	public JTable getCompraTable() {
		return compraTable;
	}

	public DefaultTableModel getCompraTableModel() {
		return compraTableModel;
	}

	public JTextField getMinField() {
		return minField;
	}

	public JTextField getMaxField() {
		return maxField;
	}

	public DefaultComboBoxModel<Status> getStatusBoxModel() {
		return statusBoxModel;
	}

	public DefaultComboBoxModel<Cliente> getClienteBoxModel() {
		return clienteBoxModel;
	}

	public JComboBox<Status> getStatusBox() {
		return statusBox;
	}
	public JComboBox<Cliente> getClienteBox() {
		return clienteBox;
	}
	public JTextField getTextField() {
		return minField;
	}
	public JTextField getTextField_1() {
		return maxField;
	}
	public JButton getConsultarButton() {
		return consultarButton;
	}
	public JButton getFinalizarButton() {
		return finalizarButton;
	}
	public JButton getLimparButton() {
		return limparButton;
	}
}
