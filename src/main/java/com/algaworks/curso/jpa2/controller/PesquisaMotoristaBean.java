package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.MotoristaDAO;
import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.modelo.Sexo;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MotoristaDAO motoristaDAO;
	private Motorista motoristaSelecionado;
	private List<Motorista> motoristas = new ArrayList<>();

	@PostConstruct
	public void inicializar() {
		motoristas = motoristaDAO.buscarTodos();
		
	}

	public void excluir() {
		try {
			motoristaDAO.excluir(motoristaSelecionado);
			this.motoristas.remove(motoristaSelecionado);
			FacesUtil.addSuccessMessage("Motorista " + motoristaSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public MotoristaDAO getMotoristaDAO() {
		return motoristaDAO;
	}

	public Motorista getMotoristaSelecionado() {
		return motoristaSelecionado;
	}

	public void setMotoristaSelecionado(Motorista motoristaSelecionado) {
		this.motoristaSelecionado = motoristaSelecionado;
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

}
