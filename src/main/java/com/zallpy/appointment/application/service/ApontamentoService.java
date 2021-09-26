package com.zallpy.appointment.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.zallpy.appointment.application.domain.entity.Apontamento;
import com.zallpy.appointment.application.dto.ApontamentoDTO;
import com.zallpy.appointment.application.mapper.ApontamentoMapper;
import com.zallpy.appointment.application.repository.ApontamentoRepository;

@Service
public class ApontamentoService implements CrudService<Apontamento, Long> {

	@Autowired
	private ApontamentoRepository repository;

	@Transactional
	public void salvarFromDTO(ApontamentoDTO dto) throws MethodArgumentNotValidException {
		ApontamentoMapper mapper = new ApontamentoMapper();
		salvar(mapper.converterParaEntidade(dto));
	}

	@Override
	public JpaRepository<Apontamento, Long> getRepository() {
		return repository;
	}

}
