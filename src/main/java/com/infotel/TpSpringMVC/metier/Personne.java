package com.infotel.TpSpringMVC.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.infotel.TpSpringMVC.metier.Adresse;

/**
 * Super document regroupant les informations de la classe Personne
 * @author Raphaël
 *
 */


@Entity
@Scope (value = "prototype")
@Component
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpersonne;
	private String nom;
	private String prenom;
	private int age;
	
	@ManyToOne
	private Adresse adresse; 
	
	
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	public int getIdpersonne() {
		return idpersonne;
	}
	public void setIdpersonne(int idpersonne) {
		this.idpersonne = idpersonne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Personne [idpersonne=" + idpersonne + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}

	
}
