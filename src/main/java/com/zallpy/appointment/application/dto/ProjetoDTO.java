package com.zallpy.appointment.application.dto;

import java.io.Serializable;

import com.zallpy.appointment.application.domain.entity.Projeto;

public class ProjetoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;

	public ProjetoDTO(Projeto projeto) {
		super();
		this.id = projeto.getId();
		this.nome = projeto.getNome();
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
