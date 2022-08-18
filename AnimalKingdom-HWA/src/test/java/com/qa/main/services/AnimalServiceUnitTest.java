package com.qa.main.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.domain.Animal;
import com.qa.main.repos.AnimalRepo;



@SpringBootTest
public class AnimalServiceUnitTest {
	@Autowired
	private AnimalService service;

	@MockBean
	private AnimalRepo repo;

	@Test
	public void testCreate() {
		// Create and object for saving
		Animal entry = new Animal("Tom", "Dog", "Carnivore", 10);

		// Create an object for the result
		Animal result = new Animal(10L,"Tom", "Dog", "Carnivore", 10);

		Mockito.when(repo.saveAndFlush(entry)).thenReturn(result);

		assertEquals(result, service.create(entry));
	}

	@Test
	public void testGetAll() {
		// Create and object for saving
		List<Animal> result = new ArrayList<>();
		result.add(new Animal("Tom", "Dog", "Carnivore", 10));

		Mockito.when(repo.findAll()).thenReturn(result);

		assertEquals(result, service.getAll());
	}

	@Test
	public void getByIdTest() {

		long id = 1;
		// Create an object for saving
		Animal result = new Animal(1L,"Tom", "Dog", "Carnivore", 10);
		Optional<Animal> resultI = Optional.of(result);
		Mockito.when(repo.findById(id)).thenReturn(resultI);

		assertEquals(result, service.getByID(id));

	}

//	@Test
//	public void updateByIdTest() {
//		long id = 1L;
//		Animal entry = new Animal("Tommy", "Dog", "Carnivore", 7);
//
//		Animal existing = new Animal(1L,"Tom", "Dog", "Carnivore", 10);
//		Optional<Animal> existingF = Optional.of(existing);
//		Mockito.when(repo.findById(id)).thenReturn(existingF);
//
//		Animal update = new Animal(1L,"Tommy", "Dog", "Carnivore", 7);
//
//		//Mockito.when(repo.findById(1L).thenReturn)
//		Mockito.when(repo.saveAndFlush(update)).thenReturn(update);
//		
//		assertEquals(update, service.update(id, entry));
//	}
	
	@Test
	
	public void updateTest() {
		long id= 1L;
		Animal update  = new Animal (1L, "Tommy", "Dog","Canivore", 7);
		Optional <Animal> updateOp = Optional.ofNullable(update);
		Animal expected = new Animal (1L, "Tommy", "Dog","Canivore", 7);
		
		
		Mockito.when(repo.findById(id)).thenReturn(updateOp);
		Mockito.when(repo.saveAndFlush(update)).thenReturn(expected);
		
		
		assertEquals(expected,service.update(id, update));
	}
	
	@Test
	
	public void deleteTest() {
		
		Long id = 1L;
		Mockito.when(repo.existsById(1L)).thenReturn(false);
		
		assertEquals(true, service.delete(id));
		
		
	}
	
	
	

	
}