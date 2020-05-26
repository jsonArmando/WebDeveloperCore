package com.app.notes.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.notes.model.entity.Notas;

public interface INotasDao extends CrudRepository<Notas, Long> {

}
