package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CancelarCompraController;
import controller.ClienteController;
import controller.CompraController;
import controller.ConsultaCompraController;
import controller.ConsultaFuncionarioController;
import controller.ConsultaProdutoController;
import controller.FuncionarioController;
import controller.ProdutoController;
import repository.ClientesRepository;
import repository.ComprasRepository;
import repository.FuncionariosRepository;
import repository.ProdutosRepository;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    ProdutoView produtoView;
    ClienteView clienteView;
    FuncionarioView funcionarioView;
    ConsultaProdutoView consultaProdutoView;
    ConsultaFuncionarioView consultafuncionarioView;
    ConsultaCompraView consultaCompraView;
    CompraView compraView;
    CancelarCompraView cancelarView;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuView frame = new MenuView();
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
    public MenuView() {
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 758, 570);
        
        // ---------------- BARRA DE MENUS ----------------
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar); // Define a barra no topo do JFrame

        // --- 1. ABA CADASTRO ---
        JMenu mnCadastro = new JMenu("Cadastro");
        menuBar.add(mnCadastro);

        JMenuItem mntmCadProdutos = new JMenuItem("Produtos");
        mnCadastro.add(mntmCadProdutos);

        JMenuItem mntmCadCliente = new JMenuItem("Cliente");
        mnCadastro.add(mntmCadCliente);

        JMenuItem mntmCadFuncionarios = new JMenuItem("Funcionários");
        mnCadastro.add(mntmCadFuncionarios);


        // --- 2. ABA CONSULTAS ---
        JMenu mnConsultas = new JMenu("Consultas");
        menuBar.add(mnConsultas);

        JMenuItem mntmConsProdutos = new JMenuItem("Produtos");
        mnConsultas.add(mntmConsProdutos);
        JMenuItem mntmConsFuncionarios = new JMenuItem("Funcionários");
        mnConsultas.add(mntmConsFuncionarios);
        JMenuItem mntmConsCompras = new JMenuItem("Histórico Compras");
        mnConsultas.add(mntmConsCompras);


        // --- 3. ABA MOVIMENTOS ---
        JMenu mnMovimentos = new JMenu("Movimentos");
        menuBar.add(mnMovimentos);

        JMenuItem mntmCompra = new JMenuItem("Comprar");
        mnMovimentos.add(mntmCompra);

        JMenuItem mntmCancelar = new JMenuItem("Cancelar Compra");
        mnMovimentos.add(mntmCancelar);
		
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
       
        mntmCadProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(produtoView == null || ! produtoView.isDisplayable()) {
            		produtoView = new ProdutoView();
            		ProdutosRepository produtoRepository = ProdutosRepository.getInstance();
            		ProdutoController produtoController = new ProdutoController(produtoView, produtoRepository);
            		produtoView.setVisible(true);		
            	}else {
            		produtoView.setExtendedState(JFrame.NORMAL);
            		produtoView.toFront();
            	}
                
            }
        });
        
        mntmCadCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clienteView == null || ! clienteView.isDisplayable()) {
					clienteView = new ClienteView();
					ClientesRepository clientesRepository = ClientesRepository.getInstance();
					ClienteController clienteController = new ClienteController(clienteView,clientesRepository);
					clienteView.setVisible(true);					
				}else {
					clienteView.setExtendedState(JFrame.NORMAL);
					clienteView.toFront();
				}
				
			}
		});
        mntmCadFuncionarios.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				if(funcionarioView == null || ! funcionarioView.isDisplayable()) {
					
				funcionarioView = new FuncionarioView();
				FuncionariosRepository funcionariosRepository = FuncionariosRepository.getInstance();
				FuncionarioController funcionarioController = new FuncionarioController(funcionarioView,funcionariosRepository);
				funcionarioView.setVisible(true);
				}else {
					funcionarioView.setExtendedState(JFrame.NORMAL);
					funcionarioView.toFront();
				}
				
			}
		});
        
        mntmConsCompras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(consultaCompraView == null || ! consultaCompraView.isDisplayable()) {
					consultaCompraView = new ConsultaCompraView();
					ConsultaCompraController consultaCompraController = new ConsultaCompraController(consultaCompraView);
					consultaCompraView.setVisible(true);
				}else{
					consultaCompraView.setExtendedState(JFrame.NORMAL);
					consultaProdutoView.toFront();
				}
			}
		});
        
        mntmConsProdutos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(consultaProdutoView == null || !consultaProdutoView.isDisplayable()) {
					consultaProdutoView = new ConsultaProdutoView();
					ConsultaProdutoController consultaProdutoController = new ConsultaProdutoController(consultaProdutoView);
					consultaProdutoView.setVisible(true);
				}else {
					consultaProdutoView.setExtendedState(JFrame.NORMAL);
					consultaProdutoView.toFront();
				}
				
			}
		});
        
        mntmConsFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(consultafuncionarioView == null || ! consultafuncionarioView.isDisplayable()) {
					consultafuncionarioView = new ConsultaFuncionarioView();
					ConsultaFuncionarioController consultaFuncionarioController = new ConsultaFuncionarioController(consultafuncionarioView);
					consultafuncionarioView.setVisible(true);
				}else {
					consultafuncionarioView.setExtendedState(JFrame.NORMAL);
					consultaProdutoView.toFront();
				}
				
			}
		});
        
       mntmCompra.addActionListener(new ActionListener(){
    
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   	if(compraView == null || ! compraView.isDisplayable()) {
    			   compraView = new CompraView();
    			   ComprasRepository compraRepository = ComprasRepository.getInstance();
    			   CompraController compraController = new CompraController(compraView, compraRepository);
    			   compraView.setVisible(true);
    		   	}else {
    		   		compraView.setExtendedState(JFrame.NORMAL);
    		   		compraView.toFront();
    		   	}
    		  }
    	   });
       
       mntmCancelar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
				if(cancelarView == null || ! cancelarView.isDisplayable()) {
					cancelarView = new CancelarCompraView();
					CancelarCompraController cancelarCompraController = new CancelarCompraController(cancelarView);
					cancelarView.setVisible(true);
				}else {
					cancelarView.setExtendedState(JFrame.NORMAL);
					cancelarView.toFront();
				}
			}
			
       });
	
    }
}