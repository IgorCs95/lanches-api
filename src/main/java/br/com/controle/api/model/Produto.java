package br.com.controle.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import br.com.controle.api.ennum.Categoria;

@Entity
@Table(name = "produto", schema = "public")
public class Produto {

	@Id
	@SequenceGenerator(name = "produto_seq", sequenceName = "produto_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "produto_seq")
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private float valor;

	private Long estoque;

	private boolean status;

	@NotNull
	private Categoria categoria;
	
//	@JsonManagedReference(value = "produto")
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_id")
	private List<ItemPedido> itensPedido;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public float getValor() {
		return valor;
	}

	public Long getEstoque() {
		return estoque;
	}

	public boolean isStatus() {
		return status;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setEstoque(Long estoque) {
		this.estoque = estoque;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itensPedido == null) ? 0 : itensPedido.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(valor);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (categoria != other.categoria)
			return false;
		if (estoque == null) {
			if (other.estoque != null)
				return false;
		} else if (!estoque.equals(other.estoque))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itensPedido == null) {
			if (other.itensPedido != null)
				return false;
		} else if (!itensPedido.equals(other.itensPedido))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (status != other.status)
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valor=" + valor + ", estoque=" + estoque + ", status="
				+ status + ", categoria=" + categoria + ", itensPedido=" + itensPedido + "]";
	}

}
