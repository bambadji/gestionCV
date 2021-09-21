package sn.b2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Etablissement implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	private String libelle;
	@OneToMany(mappedBy="etablissement")
	@JsonManagedReference
	private List<Diplome> diplomes = new ArrayList<Diplome>();
	
	public Etablissement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etablissement(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Etablissement(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public Etablissement(Long id, String libelle, List<Diplome> diplomes) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.diplomes = diplomes;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Diplome> getDiplomes() {
		return diplomes;
	}

	public void setDiplomes(List<Diplome> diplomes) {
		this.diplomes = diplomes;
	}
	
	

}
