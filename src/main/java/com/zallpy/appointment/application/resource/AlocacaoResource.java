package com.zallpy.appointment.application.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zallpy.appointment.application.dto.AlocacaoDTO;
import com.zallpy.appointment.application.service.AlocacaoService;

@RestController
@RequestMapping("/alocacoes")
public class AlocacaoResource {

	@Autowired
	private AlocacaoService service;

	@GetMapping(value = "/pagina")
	public ResponseEntity<Page<AlocacaoDTO>> buscarPorPagina(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "lines", defaultValue = "10") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		return ResponseEntity.ok().body(service.buscarTodosPorPaginaDTO(page, linesPerPage, orderBy, direction));
	}	
	
	@GetMapping(value = "/projeto/{id}")
	public ResponseEntity<List<AlocacaoDTO>> buscarAlocacoesPorProjeto(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.buscarAlocacoesPorProjeto(id));
	}
	
	@GetMapping(value = "/colaborador/{id}")
	public ResponseEntity<List<AlocacaoDTO>> buscarAlocacoesPorColaborador(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.buscarAlocacoesPorColaborador(id));
	}	
}
