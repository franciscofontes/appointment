package com.zallpy.appointment.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zallpy.appointment.security.domain.entity.Perfil;
import com.zallpy.appointment.security.domain.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findByPerfil(Perfil perfil);
	
	Optional<Usuario> findByEmail(String email);
}
