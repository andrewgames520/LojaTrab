package model;

public class Cliente {
	private String Cpf;
	private Integer Id;
	private String nome;
	
	
	public Cliente(String nome, String cpf) {
		super();
		this.Cpf = formatarCpf(cpf);
		this.nome = nome;
	}
	

	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		this.Cpf = cpf;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String formatarCpf(String cpf) {
	    String cpfLimpo = cpf != null ? cpf.replaceAll("[^0-9]", "") : "";

	    if (cpfLimpo.length() != 11) {
	        return cpf;
	    }
	    return cpfLimpo.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
	}
	
	
	public boolean verificarCpf() {
		String cpfLimpo = this.Cpf != null ? this.Cpf.replaceAll("[^0-9]", "") : "";
		int[] cpf = new int[11];
		int soma1 =0, soma2 =0;
		
		if(cpfLimpo.length() != 11) {
			return false;
		}
		if (cpfLimpo.matches("(\\d)\\1{10}")) {
	        return false;
	    }
		for (int i=0; i<11;i++) {
			cpf[i] = Character.getNumericValue(cpfLimpo.charAt(i));
		}
		
		for (int i = 0; i<10;i++) {
			if(i <9) {
				soma1 += (cpf[i]* (10-i));				
			}
				soma2 += (cpf[i]* (11-i));				
		}
		int resultado1 = (soma1 *10)%11;
		int resultado2 = (soma2 *10)%11;
		if(resultado2 ==10)
			resultado2 =0;
		if(resultado1 ==10)
			resultado1 = 0;
		return  resultado1 == cpf[9] && resultado2 == cpf[10];
		
	}
	
}
