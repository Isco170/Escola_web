package iscim.escola.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Turma extends GenericDomain {
	@Column(length = 50, unique = true, nullable = false)
	private String descricao;
	
	private boolean apagado;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isApagado() {
		return apagado;
	}

	public void setApagado(boolean apagado) {
		this.apagado = apagado;
	}

}
