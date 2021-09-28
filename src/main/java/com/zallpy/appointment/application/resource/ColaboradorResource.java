package com.zallpy.appointment.application.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zallpy.appointment.application.dto.ColaboradorDTO;
import com.zallpy.appointment.application.service.ColaboradorService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorResource {

	@Autowired
	private ColaboradorService service;
	
	@GetMapping(value = "/usuario/{id}")
	public ResponseEntity<ColaboradorDTO> buscarProjetosPorColaborador(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.buscarPorIdUsuarioDTO(id));
	}
}
