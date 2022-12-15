package com.example.nttdataT2SpringdavidDRA.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nttdataT2SpringdavidDRA.persistence.Product;


/**
 * interfaz que extiende jpaREPOSITORY con el fin de acceder a los métodos CRUD proporcionados por Spring
 * @author aguil
 *
 */
@Repository
public interface ProductRepositoryI extends JpaRepository<Product, Integer> {

	
}
