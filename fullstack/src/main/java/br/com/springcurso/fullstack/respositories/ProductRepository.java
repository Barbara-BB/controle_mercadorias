package br.com.springcurso.fullstack.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springcurso.fullstack.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
