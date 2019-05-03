package com.infotel.TpSpringMVC.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.TpSpringMVC.metier.Adresse;
import com.infotel.TpSpringMVC.dao.AdresseRepository;
import com.infotel.TpSpringMVC.dao.PersonneRepository;
import com.infotel.TpSpringMVC.metier.Personne;
import com.infotel.TpSpringMVC.service.Iservice;


@Service ("service")
public class ServiceImpl implements Iservice {
		
		@Autowired
		private PersonneRepository personneRepository;
		
		@Autowired
		private AdresseRepository adresseRepository;

		

		public PersonneRepository getPersonneRepository() {
			return personneRepository;
		}

		public void setPersonneRepository(PersonneRepository personneRepository) {
			this.personneRepository = personneRepository;
		}

		@Override
		public Personne ajouterPersonne(Personne p) {
			// TODO Auto-generated method stub
			return personneRepository.save(p);
		}

		@Override
		public int modifierPersonne(String nom, String prenom, int age, int idpersonne) {
			// TODO Auto-generated method stub
			return personneRepository.modifierPersonne(nom, prenom, age, idpersonne);
		}

		@Override
		public void supprimerPersonne(int idpersonne) {
			// TODO Auto-generated method stub
			personneRepository.deleteById(idpersonne);
		}

		@Override
		public Iterable<Personne> listerPersonne() {
			// TODO Auto-generated method stub
			return personneRepository.findAll();
		}

		@Override
		public Optional<Personne> getPersonne(int idpersonne) {
			// TODO Auto-generated method stub
			return personneRepository.findById(idpersonne);
		}
		
		@Override
		public Adresse ajouterAdresse(Adresse a) {
			// TODO Auto-generated method stub
			return adresseRepository.save(a);
		}

		@Override
		public Adresse getAdresse(int idadresse) {
			// TODO Auto-generated method stub
			return adresseRepository.getOne(idadresse);
		}

		@Override
		public int modifierAdresse(String numRue, String nomRue, String cp, String ville, int idadresse) {
			// TODO Auto-generated method stub
			return adresseRepository.modifierAdresse(numRue, nomRue, cp, ville, idadresse);
		}

		@Override
		public void supprimerAdresse(int idadresse) {
			// TODO Auto-generated method stub
			adresseRepository.deleteById(idadresse);
		}

		@Override
		public Iterable<Adresse> listerAdresse() {
			// TODO Auto-generated method stub
			return adresseRepository.findAll();
		}

		@Override
		public void lierAdressePersonne(Adresse adresse, int idpersonne) {
			// TODO Auto-generated method stub
			personneRepository.lierAdressePersonne(adresse, idpersonne);
		}

		@Override
		public Optional<Adresse> getAdresse1(int idadresse) {
			// TODO Auto-generated method stub
			return adresseRepository.findById(idadresse);
		}
}
