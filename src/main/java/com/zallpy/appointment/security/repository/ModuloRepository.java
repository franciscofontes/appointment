package com.zallpy.appointment.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zallpy.appointment.security.domain.entity.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {

	Optional<Modulo> findByNomeIgnoreCase(String nome);
}
