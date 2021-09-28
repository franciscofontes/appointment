package com.zallpy.appointment.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zallpy.appointment.application.domain.entity.Colaborador;
import com.zallpy.appointment.application.dto.ColaboradorDTO;
import com.zallpy.appointment.application.repository.ColaboradorRepository;
import com.zallpy.appointment.exception.ObjectNotFoundException;

@Service
public class ColaboradorService implements CrudService<Colaborador, Long> {

	@Autowired
	private ColaboradorRepository repository;
	
	public Colaborador buscarPorNome(String nome) throws ObjectNotFoundException {
		Optional<Colaborador> obj = repository.findByNome(nome);
		obj.orElseThrow(() -> new ObjectNotFoundException("Usuario nao encontrado. Nome: " + nome + ". Tipo: " + Colaborador.class.getName()));
		return obj.get();
	}	
	
	public ColaboradorDTO buscarPorNomeDTO(String nome) throws ObjectNotFoundException {
		return new ColaboradorDTO(buscarPorNome(nome));
	}
	
	public ColaboradorDTO buscarPorIdUsuarioDTO(Long idUsuario) throws ObjectNotFoundException {
		Optional<Colaborador> obj = repository.findByIdUsuario(idUsuario);
		obj.orElseThrow(() -> new ObjectNotFoundException("Usuario nao encontrado. Id do usuario: " + idUsuario + ". Tipo: " + Colaborador.class.getName()));
		return new ColaboradorDTO(obj.get());
	}	

	@Override
	public JpaRepository<Colaborador, Long> getRepository() {
		return repository;
	}

}
