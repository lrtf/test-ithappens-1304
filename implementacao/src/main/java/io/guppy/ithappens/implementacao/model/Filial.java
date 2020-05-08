package io.guppy.ithappens.implementacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author luis ricardo
 *
 */

@Entity
public class Filial {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoFilial;
	private String nome;
	private String cnpj;
	
	public Long getCodigoFilial() {
		return codigoFilial;
	}
	public void setCodigoFilial(Long codigoFilial) {
		this.codigoFilial = codigoFilial;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigoFilial ^ (codigoFilial >>> 32));
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
		Filial other = (Filial) obj;
		if (codigoFilial != other.codigoFilial)
			return false;
		return true;
	}
	
	

}
