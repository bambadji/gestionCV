package sn.BMF.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sn.BMF.entites.Experiences;
import sn.BMF.repositories.ExperiencesRepository;



@RestController
@RequestMapping("/api/exp")

public class ExperiencesController {
	@Autowired
	ExperiencesRepository expRepository;

	@GetMapping
	@RequestMapping("/experience")
	public List<Experiences> getAllExperiencess() {

		List<Experiences> exp = (List<Experiences>) expRepository.findAll();

		return exp;
	}
	
	@RequestMapping(value="/ajout",method=RequestMethod.POST) 
	 public Experiences save(@RequestBody Experiences c){ 
	  return expRepository.save(c); 
	 }

}
