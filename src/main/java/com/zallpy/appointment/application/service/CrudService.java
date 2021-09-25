package com.zallpy.appointment.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

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
		obj.orElseThrow(() -> new ObjectNotFoundException("ID: " + id.toString()));
		return obj.get();
	}

	@Transactional
	default void salvar(T obj) throws MethodArgumentNotValidException {
		getRepository().save(obj);
	}
	
	@Transactional
	default void salvarTodos(Iterable<T> objs) throws MethodArgumentNotValidException {
		getRepository().saveAll(objs);
	}	

	@Transactional
	default void remover(ID id) throws MethodArgumentNotValidException {
		T obj = buscarPorId(id);
		getRepository().delete(obj);
	}

	JpaRepository<T, ID> getRepository();
}
