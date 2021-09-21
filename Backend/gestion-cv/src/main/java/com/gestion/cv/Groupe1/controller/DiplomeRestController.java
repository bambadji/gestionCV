package sn.b2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sn.b2.entities.Diplome;
import sn.b2.repositories.DiplomeRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DiplomeRestController {
	
	@Autowired
	private DiplomeRepository diplomeRepository;
	
	@RequestMapping(value="/diplome",method=RequestMethod.GET)
	public List<Diplome> getAllDiplome(){
		return diplomeRepository.findAll();
	}
	
	@RequestMapping(value="/diplome/{id}",method=RequestMethod.GET)
	public Optional<Diplome> getDiplome(@PathVariable Long id){
		return diplomeRepository.findById(id);
	}
	
	@RequestMapping(value="/chercherDiplome",method=RequestMethod.GET)
	public Page<Diplome> rechercer(@RequestParam(name="mc", defaultValue="") String mc, 
								   @RequestParam(name="page", defaultValue="0")int page, 
								   @RequestParam(name="size", defaultValue="5")int size){
		PageRequest paging = PageRequest.of(page, size, Sort.by("id"));
		return diplomeRepository.findByDescriptionContaining(mc, paging);
	}
	
	@RequestMapping(value="/diplome",method=RequestMethod.POST)
	public Diplome save(@RequestBody Diplome c){
		return diplomeRepository.save(c);
	}
	
	@RequestMapping(value="/diplome/{id}",method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id){
		diplomeRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/diplome/{id}",method=RequestMethod.PUT)
	public Diplome update(@PathVariable Long id, @RequestBody Diplome c){
		c.setId(id);
		return diplomeRepository.save(c);
	}

}
