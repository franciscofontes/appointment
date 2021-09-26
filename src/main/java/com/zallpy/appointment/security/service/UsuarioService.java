package com.zallpy.appointment.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.application.service.CrudService;
import com.zallpy.appointment.exception.ObjectNotFoundException;
import com.zallpy.appointment.security.domain.entity.Perfil;
import com.zallpy.appointment.security.domain.entity.Usuario;
import com.zallpy.appointment.security.repository.UsuarioRepository;

@Service
public class UsuarioService implements CrudService<Usuario, Long> {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario buscarPorEmail(String email) throws ObjectNotFoundException {
		Optional<Usuario> obj = repository.findByEmail(email);
		obj.orElseThrow(() -> new ObjectNotFoundException("Usuario nao encontrado. Email: " + email + ". Tipo: " + Usuario.class.getName()));
		return obj.get();
	}	

	public List<Usuario> buscarPorPerfil(Perfil perfil) {
		return repository.findByPerfil(perfil);
	}
	
	@Override
	public JpaRepository<Usuario, Long> getRepository() {
		return repository;
	}	
	
}
