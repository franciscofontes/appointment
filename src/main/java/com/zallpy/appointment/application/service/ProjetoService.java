package com.zallpy.appointment.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.application.domain.entity.Projeto;
import com.zallpy.appointment.application.dto.ProjetoDTO;
import com.zallpy.appointment.application.repository.ProjetoRepository;

@Service
public class ProjetoService implements CrudService<Projeto, Long> {

	@Autowired
	private ProjetoRepository repository;

	public Page<ProjetoDTO> buscarTodosPorPaginaDTO(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		Page<Projeto> paginacao = repository.findAll(pageRequest);
		return paginacao.map(projeto -> new ProjetoDTO(projeto));
	}

	@Override
	public JpaRepository<Projeto, Long> getRepository() {
		return repository;
	}

}
