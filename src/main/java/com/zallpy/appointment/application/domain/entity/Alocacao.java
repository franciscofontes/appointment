package com.zallpy.appointment.application.domain.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Alocacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "colaborador_id", referencedColumnName = "id")
	@ManyToOne
	private Colaborador colaborador;

	@JoinColumn(name = "projeto_id", referencedColumnName = "id")
	@ManyToOne
	private Projeto projeto;

	@OneToMany(mappedBy = "alocacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Apontamento> apontamentos;

	public Alocacao() {
	}

	public Alocacao(Colaborador colaborador, Projeto projeto) {
		super();
		this.colaborador = colaborador;
		this.projeto = projeto;
	}
	
	public Alocacao(Colaborador colaborador) {
		super();
		this.colaborador = colaborador;
	}

	public void addApontamento(Apontamento apontamento) {
		if (apontamento != null) {
			apontamento.setAlocacao(this);
			if (!getApontamentos().contains(apontamento)) {
				getApontamentos().add(apontamento);
			}
		}
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
		if (apontamentos == null) {
			apontamentos = new HashSet<>();
		}
		return apontamentos;
	}

	public void setApontamentos(Set<Apontamento> apontamentos) {
		this.apontamentos = apontamentos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colaborador, projeto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alocacao other = (Alocacao) obj;
		return Objects.equals(colaborador, other.colaborador) && Objects.equals(projeto, other.projeto);
	}

	@Override
	public String toString() {
		return "Alocacao [id=" + id + ", colaborador=" + colaborador + ", projeto=" + projeto + ", apontamentos="
				+ apontamentos + "]";
	}

}
