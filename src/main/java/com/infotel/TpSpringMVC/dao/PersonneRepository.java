package com.infotel.TpSpringMVC.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.TpSpringMVC.metier.Adresse;
import com.infotel.TpSpringMVC.metier.Personne;


@Transactional
public interface PersonneRepository extends JpaRepository<Personne, Integer>{
	
	public List<Personne> findByPrenom(String x);
	public List<Personne> findByPrenomContaining(String x);
	
	@Query("select p from Personne p where p.nom like :x")
	public List<Personne> rechercherParMC(@Param("x")String nom);
	
	// Liste des mots clés permettant de créer des méthodes semblables aux deux précédents : 
	// https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
	
	// Méthode pour modifier le nom d'une personne
	
	@Modifying
	@Query("UPDATE Personne SET nom = :x ,prenom = :y ,age = :z  where idPersonne= :c ")
	public int modifierPersonne(@Param("x")String nom, @Param("y")String prenom, @Param("z")int age , @Param("c")int idPersonne);
	
	@Modifying
	@Query("UPDATE Personne SET adresse = :x WHERE idpersonne = :y")
	public void lierAdressePersonne(@Param("x")Adresse adresse, @Param("y")int idpersonne);
		
		
}
