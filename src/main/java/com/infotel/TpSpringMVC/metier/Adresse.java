package com.infotel.TpSpringMVC.metier;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Scope (value = "prototype")
@Component
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idadresse;
	private String numRue;
	private String nomRue;
	private String cp;
	private String ville;
	
	@OneToMany(mappedBy = "adresse")
	private List<Personne> personnes;
	

	
	public int getIdadresse() {
		return idadresse;
	}

	public void setIdadresse(int idadresse) {
		this.idadresse = idadresse;
	}

	public String getNumRue() {
		return numRue;
	}

	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	@Override
	public String toString() {
		return "Adresse [idadresse=" + idadresse + ", numRue=" + numRue + ", nomRue=" + nomRue + ", cp=" + cp
				+ ", ville=" + ville + "]";
	}
	
	

}
