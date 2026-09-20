package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ClienteView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField IdField;
	private JTextField cpfField;
	private JTextField faixaEtariaField;
	private JTextField valorField;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeLabel = new JLabel("Nome do cliente:");
		nomeLabel.setBounds(10, 71, 95, 14);
		contentPane.add(nomeLabel);
		
		nomeField = new JTextField();
		nomeField.setBounds(105, 68, 86, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel cpfLabel = new JLabel("CPF:");
		cpfLabel.setBounds(10, 112, 120, 14);
		contentPane.add(cpfLabel);
		
		JLabel IdLabel = new JLabel("ID:");
		IdLabel.setBounds(10, 27, 23, 14);
		contentPane.add(IdLabel);
		
		IdField = new JTextField();
		IdField.setEditable(false);
		IdField.setBounds(33, 27, 86, 14);
		contentPane.add(IdField);
		IdField.setColumns(10);
		
		cpfField = new JTextField();
		cpfField.setBounds(126, 109, 86, 20);
		contentPane.add(cpfField);
		cpfField.setColumns(10);
		
		JLabel faixaEtariaLabel = new JLabel("Faixa Etaria:");
		faixaEtariaLabel.setBounds(10, 157, 109, 14);
		contentPane.add(faixaEtariaLabel);
		
		faixaEtariaField = new JTextField();
		faixaEtariaField.setBounds(77, 154, 86, 20);
		contentPane.add(faixaEtariaField);
		faixaEtariaField.setColumns(10);
		
		JLabel valorLabel = new JLabel("Preço:");
		valorLabel.setBounds(10, 198, 46, 14);
		contentPane.add(valorLabel);
		
		valorField = new JTextField();
		valorField.setBounds(45, 195, 86, 20);
		contentPane.add(valorField);
		valorField.setColumns(10);

	}
}
