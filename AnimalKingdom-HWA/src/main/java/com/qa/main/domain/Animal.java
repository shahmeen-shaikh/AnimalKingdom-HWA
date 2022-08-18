package com.qa.main.domain;

//import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Animal {
	
	//Columns in SQL database
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String genus;
	
	@Column(nullable = false)
	private String dietaryGroup;
	
	@Column(nullable = false)
	private int age;

	//Constructors
	
	//Default Constructor 
	public Animal() {}
	
	
	//For creating
	
	public Animal(String name, String genus, String dietaryGroup, int age) {
		super();
		this.name = name;
		this.genus = genus;
		this.dietaryGroup = dietaryGroup;
		this.age = age;
	}
	
	//For Reading
	public Animal(long id, String name, String genus, String dietaryGroup, int age) {
		super();
		this.id = id;
		this.name = name;
		this.genus = genus;
		this.dietaryGroup = dietaryGroup;
		this.age = age;
	}

	
	//Getters and Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getDietaryGroup() {
		return dietaryGroup;
	}

	public void setDietaryGroup(String dietaryGroup) {
		this.dietaryGroup = dietaryGroup;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	 //Override methods
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(age, dietaryGroup, genus, id, name);
//	}
//
//   
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Animal other = (Animal) obj;
//		return age == other.age && Objects.equals(dietaryGroup, other.dietaryGroup)
//				&& Objects.equals(genus, other.genus) && id == other.id && Objects.equals(name, other.name);
//	}
//	
	
}