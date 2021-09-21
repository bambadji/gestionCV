/**
 * 
 */
package sn.b2.controller;

/**
 * @author Administrateur
 *
 */

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

import sn.b2.entities.Etablissement;
import sn.b2.repositories.EtablissementRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EtablissementRestController {
	
	@Autowired
	private EtablissementRepository etablissementRepository;
	
	@RequestMapping(value="/etablissement",method=RequestMethod.GET)
	public List<Etablissement> getAllEtablissement(){
		return etablissementRepository.findAll();
	}
	
	@RequestMapping(value="/etablissement/{id}",method=RequestMethod.GET)
	public Optional<Etablissement> getEtablissement(@PathVariable Long id){
		return etablissementRepository.findById(id);
	}
	
	@RequestMapping(value="/chercherEtablissement",method=RequestMethod.GET)
	public Page<Etablissement> rechercer(@RequestParam(name="mc", defaultValue="") String mc, 
								   @RequestParam(name="page", defaultValue="0")int page, 
								   @RequestParam(name="size", defaultValue="5")int size){
		PageRequest paging = PageRequest.of(page, size, Sort.by("id"));
		return etablissementRepository.findByLibelleContaining(mc, paging);
	}
	
	@RequestMapping(value="/etablissement",method=RequestMethod.POST)
	public Etablissement save(@RequestBody Etablissement c){
		return etablissementRepository.save(c);
	}
	
	@RequestMapping(value="/etablissement/{id}",method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id){
		etablissementRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/etablissement/{id}",method=RequestMethod.PUT)
	public Etablissement update(@PathVariable Long id, @RequestBody Etablissement c){
		c.setId(id);
		return etablissementRepository.save(c);
	}

}
