package app;

import model.FaixaEtaria;
import model.Produto;
import repository.ProdutosRepository;
import view.MenuView;

public class Main {

	public static void main(String[] args) {
	
	MenuView menuView = new MenuView();
	
	menuView.setVisible(true);
	
	// Produto 1
    Produto p1 = new Produto();
    p1.setNome("Ursinho");
    p1.setQntDisponivel(30);
    p1.setFaixaEtaria(FaixaEtaria.BEBE);
    p1.setValor(39.90);
    p1.setDescricao("Grande e fofo");
    ProdutosRepository.getInstance().adicionar(p1);

    // Produto 2
    Produto p2 = new Produto();
    p2.setNome("Blocos de Montar Básicos");
    p2.setQntDisponivel(25);
    p2.setFaixaEtaria(FaixaEtaria.INFANTIL_NOVA);
    p2.setValor(85.50);
    p2.setDescricao("Peças grandes, seguras para crianças menores");
    ProdutosRepository.getInstance().adicionar(p2);

    // Produto 3
    Produto p3 = new Produto();
    p3.setNome("Mordedor de Borracha");
    p3.setQntDisponivel(50);
    p3.setFaixaEtaria(FaixaEtaria.BEBE);
    p3.setValor(15.99);
    p3.setDescricao("");
    ProdutosRepository.getInstance().adicionar(p3);

    // Produto 4
    Produto p4 = new Produto();
    p4.setNome("Jogo de Tabuleiro Clássico");
    p4.setQntDisponivel(20);
    p4.setFaixaEtaria(FaixaEtaria.LIVRE); 
    p4.setValor(89.90);
    p4.setDescricao("Para jogar com toda a família");
    ProdutosRepository.getInstance().adicionar(p4);

    // Produto 5
    Produto p5 = new Produto();
    p5.setNome("Bola de Futebol");
    p5.setQntDisponivel(42);
    p5.setFaixaEtaria(FaixaEtaria.INFANTIL);
    p5.setValor(45.00);
    p5.setDescricao(""); 
    ProdutosRepository.getInstance().adicionar(p5);

    // Produto 6
    Produto p6 = new Produto();
    p6.setNome("Quebra-Cabeça 1000 Peças");
    p6.setQntDisponivel(12);
    p6.setFaixaEtaria(FaixaEtaria.JUVENIL); 
    p6.setValor(59.99);
    p6.setDescricao("Tema paisagens naturais");
    ProdutosRepository.getInstance().adicionar(p6);

    // Produto 7
    Produto p7 = new Produto();
    p7.setNome("Boneca de Pano");
    p7.setQntDisponivel(35);
    p7.setFaixaEtaria(FaixaEtaria.INFANTIL_NOVA);
    p7.setValor(29.90);
    p7.setDescricao(""); 
    ProdutosRepository.getInstance().adicionar(p7);

    // Produto 8
    Produto p8 = new Produto();
    p8.setNome("Skate Iniciante");
    p8.setQntDisponivel(15);
    p8.setFaixaEtaria(FaixaEtaria.JUVENIL);
    p8.setValor(120.00);
    p8.setDescricao("Acompanha joelheiras");
    ProdutosRepository.getInstance().adicionar(p8);
    
    // Produto 9
    Produto p9 = new Produto();
    p9.setNome("Kit Médico de Brinquedo");
    p9.setQntDisponivel(18);
    p9.setFaixaEtaria(FaixaEtaria.INFANTIL);
    p9.setValor(75.00);
    p9.setDescricao("");
    ProdutosRepository.getInstance().adicionar(p9);
	
	}
}
