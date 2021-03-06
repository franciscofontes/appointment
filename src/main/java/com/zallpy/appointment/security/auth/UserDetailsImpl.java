package com.zallpy.appointment.security.auth;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.zallpy.appointment.security.domain.entity.Perfil;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl() {
	}

	public UserDetailsImpl(Long id, String email, String senha, Perfil perfil) {
		super();
		this.id = id;		
		this.email = email;
		this.senha = senha;
		this.authorities = perfil.getModuloAcoes().stream().map(ma -> new SimpleGrantedAuthority(ma.getAuthority())).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public boolean hasAuthority(String authority) {
		return getAuthorities().contains(new SimpleGrantedAuthority(authority));
	}

}
