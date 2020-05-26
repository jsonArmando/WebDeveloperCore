package com.app.notes.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.notes.model.dao.INotasDao;
import com.app.notes.model.entity.Notas;

@Service
public class INotasImpl implements INotasService{
	@Autowired
	private INotasDao notasDao;

	@Override
	@Transactional(readOnly = true)
	public List<Notas> findAll() {
		return (List<Notas>) notasDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Notas findbyId(Long id) {
		return notasDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Notas save(Notas notas) {
		return notasDao.save(notas);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		notasDao.deleteById(id);
	}
}
