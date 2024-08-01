package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{
	@Query("Select p FROM Pet p Where p.name = :name")
	public Optional<Pet> getPetByName(@Param("name") String name);
	
}
