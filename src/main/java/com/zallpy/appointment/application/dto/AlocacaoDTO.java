package com.zallpy.appointment.application.dto;

import java.io.Serializable;
import java.util.Set;

import com.zallpy.appointment.application.domain.entity.Alocacao;
import com.zallpy.appointment.application.domain.entity.Apontamento;
import com.zallpy.appointment.application.domain.entity.Colaborador;
import com.zallpy.appointment.application.domain.entity.Projeto;

public class AlocacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Colaborador colaborador;
	private Projeto projeto;
	private Set<Apontamento> apontamentos;

	public AlocacaoDTO(Alocacao alocacao) {
		this.id = alocacao.getId();
		this.colaborador = alocacao.getColaborador();
		this.projeto = alocacao.getProjeto();
		this.apontamentos = alocacao.getApontamentos();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Set<Apontamento> getApontamentos() {
		return apontamentos;
	}

	public void setApontamentos(Set<Apontamento> apontamentos) {
		this.apontamentos = apontamentos;
	}

}
