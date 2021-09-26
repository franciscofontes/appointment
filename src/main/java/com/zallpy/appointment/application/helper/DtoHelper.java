package com.zallpy.appointment.application.helper;

import org.modelmapper.ModelMapper;

public class DtoHelper<T, DTO> {

	@SuppressWarnings("unchecked")
	public DTO converterParaDto(T t, DTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(t, (Class<DTO>) dto.getClass());
	}

	@SuppressWarnings("unchecked")
	public T converterParaEntidade(DTO dto, T t) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(t, (Class<T>) t.getClass());
	}
}
