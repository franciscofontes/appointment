package com.zallpy.appointment.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.application.domain.entity.Apontamento;
import com.zallpy.appointment.application.repository.ApontamentoRepository;

@Service
public class ApontamentoService implements CrudService<Apontamento, Long> {

	@Autowired
	private ApontamentoRepository repository;

	@Override
	public JpaRepository<Apontamento, Long> getRepository() {
		return repository;
	}

}
