package br.com.springcurso.fullstack.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.springcurso.fullstack.entities.Category;
import br.com.springcurso.fullstack.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findByiD(@PathVariable Long id){
		Category list = service.findById(id);
		return ResponseEntity.ok().body(list);
	}
	
	
	@PostMapping
	public ResponseEntity<Category> create(@RequestBody Category category){
		category = service.save(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
		return ResponseEntity.created(uri).body(category);
	}
	
	
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
	public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Long id){
		category = service.update(category, id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	@DeleteMapping(value = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
