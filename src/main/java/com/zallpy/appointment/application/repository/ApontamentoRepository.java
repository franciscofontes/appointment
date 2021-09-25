package com.zallpy.appointment.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zallpy.appointment.application.domain.entity.Apontamento;

@Repository
public interface ApontamentoRepository extends JpaRepository<Apontamento, Long> {
}
