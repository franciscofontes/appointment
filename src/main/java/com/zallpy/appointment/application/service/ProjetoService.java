package com.zallpy.appointment.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.application.domain.entity.Projeto;
import com.zallpy.appointment.application.repository.ProjetoRepository;

@Service
public class ProjetoService implements CrudService<Projeto, Long> {

	@Autowired
	private ProjetoRepository repository;

	@Override
	public JpaRepository<Projeto, Long> getRepository() {
		return repository;
	}

}
