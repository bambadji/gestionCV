package sn.b2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Diplome implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	private Date date_obtention;
	private String description;
	@ManyToOne()
	@JoinColumn(name="id_etablissement")
	@JsonBackReference
	private Etablissement etablissement;
	
	public Diplome() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Diplome(Date date_obtention, String description, Etablissement etablissement) {
		super();
		this.date_obtention = date_obtention;
		this.description = description;
		this.etablissement = etablissement;
	}
	public Diplome(Long id, Date date_obtention, String description, Etablissement etablissement) {
		super();
		this.id = id;
		this.date_obtention = date_obtention;
		this.description = description;
		this.etablissement = etablissement;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate_obtention() {
		return date_obtention;
	}
	public void setDate_obtention(Date date_obtention) {
		this.date_obtention = date_obtention;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Etablissement getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	
	
	
	

}
