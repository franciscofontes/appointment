package com.zallpy.appointment.application.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zallpy.appointment.application.dto.ApontamentoDTO;
import com.zallpy.appointment.application.service.ApontamentoService;

@RestController
@RequestMapping("/apontamentos")
public class ApontamentoResource {

	@Autowired
	private ApontamentoService service;		

	@PreAuthorize("hasAuthority('CADASTRAR_APONTAMENTO')")
	@PostMapping()
	public ResponseEntity<Void> cadastrar(@Valid @RequestBody ApontamentoDTO apontamento) throws MethodArgumentNotValidException {
		service.salvarFromDTO(apontamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(apontamento.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
