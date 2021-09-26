package com.zallpy.appointment.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.application.service.CrudService;
import com.zallpy.appointment.security.domain.entity.Perfil;
import com.zallpy.appointment.security.repository.PerfilRepository;

@Service
public class PerfilService implements CrudService<Perfil, Long> {

	@Autowired
	private PerfilRepository repository;
	
	public Page<Perfil> buscarPorFiltro(String nome, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findDistinctByNomeContainingIgnoreCase(nome, pageRequest);
	}	
	
	public Perfil buscarPorNome(String nome) {		
		return repository.findByNome(nome);
	}	

	public List<Perfil> buscarPorModuloAcao(Long moduloAcaoId) {		
		return repository.findByModuloAcoes_Id(moduloAcaoId);
	}
	
	@Override
	public JpaRepository<Perfil, Long> getRepository() {
		return repository;
	}
	
}
