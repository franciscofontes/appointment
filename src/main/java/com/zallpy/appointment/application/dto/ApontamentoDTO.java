package com.zallpy.appointment.application.dto;

import java.io.Serializable;
import java.util.Date;

import com.zallpy.appointment.application.domain.entity.Apontamento;

public class ApontamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date data;
	private Long idAlocacao;
	
	public ApontamentoDTO() {		
	}

	public ApontamentoDTO(Apontamento apontamento) {
		this.id = apontamento.getId();
		this.data = apontamento.getData();
		this.idAlocacao = apontamento.getAlocacao() == null ? null : apontamento.getAlocacao().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getIdAlocacao() {
		return idAlocacao;
	}

	public void setIdAlocacao(Long idAlocacao) {
		this.idAlocacao = idAlocacao;
	}

}
