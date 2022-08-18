package com.qa.main.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.domain.Animal;
import com.qa.main.services.AnimalService;

@RestController
@CrossOrigin
@RequestMapping("/animal")


public class AnimalController {
	
	private AnimalService service;
	
	public AnimalController(AnimalService service) {
		this.service = service;
	}
	
	//private List<Animal> animals = new ArrayList<>();
	
	//Post Requests - CREATE
	@PostMapping("/create")
	public ResponseEntity<Animal> create (@RequestBody Animal animal) {
		return new ResponseEntity<Animal>(service.create(animal), HttpStatus.CREATED);
	}
	
	
	//Get Requests - READ
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Animal>> getAll(){
		return new ResponseEntity<List<Animal>>(service.getAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/getByID/{id}")
	public Animal getByID(@PathVariable long id) {
		return service.getByID(id);
	}
	
	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Animal>> getByName(@PathVariable String name) {
		return new ResponseEntity<List<Animal>>(service.getByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/getByGenus/{genus}")
	public ResponseEntity<List<Animal>> getByGenus(@PathVariable String genus) {
		return new ResponseEntity<List<Animal>>(service.getByGenus(genus), HttpStatus.OK);
	}
	
	//Put Requests - UPDATE
	@PutMapping("/update/{id}")
	public Animal update(@PathVariable long id, @RequestBody Animal animal) {
		return service.update(id, animal);
	}
	
	
	//Delete Requests - DELETE
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.NO_CONTENT);
	}
	

}

