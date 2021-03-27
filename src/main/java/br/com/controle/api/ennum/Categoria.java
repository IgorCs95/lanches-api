package br.com.controle.api.ennum;

public enum Categoria {
	VENDA("Venda"), PRODUCAO("Produção");

	private final String valor;

	Categoria(String valorOpcao) {
		valor = valorOpcao;
	}

	public String getValor() {
		return valor;
	}

}
