package com.zallpy.appointment.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.application.domain.entity.Alocacao;
import com.zallpy.appointment.application.domain.entity.Colaborador;
import com.zallpy.appointment.application.domain.entity.Projeto;
import com.zallpy.appointment.application.repository.AlocacaoRepository;

@Service
public class AlocacaoService implements CrudService<Alocacao, Long> {

	@Autowired
	private AlocacaoRepository repository;

	public List<Alocacao> buscarPeloColaborador(Colaborador colaborador) {
		return repository.findByColaborador(colaborador);
	}

	public List<Alocacao> buscarPeloProjeto(Projeto projeto) {
		return repository.findByProjeto(projeto);
	}

	@Override
	public JpaRepository<Alocacao, Long> getRepository() {
		return repository;
	}

}
