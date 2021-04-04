package br.com.controle.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.sym.Name;
import com.sun.istack.NotNull;

@Entity
@Table(name = "cliente", schema = "public")
public class Cliente {

	@Id
	@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cliente_seq")
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private int limite;

	private Long telefone;
	
	@JsonManagedReference(value = "cliente")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private List<Pedido> pedidos;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getLimite() {
		return limite;
	}

	public Long getTelefone() {
		return telefone;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + limite;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (limite != other.limite)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pedidos == null) {
			if (other.pedidos != null)
				return false;
		} else if (!pedidos.equals(other.pedidos))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", limite=" + limite + ", telefone=" + telefone + ", pedidos="
				+ pedidos + "]";
	}

}
