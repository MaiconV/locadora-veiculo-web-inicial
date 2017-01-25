package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Funcionario;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class FuncionarioDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	EntityManager em;

	public void salvar(Funcionario funcionario) {
		//em.persist(funcionario);
		em.merge(funcionario);//conseque pegar uma objeto novo (desatachado) e atachar ela
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarTodos() {
		return em.createQuery("from Funcionario").getResultList();
	}

	@Transactional
	public void excluir(Funcionario funcionarioSelecionado) throws NegocioException {
		funcionarioSelecionado = em.find(Funcionario.class, funcionarioSelecionado.getCodigo());
		em.remove(funcionarioSelecionado);
		em.flush();
	}

	public Funcionario buscarPeloCodigo(Long codigo) {
		
		return em.find(Funcionario.class, codigo);
	}

}
