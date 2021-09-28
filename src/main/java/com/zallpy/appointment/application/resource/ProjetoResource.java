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

import com.zallpy.appointment.application.dto.ProjetoDTO;
import com.zallpy.appointment.application.service.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoResource {

	@Autowired
	private ProjetoService service;

	@PreAuthorize("hasAuthority('LISTAR_PROJETO')")
	@GetMapping(value = "/pagina")
	public ResponseEntity<Page<ProjetoDTO>> buscarPorPagina(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "lines", defaultValue = "10") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		return ResponseEntity.ok().body(service.buscarTodos(page, linesPerPage, orderBy, direction));
	}
	
	@PreAuthorize("hasAuthority('LISTAR_POR_COLABORADOR_PROJETO')")
	@GetMapping(value = "/colaborador/{id}")
	public ResponseEntity<Page<ProjetoDTO>> buscarProjetosPorColaborador(
			@PathVariable Long id,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "lines", defaultValue = "10") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		return ResponseEntity.ok().body(service.buscarProjetosPorColaborador(id, page, linesPerPage, orderBy, direction));
	}	
}
