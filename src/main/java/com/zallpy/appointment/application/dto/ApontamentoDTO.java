package com.zallpy.appointment.application.dto;

import java.io.Serializable;

import com.zallpy.appointment.application.domain.entity.Apontamento;

public class ApontamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer minutos;
	private Long idAlocacao;

	public ApontamentoDTO() {
	}

	public ApontamentoDTO(Apontamento apontamento) {
		this.id = apontamento.getId();
		this.minutos = apontamento.getMinutos();
		this.idAlocacao = apontamento.getAlocacao() == null ? null : apontamento.getAlocacao().getId();
	}

	public String getHoras() {
		if (minutos != null) {
			int h = minutos / 60;
			int m = minutos % 60;
			return String.format("%d:%02d", h, m);
		}
		return "00:00";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMinutos() {
		return minutos;
	}

	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}

	public Long getIdAlocacao() {
		return idAlocacao;
	}

	public void setIdAlocacao(Long idAlocacao) {
		this.idAlocacao = idAlocacao;
	}

}
