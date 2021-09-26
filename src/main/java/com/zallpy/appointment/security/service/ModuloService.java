package com.zallpy.appointment.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.application.service.CrudService;
import com.zallpy.appointment.exception.ObjectNotFoundException;
import com.zallpy.appointment.security.domain.entity.Modulo;
import com.zallpy.appointment.security.repository.ModuloRepository;

@Service
public class ModuloService implements CrudService<Modulo, Long> {

	@Autowired
	private ModuloRepository repository;	
	
	public Modulo buscarPorNome(String nome) {
		Optional<Modulo> obj = repository.findByNomeIgnoreCase(nome);
		obj.orElseThrow(() -> new ObjectNotFoundException("Modulo nao encontrado. Nome: " + nome + ". Tipo: " + Modulo.class.getName()));
		return obj.get();
	}

	@Override
	public JpaRepository<Modulo, Long> getRepository() {
		return repository;
	}
}
