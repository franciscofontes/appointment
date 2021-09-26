package com.zallpy.appointment.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.application.service.CrudService;
import com.zallpy.appointment.exception.ObjectNotFoundException;
import com.zallpy.appointment.security.domain.entity.Acao;
import com.zallpy.appointment.security.repository.AcaoRepository;

@Service
public class AcaoService implements CrudService<Acao, Long> {

	@Autowired
	private AcaoRepository repository;

	public Acao buscarPorNome(String nome) {
		Optional<Acao> obj = repository.findByNomeIgnoreCase(nome);
		obj.orElseThrow(() -> new ObjectNotFoundException("Acao nao encontrada. Nome: " + nome + ". Tipo: " + Acao.class.getName()));
		return obj.get();
	}

	@Override
	public JpaRepository<Acao, Long> getRepository() {
		return repository;
	}
	
}
