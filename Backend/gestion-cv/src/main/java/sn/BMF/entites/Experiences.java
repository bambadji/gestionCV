package sn.BMF.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Experiences implements Serializable{
	   @Id @GeneratedValue 
	   private Long ID_EXPERIENCE;
	   private String ENTREPRISE;
	   private String TYPE_EMPLOIE;
	   private String DESCRIPTION;
	   private Date DATE_DEBUT;
	   private Date DATE_FIN;
	public Experiences() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Experiences(String eNTREPRISE, String tYPE_EMPLOIE, String dESCRIPTION, Date dATE_DEBUT, Date dATE_FIN) {
		super();
		ENTREPRISE = eNTREPRISE;
		TYPE_EMPLOIE = tYPE_EMPLOIE;
		DESCRIPTION = dESCRIPTION;
		DATE_DEBUT = dATE_DEBUT;
		DATE_FIN = dATE_FIN;
	}
	public Experiences(long iD_EXPERIENCE, String eNTREPRISE, String tYPE_EMPLOIE, String dESCRIPTION, Date dATE_DEBUT,
			Date dATE_FIN) {
		super();
		ID_EXPERIENCE = iD_EXPERIENCE;
		ENTREPRISE = eNTREPRISE;
		TYPE_EMPLOIE = tYPE_EMPLOIE;
		DESCRIPTION = dESCRIPTION;
		DATE_DEBUT = dATE_DEBUT;
		DATE_FIN = dATE_FIN;
	}
	public long getID_EXPERIENCE() {
		return ID_EXPERIENCE;
	}
	public void setID_EXPERIENCE(long iD_EXPERIENCE) {
		ID_EXPERIENCE = iD_EXPERIENCE;
	}
	public String getENTREPRISE() {
		return ENTREPRISE;
	}
	public void setENTREPRISE(String eNTREPRISE) {
		ENTREPRISE = eNTREPRISE;
	}
	public String getTYPE_EMPLOIE() {
		return TYPE_EMPLOIE;
	}
	public void setTYPE_EMPLOIE(String tYPE_EMPLOIE) {
		TYPE_EMPLOIE = tYPE_EMPLOIE;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public Date getDATE_DEBUT() {
		return DATE_DEBUT;
	}
	public void setDATE_DEBUT(Date dATE_DEBUT) {
		DATE_DEBUT = dATE_DEBUT;
	}
	public Date getDATE_FIN() {
		return DATE_FIN;
	}
	public void setDATE_FIN(Date dATE_FIN) {
		DATE_FIN = dATE_FIN;
	}
	   
	   

}
