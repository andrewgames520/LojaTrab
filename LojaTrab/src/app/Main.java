package app;

import controller.ProdutoController;
import repository.ProdutosRepository;
import view.ProdutoView;

public class Main {

	public static void main(String[] args) {
	ProdutoView produtoView = new ProdutoView();
	ProdutosRepository produtoRepository = ProdutosRepository.getInstance();
	ProdutoController produtoController = new ProdutoController(produtoView, produtoRepository);
	produtoView.setVisible(true);
	System.out.println("teste");

	}

}
