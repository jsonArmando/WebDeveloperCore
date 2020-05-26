package com.app.notes.model.service;

import java.util.List;

import com.app.notes.model.entity.Notas;

public interface INotasService {
	public List<Notas> findAll();
	public Notas findbyId(Long id);
	public Notas save(Notas notas);
	public void delete(Long id);
}
