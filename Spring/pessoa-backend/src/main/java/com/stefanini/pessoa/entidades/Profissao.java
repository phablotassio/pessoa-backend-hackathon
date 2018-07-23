package com.stefanini.pessoa.entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="profissao")
public class Profissao {

	private Long id;
	private	Pessoa idPessoa;
	private Cargo idCargo;
	private Linguagem idLinguage;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PROFISSAO")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	@OneToOne()
	@JoinColumn(name="ID_PESSOA")
	public Pessoa getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Pessoa idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	@OneToOne
	@JoinColumn(name="ID_CARGO")
	public Cargo getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(Cargo idCargo) {
		this.idCargo = idCargo;
	}
	
	@OneToOne
	@JoinColumn(name="ID_LINGUAGEM")
	public Linguagem getIdLinguage() {
		return idLinguage;
	}
	public void setIdLinguage(Linguagem idLinguage) {
		this.idLinguage = idLinguage;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Profissao other = (Profissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	
	
	
}