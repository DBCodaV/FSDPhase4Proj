package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Pet;
import com.repository.PetRepository;

@Service
public class PetService {
	@Autowired
	PetRepository petRepo;
	public String createPet(Pet pet) {
		
		petRepo.save(pet);
		return "Pet Stored in Database";
	}
	public Pet getPetFromID(long id) {
		Optional<Pet> result = petRepo.findById(id);
		if(result.isPresent()) {
			Pet p = result.get();
			return p;
			
		} else {
			return null;
		}
	}
	public List<Pet> getAllPets(){
		return petRepo.findAll();
	}
	
}
