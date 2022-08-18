package com.qa.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
