package com.qa.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.main.domain.Animal;
import com.qa.main.exceptions.AnimalNotFoundException;
import com.qa.main.repos.AnimalRepo;


@Service

public class AnimalService {
	
	private AnimalRepo repo;
	
	public AnimalService(AnimalRepo repo) {
		this.repo = repo;
	}

	public Animal create(Animal animal) {
		return repo.saveAndFlush(animal);
	}
	
	public List<Animal> getAll() {
		return repo.findAll();
	}
	
	public Animal getByID(long id) {
		return repo.findById(id).orElseThrow(AnimalNotFoundException::new);
	}
	
	public List<Animal> getByName(String name) {
		return repo.findAnimalByName(name);
	}
	
	public List<Animal> getByGenus(String genus) {
		return repo.getByGenus(genus);
	}
	
	public Animal update(long id, Animal animal) {
		// We get the existing entry
		Animal existing = repo.findById(id).get();
		
		// Update the existing entry, to match the incoming object
		existing.setName(animal.getName());
		existing.setGenus(animal.getGenus());
		existing.setAge(animal.getAge());
		
		// Save the updated entry back into the DB (ID is the same)
		return repo.saveAndFlush(existing);
		
	}
	
	public boolean delete(long id) {
		repo.deleteById(id);
		
		return !repo.existsById(id);
	}
	
}

