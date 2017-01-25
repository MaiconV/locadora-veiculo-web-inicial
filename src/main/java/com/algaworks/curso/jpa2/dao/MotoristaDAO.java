package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class MotoristaDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;

	public void salvar(Motorista motorista) {
		em.merge(motorista);

	}

	@SuppressWarnings("unchecked")
	public List<Motorista> buscarTodos() {
		// TODO Auto-generated method stub
		return em.createQuery("from Motorista").getResultList();
	}

	@Transactional
	public void excluir(Motorista motoristaSelecionado) throws NegocioException {
		motoristaSelecionado = em.find(Motorista.class, motoristaSelecionado.getCodigo());
		em.remove(motoristaSelecionado);
		em.flush();
	}

	public Motorista buscarPeloCodigo(Long codigo) {
		return em.find(Motorista.class, codigo);
	}
}
