package com.zallpy.appointment.exception;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public static final String MSG_SALVAR = "Não foi possivel salvar";
	public static final String MSG_ADD = "Não foi possivel adicionar";
	public static final String MSG_EDITAR = "Não foi possivel editar";
	public static final String MSG_REMOVER = "Não foi possivel remover";

	public DataIntegrityException(String msg, String id, Class<?> tipo) {
		super(msg + ". ID: " + id.toString() + ". Tipo: " + tipo.getName());
	}

	public DataIntegrityException(String msg, Class<?> tipo) {
		super(msg + ". Tipo: " + tipo.getName());
	}
	
	public DataIntegrityException(String msg) {
		super(msg);
	}	
}
