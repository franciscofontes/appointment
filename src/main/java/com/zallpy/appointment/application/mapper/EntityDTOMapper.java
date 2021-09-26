package com.zallpy.appointment.application.mapper;

public interface EntityDTOMapper<T, DTO> {

	T converterParaEntidade(DTO dto);	
}
