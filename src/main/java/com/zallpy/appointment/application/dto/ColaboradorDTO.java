package com.zallpy.appointment.application.dto;

import java.io.Serializable;

import com.zallpy.appointment.application.domain.entity.Colaborador;

public class ColaboradorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;

	public ColaboradorDTO(Colaborador colaborador) {
		this.id = colaborador.getId();
		this.nome = colaborador.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
