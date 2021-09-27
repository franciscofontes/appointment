package com.zallpy.appointment.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.application.domain.entity.Alocacao;
import com.zallpy.appointment.application.domain.entity.Colaborador;
import com.zallpy.appointment.application.domain.entity.Projeto;
import com.zallpy.appointment.application.dto.AlocacaoDTO;
import com.zallpy.appointment.application.repository.AlocacaoRepository;

@Service
public class AlocacaoService implements CrudService<Alocacao, Long> {

	@Autowired
	private AlocacaoRepository repository;

	public Page<AlocacaoDTO> buscarTodos(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		Page<Alocacao> paginacao = repository.findByPage(pageRequest);
		return paginacao.map(alocacao -> new AlocacaoDTO(alocacao));
	}

	public Page<AlocacaoDTO> buscarAlocacoesPorProjeto(Long idProjeto, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		Page<Alocacao> paginacao = repository.findByProjeto(new Projeto(idProjeto), pageRequest);
		return paginacao.map(alocacao -> new AlocacaoDTO(alocacao));
	}

	public Page<AlocacaoDTO> buscarAlocacoesPorColaborador(Long idColaborador, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		Page<Alocacao> paginacao = repository.findByColaborador(new Colaborador(idColaborador), pageRequest);
		return paginacao.map(alocacao -> new AlocacaoDTO(alocacao));
	}

	@Override
	public JpaRepository<Alocacao, Long> getRepository() {
		return repository;
	}

}
