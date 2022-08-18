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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.Animal;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test") // Switching to H2, for the test
public class AnimalControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper; // Used for converting objects to JSON
	
	@Test
	public void createTest() throws Exception {
		// Create an object for posting
		Animal entry = new Animal("Tom", "Dog", "Carnivore", 10);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		// Create an object for checking the result
		Animal result = new Animal(2L, "Tom", "Dog","Carnivore",10);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(post("/animal/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	
	@Test
	public void readAllTest() throws Exception {
		// Create a list to check the output of readAll
		List<Animal> result = new ArrayList<>();
		// Add the single entry to the list
		result.add(new Animal(1L, "Moon", "Brazilian Wandering Spider", "Carnivore", 2));
		// Convert the list to JSON (The API responds in JSON)
		String resultAsJSON = mapper.writeValueAsString(result);
		
		
		
		mvc.perform(get("/animal/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void readByIdTest() throws Exception {
		Animal F = new Animal(1L, "Moon", "Brazilian Wandering Spider", "Carnivore", 2);
		String AnimalJSON = mapper.writeValueAsString(F);
		mvc.perform(get("/animal/getByID/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(AnimalJSON));
		
	}
	
	@Test
	public void updateTest() throws Exception {
		Animal update = new Animal(1L, "Moon", "Brazilian Wandering Spider", "Carnivore", 2);
		String updateJSON = mapper.writeValueAsString(update);

		Animal expected = new Animal(1L, "Moon", "Brazilian Wandering Spider", "Carnivore", 2);
		String expectedJSON = mapper.writeValueAsString(expected);

		mvc.perform(put("/animal/update/1").contentType(MediaType.APPLICATION_JSON).content(updateJSON))
				.andExpect(content().json(expectedJSON));
		
	}
	
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/animal/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
	
}
