package com.zallpy.appointment.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zallpy.appointment.application.domain.entity.Alocacao;
import com.zallpy.appointment.application.domain.entity.Colaborador;
import com.zallpy.appointment.application.domain.entity.Projeto;

@Repository
public interface AlocacaoRepository extends JpaRepository<Alocacao, Long> {

	List<Alocacao> findByColaborador(Colaborador colaborador);

	List<Alocacao> findByProjeto(Projeto projeto);

}
