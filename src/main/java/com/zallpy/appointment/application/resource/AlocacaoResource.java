package com.zallpy.appointment.application.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zallpy.appointment.application.dto.AlocacaoDTO;
import com.zallpy.appointment.application.service.AlocacaoService;

@RestController
@RequestMapping("/alocacoes")
public class AlocacaoResource {

	@Autowired
	private AlocacaoService service;

	@GetMapping(value = "/projeto/{id}")
	public ResponseEntity<List<AlocacaoDTO>> buscarAlocacoesPorProjeto(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.buscarAlocacoesPorProjeto(id));
	}
	
	@GetMapping(value = "/colaborador/{id}")
	public ResponseEntity<List<AlocacaoDTO>> buscarAlocacoesPorColaborador(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.buscarAlocacoesPorColaborador(id));
	}	
}
