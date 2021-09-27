package com.zallpy.appointment.application.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.zallpy.appointment.application.domain.entity.Alocacao;
import com.zallpy.appointment.application.domain.entity.Projeto;
import com.zallpy.appointment.application.helper.DateHelper;

public class AlocacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private ColaboradorDTO colaborador;
	private Projeto projeto;
	private Set<ApontamentoDTO> apontamentos;

	public AlocacaoDTO(Alocacao alocacao) {
		this.id = alocacao.getId();
		this.colaborador = new ColaboradorDTO(alocacao.getColaborador());
		this.projeto = alocacao.getProjeto();
		this.apontamentos = alocacao.getApontamentos().stream().map(apontamento -> new ApontamentoDTO(apontamento)).collect(Collectors.toSet());
	}
	
	public String getTotalHoras() {
		int totalMinutos = 0;
		for(ApontamentoDTO apontamento : apontamentos) {
			totalMinutos += apontamento.getMinutos();
		}
		DateHelper dateHelper = new DateHelper();
		return dateHelper.getHoras(totalMinutos);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ColaboradorDTO getColaborador() {
		return colaborador;
	}

	public void setColaborador(ColaboradorDTO colaborador) {
		this.colaborador = colaborador;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Set<ApontamentoDTO> getApontamentos() {
		if (apontamentos == null) {
			apontamentos = new HashSet<>();
		}
		return apontamentos;
	}

	public void setApontamentos(Set<ApontamentoDTO> apontamentos) {
		this.apontamentos = apontamentos;
	}

}
