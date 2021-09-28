package com.zallpy.appointment.application.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zallpy.appointment.application.domain.entity.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

	@Query(value = "select p.* from projeto p inner join alocacao a on a.projeto_id = p.id inner join colaborador c on a.colaborador_id = c.id where c.id = :idColaborador", countQuery = "select count(1) from projeto p inner join alocacao a on a.projeto_id = p.id inner join colaborador c on a.colaborador_id = c.id where c.id = :idColaborador", nativeQuery = true)
	Page<Projeto> findByIdColaborador(@Param("idColaborador") Long idColaborador, Pageable pageable);
}
