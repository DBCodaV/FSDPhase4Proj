package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Pet;
import com.entity.Visit;
import com.service.PetService;
import com.service.VisitService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class VetController {
	@Autowired
	PetService pServ;

	@Autowired
	VisitService vServ;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage() {
		return "index";
	}

	@RequestMapping(value = "/newPet", method = RequestMethod.GET)
	public String newPetPage(Pet pet, Model model) {
		model.addAttribute("pp", pet);
		return "newPet";
	}

	@RequestMapping(value = "/getPet", method = RequestMethod.GET)
	public String getPetPage(Model model) {
		List<Pet> listOfPets = pServ.getAllPets();
		System.out.println(listOfPets);
		model.addAttribute("pets", listOfPets);
		return "getPet";
	}

	@RequestMapping(value = "/newVisit", method = RequestMethod.GET)
	public String newVisitPage(Visit visit, Model model) {
		model.addAttribute("vi", visit);
		return "createVisit";
	}

	@RequestMapping(value = "/getVisit", method = RequestMethod.GET)
	public String getVisitPage(Model model) {
		List<Visit> listOfVisits = vServ.getVisits();
		System.out.println(listOfVisits);
		model.addAttribute("visits", listOfVisits);
		return "getVisit";
	}

	@RequestMapping(value = "addPet", method = RequestMethod.POST)
	public String addPet(Pet pet, Model model) {
		String result = pServ.createPet(pet);
		model.addAttribute("pp", pet);
		model.addAttribute("msg", result);
		System.out.println(result);
		return "newPet";
	}

	@RequestMapping(value = "addVisit", method = RequestMethod.POST)
	public String addVisit(HttpServletRequest req, Visit visit, Model model) {
		String date = req.getParameter("date");
		long petId = Long.parseLong(req.getParameter("petid"));
		float amount = Float.parseFloat(req.getParameter("amount"));
		visit.setCost(amount);
		visit.setDate(date);
		Pet posPet = pServ.getPetFromID(petId);
		String result = "";
		if(posPet==null) {
			result = "Pet ID doesn't exist";
			model.addAttribute("vi", visit);
			model.addAttribute("msg", result);
			return "createVisit";
		}
		visit.setPet(posPet);
		result = vServ.createVisit(visit);
		model.addAttribute("vi", visit);
		model.addAttribute("msg", result);
		System.out.println(result);

		return "createVisit";
	}
}
