package com.zallpy.appointment.application.mapper;

import com.zallpy.appointment.application.domain.entity.Alocacao;
import com.zallpy.appointment.application.domain.entity.Apontamento;
import com.zallpy.appointment.application.dto.ApontamentoDTO;

public class ApontamentoMapper implements EntityDTOMapper<Apontamento, ApontamentoDTO> {

	@Override
	public Apontamento converterParaEntidade(ApontamentoDTO dto) {
		Apontamento apontamento = new Apontamento();
		apontamento.setId(dto.getId());
		apontamento.setMinutos(dto.getMinutos());
		apontamento.setAlocacao(new Alocacao(dto.getIdAlocacao()));
		return apontamento;
	}

}
