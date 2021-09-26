package com.zallpy.appointment.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.zallpy.appointment.exception.DataIntegrityException;
import com.zallpy.appointment.exception.ObjectNotFoundException;

public interface CrudService<T, ID> {

	default List<T> buscarTodos() {
		return getRepository().findAll();
	}

	default Page<T> buscarTodosPorPagina(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return getRepository().findAll(pageRequest);
	}

	default T buscarPorId(ID id) {
		Optional<T> obj = getRepository().findById(id);
		obj.orElseThrow(() -> new ObjectNotFoundException(id.toString(), getClass()));
		return obj.get();
	}

	@Transactional
	default void salvar(T obj) throws MethodArgumentNotValidException {
		try {
			getRepository().save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(DataIntegrityException.MSG_SALVAR, obj.getClass());
		}
	}

	@Transactional
	default void salvarTodos(Iterable<T> objs) throws MethodArgumentNotValidException {
		try {
			getRepository().saveAll(objs);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(DataIntegrityException.MSG_SALVAR);
		}		
	}

	@Transactional
	default void remover(ID id) throws MethodArgumentNotValidException {
		T obj = buscarPorId(id);
		try {
			getRepository().delete(obj);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(DataIntegrityException.MSG_REMOVER, obj.getClass());
		}
	}

	JpaRepository<T, ID> getRepository();
}
