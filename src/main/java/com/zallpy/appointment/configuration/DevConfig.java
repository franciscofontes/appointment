package com.zallpy.appointment.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.zallpy.appointment.security.domain.entity.Acao;
import com.zallpy.appointment.security.domain.entity.Modulo;
import com.zallpy.appointment.security.domain.entity.ModuloAcao;
import com.zallpy.appointment.security.domain.entity.Perfil;
import com.zallpy.appointment.security.domain.entity.Usuario;
import com.zallpy.appointment.security.service.AcaoService;
import com.zallpy.appointment.security.service.ModuloAcaoService;
import com.zallpy.appointment.security.service.ModuloService;
import com.zallpy.appointment.security.service.PerfilService;
import com.zallpy.appointment.security.service.UsuarioService;

@Configuration
@Profile("dev")
public class DevConfig implements WebMvcConfigurer {

	@Autowired
	private ColaboradorService colaboradorService;

	@Autowired
	private ProjetoService projetoService;

	@Autowired
	private AlocacaoService alocacaoService;

	@Autowired
	private ModuloService moduloService;

	@Autowired
	private AcaoService acaoService;

	@Autowired
	private ModuloAcaoService moduloAcaoService;
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	private List<Acao> todasAcoes = new ArrayList<>();

	@Transactional
	@Bean
	public boolean instantiateDatabase() throws Exception {
		cadastrarAlocacoes();
		
		cadastrarAcoes();
		cadastrarModulos();
		cadastrarModulosAcoes();
		cadastrarPerfis();
		cadastrarUsuariosAtualizarColaboradores();
		
		return true;
	}

	@Transactional
	private void cadastrarAlocacoes() throws Exception {

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
	}

	@Transactional
	private void cadastrarAcoes() throws Exception {
		
		Acao listar = new Acao("LISTAR", "Listar", "Lista registros");
		Acao cadastrar = new Acao("CADASTRAR", "Cadastrar", "Cadastra registros");
		Acao editar = new Acao("EDITAR", "Editar", "Edita registros");
		Acao remover = new Acao("REMOVER", "Remover", "Remove registros");
		
		todasAcoes = Arrays.asList(listar, cadastrar, editar, remover);
		
		acaoService.salvarTodos(todasAcoes);		
	}
	
	@Transactional
	private void cadastrarModulos() throws Exception {
		Modulo apontamento = new Modulo("APONTAMENTO", "Apontamento", "Módulo para apontamento em projetos");
		moduloService.salvarTodos(Arrays.asList(apontamento));
	}
	
	@Transactional
	private void cadastrarModulosAcoes() throws Exception {
		Modulo apontamento = moduloService.buscarPorNome("APONTAMENTO");		
		for (Acao acao : todasAcoes) {
			moduloAcaoService.salvar(new ModuloAcao(apontamento, acao));
		}	
	}	
	
	@Transactional
	private void cadastrarPerfis() throws Exception {	
		
		Modulo apontamento = moduloService.buscarPorNome("APONTAMENTO");		
		List<ModuloAcao> todasModulosAcoesApontamento = moduloAcaoService.buscarPorModulo(apontamento.getId());
		
		Perfil adm = new Perfil("ADM");
		adm.addModulosAcao(todasModulosAcoesApontamento);
		perfilService.salvar(adm);

		Perfil colaborador = new Perfil("COLABORADOR");		
		colaborador.addModulosAcao(todasModulosAcoesApontamento);
		perfilService.salvar(colaborador);
	}
	
	@Transactional
	private void cadastrarUsuariosAtualizarColaboradores() throws Exception {
		
		Perfil adm = perfilService.buscarPorNome("ADM");
		Perfil colaborador = perfilService.buscarPorNome("COLABORADOR");
		
		Usuario usuarioAdm = new Usuario("adm@teste.com.br", adm);
		Usuario usuarioProg1 = new Usuario("prog1@teste.com.br", colaborador);
		Usuario usuarioProg2 = new Usuario("prog2@teste.com.br", colaborador);
				
		usuarioService.salvarTodos(Arrays.asList(usuarioAdm, usuarioProg1, usuarioProg2));
				
		Colaborador administrador = colaboradorService.buscarPorNome("Administrador");
		administrador.setUsuario(usuarioAdm);		
		Colaborador programador1 = colaboradorService.buscarPorNome("Programador 1");
		programador1.setUsuario(usuarioProg1);		
		Colaborador programador2 = colaboradorService.buscarPorNome("Programador 2");
		programador2.setUsuario(usuarioProg2);
		
		colaboradorService.salvarTodos(Arrays.asList(administrador, programador1, programador2));		
	}	
}
