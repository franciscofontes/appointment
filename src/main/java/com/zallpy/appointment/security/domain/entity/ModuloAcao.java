package com.zallpy.appointment.security.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ModuloAcao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "modulo_id", referencedColumnName = "id")
	@ManyToOne
	private Modulo modulo;

	@JoinColumn(name = "acao_id", referencedColumnName = "id")
	@ManyToOne
	private Acao acao;

	private String authority;

	public ModuloAcao() {
	}

	public ModuloAcao(Modulo modulo, Acao acao) {
		this.modulo = modulo;
		this.acao = acao;
		preencherAuthority();
	}

	public ModuloAcao(Acao acao) {
		this.acao = acao;
	}

	public ModuloAcao(Modulo modulo) {
		this.modulo = modulo;
	}

	private void preencherAuthority() {
		this.authority = getAcao().getNome().concat("_").concat(getModulo().getNome());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
		preencherAuthority();
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
		preencherAuthority();
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
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
		ModuloAcao other = (ModuloAcao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
