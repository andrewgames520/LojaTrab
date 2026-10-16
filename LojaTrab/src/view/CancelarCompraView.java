package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import repository.ClientesRepository;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class CancelarCompraView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable compraTable;
	private DefaultTableModel compraTableModel; 
	private JTextField minField;
	private JTextField maxField;
	private JComboBox clienteBox;
	private DefaultComboBoxModel clienteBoxModel;
	private JButton consultarButton;
	private JButton limparButton;
	private JButton cancelarButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelarCompraView frame = new CancelarCompraView();
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
	public CancelarCompraView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 743, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 313, 707, 194);
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
		clienteLabel.setBounds(10, 76, 46, 14);
		contentPane.add(clienteLabel);
		
		JLabel minLabel = new JLabel("Valor minimo");
		minLabel.setBounds(10, 143, 97, 14);
		contentPane.add(minLabel);
		
		JLabel maxLabel = new JLabel("Valor Maximo");
		maxLabel.setBounds(10, 186, 97, 14);
		contentPane.add(maxLabel);
		
		minField = new JTextField();
		minField.setBounds(117, 140, 86, 20);
		contentPane.add(minField);
		minField.setColumns(10);
		
		maxField = new JTextField();
		maxField.setBounds(117, 183, 86, 20);
		contentPane.add(maxField);
		maxField.setColumns(10);
		
		clienteBoxModel = new DefaultComboBoxModel<>();
		clienteBoxModel.addElement("TODOS CLIENTES");
		clienteBoxModel.addAll(ClientesRepository.getInstance().listarTodos());
		
		clienteBox = new JComboBox(clienteBoxModel);
		clienteBox.setBounds(66, 72, 86, 22);
		contentPane.add(clienteBox);
		
		consultarButton = new JButton("Buscar");
		consultarButton.setBounds(10, 269, 89, 23);
		contentPane.add(consultarButton);
		
		limparButton = new JButton("Limpar filtros");
		limparButton.setBounds(137, 269, 159, 23);
		contentPane.add(limparButton);
		
		cancelarButton = new JButton("Cancelar compra");
		cancelarButton.setBounds(282, 518, 134, 23);
		contentPane.add(cancelarButton);

	}

	public JComboBox getClienteBox() {
		return clienteBox;
	}
	public JTextField getMinField() {
		return minField;
	}
	public JTextField getMaxField() {
		return maxField;
	}
	public JButton getConsultarButton() {
		return consultarButton;
	}
	public JButton getLimparButton() {
		return limparButton;
	}
	public JButton getCancelarButton() {
		return cancelarButton;
	}

	public JTable getCompraTable() {
		return compraTable;
	}

	public DefaultTableModel getCompraTableModel() {
		return compraTableModel;
	}

	public DefaultComboBoxModel getClienteBoxModel() {
		return clienteBoxModel;
	}
	
	
}
