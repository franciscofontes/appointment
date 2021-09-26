package com.zallpy.appointment.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zallpy.appointment.security.domain.entity.Acao;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, Long> {

	Optional<Acao> findByNomeIgnoreCase(String nome);
}
