package com.zallpy.appointment.security.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Modulo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 1, max = 100)
	@Column(unique = true)
	private String nome;

	@Size(min = 1, max = 100)
	private String label;

	private String descricao;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo")
	private List<ModuloAcao> moduloAcoes;

	public Modulo() {
	}

	public Modulo(Long id) {		
		this.id = id;
	}
	
	public Modulo(String nome, String label, String descricao) {
		this.nome = nome;
		this.label = label;
		this.descricao = descricao;
	}

	public void addModuloAcao(ModuloAcao moduloAcao) {
		moduloAcao.setModulo(this);
		getModuloAcoes().add(moduloAcao);
	}

	public void addModuloAcoes(List<ModuloAcao> moduloAcoes) {
		getModuloAcoes().addAll(moduloAcoes);
		for (ModuloAcao a : getModuloAcoes()) {
			a.setModulo(this);
		}
	}

	public ModuloAcao getAcao(String nome) {
		for (ModuloAcao a : getModuloAcoes()) {
			if (a.getAcao().getNome().equalsIgnoreCase(nome)) {
				return a;
			}
		}
		return null;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ModuloAcao> getModuloAcoes() {
		if (moduloAcoes == null) {
			moduloAcoes = new ArrayList<>();
		}
		return moduloAcoes;
	}

	public void setModuloAcoes(List<ModuloAcao> moduloAcoes) {
		for (ModuloAcao moduloAcao : moduloAcoes) {
			addModuloAcao(moduloAcao);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modulo other = (Modulo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
