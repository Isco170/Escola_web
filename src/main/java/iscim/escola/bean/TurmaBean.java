package iscim.escola.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import iscim.escola.dao.TurmaDAO;
import iscim.escola.domain.Turma;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TurmaBean implements Serializable {
	private Turma turma;
	private List<Turma> turmas;
	
	public Turma getTurma() {
		return turma;
	}
	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}
	
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	@PostConstruct
	public void listar() {
		try {
			TurmaDAO turDAO = new TurmaDAO();
			turmas = turDAO.listar();
		} catch (Exception e) {
			Messages.addGlobalError("Ocorreu um erro ao listar turmas");
		}
		
	}
	
	public void novo() {
		turma = new Turma();
	}
	
	public void salvar() {
		try {
			TurmaDAO turDAO = new TurmaDAO();
			turDAO.merge(turma);
			novo();
			turmas = turDAO.listar();
			
			Messages.addGlobalInfo("Turma salva com sucesso");
		} catch (Exception e) {
			Messages.addGlobalError("Falha salvando nova turma");
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			turma = (Turma) evento.getComponent().getAttributes().get("turmaSelecionada");
			TurmaDAO turDAO = new TurmaDAO();
			turDAO.excluir(turma);
			turmas = turDAO.listar();
			Messages.addFlashGlobalInfo("Turma excluida com sucesso");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Falha ao excluir turma");
		}
	}

	public void editar(ActionEvent evento) {
		turma = (Turma) evento.getComponent().getAttributes().get("turmaSelecionada");
	}
}
