package model;

public enum FaixaEtaria {
	BEBE("0 a 2 anos"),
    INFANTIL_NOVA("3 a 5 anos"),
    INFANTIL("6 a 8 anos"),
    JUVENIL("9 a 12 anos"),
    LIVRE("Todas as idades");
	
	private final String rotulo;
	
	private FaixaEtaria(String rotulo) {
		this.rotulo = rotulo;
	}

	public String getRotulo() {
		return rotulo;
	}
	
	
	
	
}
