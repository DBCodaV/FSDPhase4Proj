package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Visit;
import com.repository.VisitRepository;

@Service
public class VisitService {
	@Autowired
	VisitRepository visRepo;
	public String createVisit(Visit visit) {
		
		visRepo.save(visit);
		return "Visit saved";
	}
	public List<Visit> getVisits(){
		return visRepo.findAll();
	}
	public Visit getVisitFromId(long id) {
		Optional<Visit> result = visRepo.findById(id);
		if(result.isPresent()) {
			Visit v = result.get();
			return v;
			
		} else {
			return null;
		}
	}
}
