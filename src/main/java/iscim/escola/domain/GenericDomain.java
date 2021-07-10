package iscim.escola.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public class GenericDomain implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long identificacao;

	public Long getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(Long identificacao) {
		this.identificacao = identificacao;
	}
	
	@Override
	public String toString() {
		return String.format("%s[identificacao=%d]", getClass().getSimpleName(), getIdentificacao());
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificacao == null) ? 0 : identificacao.hashCode());
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
		GenericDomain other = (GenericDomain) obj;
		if (identificacao == null) {
			if (other.identificacao != null)
				return false;
		} else if (!identificacao.equals(other.identificacao))
			return false;
		return true;
	}
	
	
	
}
