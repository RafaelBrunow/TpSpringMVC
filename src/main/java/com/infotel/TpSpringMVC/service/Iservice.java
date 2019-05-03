package com.infotel.TpSpringMVC.service;

import java.util.Optional;

import com.infotel.TpSpringMVC.metier.Adresse;
import com.infotel.TpSpringMVC.metier.Personne;

public interface Iservice {

	public Personne ajouterPersonne(Personne p);
	public Optional<Personne> getPersonne(int idpersonne);
	public int modifierPersonne(String nom, String prenom, int age, int idpersonne);
	public void supprimerPersonne(int idpersonne);
	public Iterable<Personne> listerPersonne();
	
	public void lierAdressePersonne(Adresse adresse, int idpersonne);
	
	
	public Adresse ajouterAdresse(Adresse a);
	public Optional<Adresse> getAdresse1(int idadresse);
	public Adresse getAdresse(int idadresse);
	public int modifierAdresse(String numRue, String nomRue, String cp, String ville, int idadresse);
	public void supprimerAdresse(int idadresse);
	public Iterable<Adresse> listerAdresse();
}
