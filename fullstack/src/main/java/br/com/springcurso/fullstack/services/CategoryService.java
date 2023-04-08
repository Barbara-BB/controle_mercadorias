package br.com.springcurso.fullstack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springcurso.fullstack.entities.Category;
import br.com.springcurso.fullstack.exceptions.ResourceNotFoundExceptions;
import br.com.springcurso.fullstack.respositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
		
	}
	
	public Category findById(Long Id){
		Optional<Category> obj = repository.findById(Id);
		return obj.orElseThrow(()-> new ResourceNotFoundExceptions(Id));
	}
	
	public Category save(Category category) {
		return repository.save(category);
	}
	
	public Category update(Category category, Long id) {
		category.setId(id);
		return repository.save(category);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
