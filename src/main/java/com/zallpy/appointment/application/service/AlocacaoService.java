package com.zallpy.appointment.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.application.domain.entity.Alocacao;
import com.zallpy.appointment.application.repository.AlocacaoRepository;

@Service
public class AlocacaoService implements CrudService<Alocacao, Long> {

	@Autowired
	private AlocacaoRepository repository;

	@Override
	public JpaRepository<Alocacao, Long> getRepository() {
		return repository;
	}

}
