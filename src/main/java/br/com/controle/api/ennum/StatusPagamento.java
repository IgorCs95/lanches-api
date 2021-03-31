package br.com.controle.api.ennum;

public enum StatusPagamento {
	
	ABERTO("Aberto"), BAIXADO("Baixado"), CANCELADO("Cancelado");

	private String descricao;

	StatusPagamento(String descricao) {
	        this.descricao = descricao;
	    }

	public String getDescricao() {
		return descricao;
	}

}
