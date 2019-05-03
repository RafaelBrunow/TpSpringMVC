package com.infotel.TpSpringMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.TpSpringMVC.metier.Adresse;

@Transactional
public interface AdresseRepository extends JpaRepository<Adresse, Integer>{

	// Méthode pour modifier le nom d'une personne
	
		@Modifying
		@Query("update Adresse SET numRue = :w , nomRue = :x, cp = :y ,ville = :z where idadresse = :a")
		public int modifierAdresse(@Param("w") String numRue, @Param("x") String nomRue, @Param("y") String cp, @Param("z") String ville,@Param("a") int idadresse);
}
