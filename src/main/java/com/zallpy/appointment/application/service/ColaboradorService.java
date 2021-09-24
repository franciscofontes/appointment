package com.zallpy.appointment.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.application.domain.entity.Colaborador;
import com.zallpy.appointment.application.repository.ColaboradorRepository;

@Service
public class ColaboradorService implements CrudService<Colaborador, Long> {

	@Autowired
	private ColaboradorRepository repository;

	@Override
	public JpaRepository<Colaborador, Long> getRepository() {
		return repository;
	}

}
