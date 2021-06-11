package iscim.escola.domain;

import javax.persistence.Entity;

@Entity
public class Turma extends GenericDomain {
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
