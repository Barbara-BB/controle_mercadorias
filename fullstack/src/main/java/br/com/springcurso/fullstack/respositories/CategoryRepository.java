package br.com.springcurso.fullstack.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springcurso.fullstack.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
