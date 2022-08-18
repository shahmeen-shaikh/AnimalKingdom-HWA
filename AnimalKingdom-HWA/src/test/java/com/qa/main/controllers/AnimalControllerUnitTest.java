package com.qa.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.Animal;
import com.qa.main.services.AnimalService;

@WebMvcTest
public class AnimalControllerUnitTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private AnimalService service;
	
	@Test
	void createTest() throws Exception {
		// Create an object for posting
		Animal entry = new Animal("Moon", "Brazilian Wandering Spider", "Carnivore", 2);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		// Create an object for checking the result
		Animal result = new Animal(1L, "Moon", "Brazilian Wandering Spider", "Carnivore", 2);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.create(entry)).thenReturn(result);
		
		mvc.perform(post("/animal/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void readAllTest() throws Exception {
		// Create a list to check the output of readAll
		List<Animal> result = new ArrayList<>();
		// Add the single entry to the list
		result.add(new Animal(1L, "Moon", "Brazilian Wandering Spider", "Carnivore", 2));
		// Convert the list to JSON (The API responds in JSON)
		String resultAsJSON = mapper.writeValueAsString(result);
		
		
		Mockito.when(service.getAll()).thenReturn(result);
		
		
		mvc.perform(get("/animal/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void readByIdTest() throws Exception {
		Animal F = new Animal(1L, "Moon", "Brazilian Wandering Spider", "Carnivore", 2);
		String AnimalJSON = mapper.writeValueAsString(F);
		
		Mockito.when(service.getByID(1L)).thenReturn(F);
		
		mvc.perform(get("/animal/getByID/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(AnimalJSON));
		
	}
	
	
	@Test
	public void updateTest() throws Exception {
		Animal update = new Animal(1L, "Moon", "Brazilian Wandering Spider", "Carnivore", 2);
		String updateJSON = mapper.writeValueAsString(update);

		Animal expected = new Animal(1L, "Moon", "Brazilian Wandering Spider", "Carnivore", 2);
		String expectedJSON = mapper.writeValueAsString(expected);
		
		Mockito.when(service.update(1L, update)).thenReturn(expected);

		mvc.perform(put("/animal/update/1").contentType(MediaType.APPLICATION_JSON).content(updateJSON))
		.andExpect(status().isOk());
		
	}
	
	
	@Test
	public void deleteTest() throws Exception {
		
		Mockito.when(service.delete(1L)).thenReturn(true);
		
		mvc.perform(delete("/animal/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
	
	
	
	
	
}
