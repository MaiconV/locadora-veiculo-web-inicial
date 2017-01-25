package com.algaworks.curso.jpa2.modelo;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FUNCIONARIO")
public class Funcionario extends Pessoa {

	private String matricula;
	private Date dataAdmicao;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getDataAdmicao() {
		return dataAdmicao;
	}

	public void setDataAdmicao(Date dataAdmicao) {
		this.dataAdmicao = dataAdmicao;
	}

}
