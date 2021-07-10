package iscim.escola.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import iscim.escola.dao.AlunoDAO;
import iscim.escola.dao.TurmaDAO;
import iscim.escola.domain.Estudante;
import iscim.escola.domain.Turma;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstudanteBean implements Serializable{
	private Estudante estudante;
	private List<Estudante> estudantes;
	private List<Turma> turmas;
	
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
	public Estudante getEstudante() {
		return estudante;
	}
	
	public List<Estudante> getEstudantes() {
		return estudantes;
	}
	
	public void setEstudantes(List<Estudante> estudantes) {
		this.estudantes = estudantes;
	}
	
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}
	
	@PostConstruct
	public void listar() {
		try {
			AlunoDAO estuDAO = new AlunoDAO();
			estudantes = estuDAO.listar();
		} catch (Exception e) {
			Messages.addFlashGlobalError("Erro ao listar estudantes");
		}
	}
	
	public void novo() {
		try {
			estudante = new Estudante();
			TurmaDAO turDAO = new TurmaDAO();
			turmas = turDAO.listar();
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar um novo aluno");
		}
	}
	
	public void salvar() {
		try {
			AlunoDAO estuDAO = new AlunoDAO();
			estuDAO.merge(estudante);
			
			estudante = new Estudante();
			TurmaDAO turDAO = new TurmaDAO();
			turmas = turDAO.listar();
			estudantes = estuDAO.listar();
			
			
			Messages.addGlobalInfo("Estudante salvo com sucesso");
		} catch (Exception e) {
			Messages.addGlobalError("Falha salvando novo estudante");
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			estudante = (Estudante) evento.getComponent().getAttributes().get("estudanteSelecionado");
			
			AlunoDAO aluDAO = new AlunoDAO();
			aluDAO.excluir(estudante);
			
			estudantes = aluDAO.listar();
			
			Messages.addFlashGlobalInfo("Estudante excluido");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Falha ao excluir estudante");
		}
	}

	public void editar(ActionEvent evento) {
		try {
			estudante = (Estudante) evento.getComponent().getAttributes().get("estudanteSelecionado");
			
			TurmaDAO turDAO = new TurmaDAO();
			turmas = turDAO.listar();
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar aluno");
		}

		
	}

	

}
