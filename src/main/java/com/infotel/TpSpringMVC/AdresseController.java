package com.infotel.TpSpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.TpSpringMVC.metier.Adresse;
import com.infotel.TpSpringMVC.metier.Personne;
import com.infotel.TpSpringMVC.service.Iservice;

@Controller
public class AdresseController {
	
	@Autowired
    private Iservice service;

    @RequestMapping(value = "/indexAdresse", method = RequestMethod.GET)
    public String lister(Model model) {
        model.addAttribute("adresse", new Adresse());
        model.addAttribute("adresses", service.listerAdresse());
        return "adresses";
    }

    @RequestMapping(value = "/saveAdresse")
    public String save(Adresse adresse,  Model model) {
        if (adresse.getIdadresse() == 0) {
            service.ajouterAdresse(adresse);
            model.addAttribute("adresse", new Adresse());
            model.addAttribute("adresses", service.listerAdresse());
            return "adresses";
        } else {
        	String numRue = adresse.getNumRue();
            String nomRue = adresse.getNomRue();
			String cp = adresse.getCp();
			String ville = adresse.getVille();
			int idadresse = adresse.getIdadresse();
			service.modifierAdresse(numRue, nomRue, cp, ville, idadresse );
            model.addAttribute("adresse", new Adresse());
            model.addAttribute("adresses", service.listerAdresse());
            return "adresses";
        }
    }
    
    @RequestMapping(value = "/deleteAdresse")
    public String delete(@RequestParam int idadresse, Model model) {
        service.supprimerAdresse(idadresse);
        model.addAttribute("adresse", new Adresse());
        model.addAttribute("adresses", service.listerAdresse());
        return "adresses";
    }

    @RequestMapping(value = "/editAdresse")
    public String edit(@RequestParam int idadresse, Model model) {
        model.addAttribute("adresse", service.getAdresse1(idadresse));
        model.addAttribute("adresses", service.listerAdresse());
        return "adresses";
    }


}
