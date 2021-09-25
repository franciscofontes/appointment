package com.zallpy.appointment.configuration;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zallpy.appointment.application.domain.entity.Alocacao;
import com.zallpy.appointment.application.domain.entity.Colaborador;
import com.zallpy.appointment.application.domain.entity.Projeto;
import com.zallpy.appointment.application.service.AlocacaoService;
import com.zallpy.appointment.application.service.ColaboradorService;
import com.zallpy.appointment.application.service.ProjetoService;

@Configuration
@Profile("dev")
public class DevConfig implements WebMvcConfigurer {

	@Autowired
	private ColaboradorService colaboradorService;

	@Autowired
	private ProjetoService projetoService;

	@Autowired
	private AlocacaoService alocacaoService;

	@Transactional
	@Bean
	public boolean instantiateDatabase() throws Exception {

		Colaborador administrador = new Colaborador("Administrador");
		Colaborador programador1 = new Colaborador("Programador 1");
		Colaborador programador2 = new Colaborador("Programador 2");

		Projeto projetoA = new Projeto("Projeto Cliente A");
		Projeto projetoB = new Projeto("Projeto Cliente B");

		Alocacao a1 = new Alocacao(programador1, projetoA);
		Alocacao a2 = new Alocacao(programador2, projetoA);
		Alocacao a3 = new Alocacao(programador2, projetoB);

		colaboradorService.salvarTodos(Arrays.asList(administrador, programador1, programador2));
		projetoService.salvarTodos(Arrays.asList(projetoA, projetoB));
		alocacaoService.salvarTodos(Arrays.asList(a1, a2, a3));		

		return true;
	}
}
