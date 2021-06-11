package iscim.escola.domain;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Estudante extends GenericDomain{
	
	private String nome;
	private String apelido;
	private String telefone;
	private String morada;
}
