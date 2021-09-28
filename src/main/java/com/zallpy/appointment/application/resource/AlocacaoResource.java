package com.zallpy.appointment.application.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

	@PreAuthorize("hasAuthority('LISTAR_ALOCACAO')")
	@GetMapping(value = "/pagina")
	public ResponseEntity<Page<AlocacaoDTO>> buscarPorPagina(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "lines", defaultValue = "10") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		return ResponseEntity.ok().body(service.buscarTodos(page, linesPerPage, orderBy, direction));
	}
	
	@PreAuthorize("hasAuthority('LISTAR_POR_PROJETO_ALOCACAO')")
	@GetMapping(value = "/projeto/{id}")
	public ResponseEntity<Page<AlocacaoDTO>> buscarAlocacoesPorProjeto(
			@PathVariable Long id,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "lines", defaultValue = "10") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		return ResponseEntity.ok().body(service.buscarAlocacoesPorProjeto(id, page, linesPerPage, orderBy, direction));
	}
	
	@PreAuthorize("hasAuthority('LISTAR_POR_COLABORADOR_ALOCACAO')")
	@GetMapping(value = "/colaborador/{id}")
	public ResponseEntity<Page<AlocacaoDTO>> buscarAlocacoesPorColaborador(
			@PathVariable Long id,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "lines", defaultValue = "10") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		return ResponseEntity.ok().body(service.buscarAlocacoesPorColaborador(id, page, linesPerPage, orderBy, direction));
	}	
	
	@PreAuthorize("hasAuthority('LISTAR_POR_COLABORADOR_ALOCACAO')")
	@GetMapping(value = "/colaborador/{idColaborador}/projeto/{idProjeto}")
	public ResponseEntity<Page<AlocacaoDTO>> buscarAlocacoesPorColaboradorEProjeto(
			@PathVariable Long idColaborador,
			@PathVariable Long idProjeto,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "lines", defaultValue = "10") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		return ResponseEntity.ok().body(service.buscarAlocacoesPorColaboradoreProjeto(idColaborador, idProjeto, page, linesPerPage, orderBy, direction));
	}	
}
