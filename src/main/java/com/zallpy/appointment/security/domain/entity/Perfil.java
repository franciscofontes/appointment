package com.zallpy.appointment.security.domain.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

@Entity
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 1, max = 100)
	@Column(unique = true)
	private String nome;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "perfil_modulo_acao", joinColumns = {
			@JoinColumn(name = "perfil_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "modulo_acao_id", referencedColumnName = "id") })	
	private Set<ModuloAcao> moduloAcoes;

	public Perfil() {
	}

	public Perfil(String nome) {
		this.nome = nome;
	}
	
	public void addModuloAcao(ModuloAcao moduloAcao) {
		if (getModuloAcoes() == null) {
			moduloAcoes = new HashSet<>();
		}
		moduloAcoes.add(moduloAcao);
	}	
	
	public void addModulosAcao(List<ModuloAcao> list) {
		if (getModuloAcoes() == null) {
			moduloAcoes = new HashSet<>();
		}
		moduloAcoes.addAll(list);
	}

	public int getTotalAcoesDoModulo(Modulo modulo) {
		int cont = 0;
		for (ModuloAcao ma : getModuloAcoes()) {
			if (Objects.equals(ma.getModulo().getId(), modulo.getId())) {
				cont++;
			}
		}
		return cont;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		if (nome != null) {
			return nome.toUpperCase();
		}
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public Set<ModuloAcao> getModuloAcoes() {		
		return moduloAcoes;
	}
	
	public void setModuloAcoes(Set<ModuloAcao> moduloAcoes) {		
		this.moduloAcoes = moduloAcoes;				
	}		

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Perfil)) {
			return false;
		}
		Perfil other = (Perfil) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

}
