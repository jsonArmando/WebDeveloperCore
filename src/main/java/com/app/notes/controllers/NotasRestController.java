package com.app.notes.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.notes.model.service.INotasService;
import com.app.notes.model.entity.Notas;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/app")
public class NotasRestController {
	@Autowired
	private INotasService notService;
	
	@GetMapping("/notas")
	public List<Notas> index(){
		return notService.findAll();
	}
	@GetMapping("/nota/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Notas nota(@PathVariable Long id) {
		return notService.findbyId(id);
	}
	@PostMapping("/nota/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Notas createNota(@RequestBody Notas notas) {
		return notService.save(notas);
		
	}
	@PutMapping("/nota/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Notas updateNote(@RequestBody Notas notas,@PathVariable Long id) {
		Notas notaActual= notService.findbyId(id);
		notaActual.setNombre(notas.getNombre());
		notaActual.setPrioridad(notas.getPrioridad());
		notaActual.setFechaVencimiento(notas.getFechaVencimiento());
		return notService.save(notaActual);
	}
	@DeleteMapping("/nota/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		notService.delete(id);
	}
}