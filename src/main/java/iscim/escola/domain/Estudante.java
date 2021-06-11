package iscim.escola.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Estudante extends GenericDomain {
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 50, nullable = false)
	private String apelido;

	@Column(length = 20, nullable = false)
	private String telefone;
	
	@Column(length = 100, nullable = false)
	private String morada;
}
