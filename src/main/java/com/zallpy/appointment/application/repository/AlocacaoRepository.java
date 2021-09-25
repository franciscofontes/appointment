package com.zallpy.appointment.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zallpy.appointment.application.domain.entity.Alocacao;

@Repository
public interface AlocacaoRepository extends JpaRepository<Alocacao, Long> {
}
