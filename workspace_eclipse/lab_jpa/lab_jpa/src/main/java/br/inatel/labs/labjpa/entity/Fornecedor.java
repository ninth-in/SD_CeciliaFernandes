package br.inatel.labs.labjpa.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Fornecedor {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 200)
	private String rezaoSocial;
	
	@ManyToMany
	private List<Produto> listaProduto;

	public Fornecedor() {
	}
	public Fornecedor(@NotNull @Size(min = 2, max = 200) String rezaoSocial) {
		super();
		this.rezaoSocial = rezaoSocial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRezaoSocial() {
		return rezaoSocial;
	}

	public void setRezaoSocial(String rezaoSocial) {
		this.rezaoSocial = rezaoSocial;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", rezaoSocial=" + rezaoSocial + "]";
	}
	
	
}
