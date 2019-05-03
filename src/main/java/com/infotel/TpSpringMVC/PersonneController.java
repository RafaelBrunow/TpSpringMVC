package com.infotel.TpSpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.TpSpringMVC.metier.Personne;
import com.infotel.TpSpringMVC.service.Iservice;

@Controller
public class PersonneController {
	
	@Autowired
    private Iservice service;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String lister(Model model) {
        model.addAttribute("personne", new Personne());
        model.addAttribute("personnes", service.listerPersonne());
        return "personnes";
    }

    @RequestMapping(value = "/savePersonne")
    public String save(Personne personne,  Model model) {
        if (personne.getIdpersonne() == 0) {
            service.ajouterPersonne(personne);
            model.addAttribute("personne", new Personne());
            model.addAttribute("personnes", service.listerPersonne());
            return "personnes";
        } else {
            String nom = personne.getNom();
			String prenom = personne.getPrenom();
			int age = personne.getAge();
			int idpersonne = personne.getIdpersonne();
			service.modifierPersonne(nom, prenom, age, idpersonne );
            model.addAttribute("personne", new Personne());
            model.addAttribute("personnes", service.listerPersonne());
            return "personnes";
        }
    }
    
    @RequestMapping(value = "/deletePersonne")
    public String delete(@RequestParam int idpersonne, Model model) {
        service.supprimerPersonne(idpersonne);
        model.addAttribute("personne", new Personne());
        model.addAttribute("personnes", service.listerPersonne());
        return "personnes";
    }

    @RequestMapping(value = "/editPersonne")
    public String edit(@RequestParam int idpersonne, Model model) {
        model.addAttribute("personne", service.getPersonne(idpersonne));
        model.addAttribute("personnes", service.listerPersonne());
        return "personnes";
    }

}
