package com.zallpy.appointment.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zallpy.appointment.security.domain.entity.Acao;
import com.zallpy.appointment.security.domain.entity.Modulo;
import com.zallpy.appointment.security.domain.entity.ModuloAcao;

@Repository
public interface ModuloAcaoRepository extends JpaRepository<ModuloAcao, Long> {

	Optional<ModuloAcao> findByModuloAndAcao(Modulo modulo, Acao acao);
	
	Optional<List<ModuloAcao>> findByModulo(Modulo modulo);
}
