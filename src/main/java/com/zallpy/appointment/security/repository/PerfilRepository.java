package com.zallpy.appointment.security.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zallpy.appointment.security.domain.entity.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

	List<Perfil> findByModuloAcoes_Id(Long moduloAcaoId);

	Perfil findByNome(String nome);

	Page<Perfil> findDistinctByNomeContainingIgnoreCase(String nome, Pageable pageRequest);
}
