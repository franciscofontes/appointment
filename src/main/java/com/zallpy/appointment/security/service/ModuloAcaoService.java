package com.zallpy.appointment.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.application.service.CrudService;
import com.zallpy.appointment.exception.ObjectNotFoundException;
import com.zallpy.appointment.security.domain.entity.Acao;
import com.zallpy.appointment.security.domain.entity.Modulo;
import com.zallpy.appointment.security.domain.entity.ModuloAcao;
import com.zallpy.appointment.security.repository.ModuloAcaoRepository;

@Service
public class ModuloAcaoService implements CrudService<ModuloAcao, Long> {

	@Autowired
	private ModuloAcaoRepository repository;	

	public ModuloAcao buscarPorModuloEAcao(Modulo modulo, Acao acao) {
		Optional<ModuloAcao> obj = repository.findByModuloAndAcao(modulo, acao);
		obj.orElseThrow(() -> new ObjectNotFoundException("ModuloAcao nao encontrado. Tipo: " + ModuloAcao.class.getName()));
		return obj.get();
	}
	
	public List<ModuloAcao> buscarPorModulo(Long idModulo) {		
		Optional<List<ModuloAcao>> list = repository.findByModulo(new Modulo(idModulo));
		list.orElseThrow(() -> new ObjectNotFoundException("Acoes nao encontrada(s). Tipo: " + ModuloAcao.class.getName()));
		return list.get();
	}

	@Override
	public JpaRepository<ModuloAcao, Long> getRepository() {
		return repository;
	}
}
