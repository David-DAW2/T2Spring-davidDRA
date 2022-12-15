package com.example.nttdataT2SpringdavidDRA.repositores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.example.nttdataT2SpringdavidDRA.persistence.Order;


/**
 * interfaz que extiende jpaREPOSITORY con el fin de acceder a los métodos CRUD proporcionados por Spring
 * @author aguil
 *
 */
@Repository
public interface OrderRepositoryI extends JpaRepository<Order, Integer>{

	
}
