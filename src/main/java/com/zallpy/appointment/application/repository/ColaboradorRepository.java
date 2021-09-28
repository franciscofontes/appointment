package com.zallpy.appointment.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zallpy.appointment.application.domain.entity.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
	
	Optional<Colaborador> findByNome(String nome);
	
	Optional<Colaborador> findByIdUsuario(Long idUsuario);
}
