package com.zallpy.appointment.application.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zallpy.appointment.application.domain.entity.Alocacao;
import com.zallpy.appointment.application.domain.entity.Colaborador;
import com.zallpy.appointment.application.domain.entity.Projeto;

@Repository
public interface AlocacaoRepository extends JpaRepository<Alocacao, Long> {

	@Query(value = "select a from Alocacao a left join fetch a.apontamentos", countQuery = "select count(1) from Alocacao a")
	Page<Alocacao> findByPage(Pageable pageable);
	
	@Query(value = "select a from Alocacao a left join fetch a.apontamentos where a.colaborador = :colaborador")
	List<Alocacao> findByColaborador(Colaborador colaborador);

	@Query(value = "select a from Alocacao a left join fetch a.apontamentos where a.projeto = :projeto")
	List<Alocacao> findByProjeto(Projeto projeto);

}
