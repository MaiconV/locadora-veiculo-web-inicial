package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.modelo.Sexo;
import com.algaworks.curso.jpa2.service.CadastroMotoristaService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Motorista motorista;
	private List<Sexo> sexos;

	@Inject
	private CadastroMotoristaService cadastroMotoristaService;

	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.sexos = Arrays.asList(Sexo.values());
	}

	public void limpar() {
		motorista = new Motorista();

	}

	public void salvar() {
		try {
			this.cadastroMotoristaService.salvar(motorista);
			FacesUtil.addSuccessMessage("Motorista salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		this.limpar();
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public CadastroMotoristaService getCadastroMotoristaService() {
		return cadastroMotoristaService;
	}

	public List<Sexo> getSexos() {
		return sexos;
	}
}
