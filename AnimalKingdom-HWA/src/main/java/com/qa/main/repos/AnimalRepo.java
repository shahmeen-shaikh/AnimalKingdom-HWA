package com.qa.main.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.main.domain.Animal;

@Repository

public interface AnimalRepo extends JpaRepository<Animal, Long> {
	
	
	List<Animal> findAnimalByName(String name);
	
	@Query(value = "SELECT * FROM Animal WHERE genus = ?1", nativeQuery = true)
	List<Animal> getByGenus(String genus);
	
}
