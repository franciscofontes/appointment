package com.zallpy.appointment.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String id, Class<?> tipo) { super("Objeto não encontrado. ID: " + id + ". Tipo: " + tipo.getName()); }

    public ObjectNotFoundException(Class<?> tipo) {
        super("Objeto não encontrado. Tipo: " + tipo.getName());
    }

    public ObjectNotFoundException(String msg) { super("Objeto não encontrado. " + msg); }

    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
