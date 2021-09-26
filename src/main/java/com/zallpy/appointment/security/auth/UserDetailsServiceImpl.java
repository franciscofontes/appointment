package com.zallpy.appointment.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.security.domain.entity.Usuario;
import com.zallpy.appointment.security.service.UsuarioService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService service;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = service.buscarPorEmail(email);		
		return new UserDetailsImpl(usuario.getId(), usuario.getEmail(), usuario.getSenha(), usuario.getPerfil());
	}
	
	public static UserDetails authenticated() {
		try {
			return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
