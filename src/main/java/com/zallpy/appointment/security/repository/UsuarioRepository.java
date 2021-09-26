package com.zallpy.appointment.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zallpy.appointment.security.domain.entity.Perfil;
import com.zallpy.appointment.security.domain.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findByPerfil(Perfil perfil);
	
	Optional<Usuario> findByNomeIgnoreCase(String nome);	
	
	Page<Usuario> findDistinctByNomeContainingIgnoreCase(String nome, Pageable pageRequest);
	
	Optional<Usuario> findByEmail(String email);
}
