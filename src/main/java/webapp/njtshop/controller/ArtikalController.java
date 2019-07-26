/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import webapp.njtshop.domain.Artikal;
import webapp.njtshop.domain.Kategorija;
import webapp.njtshop.service.ArtikalService;
import webapp.njtshop.service.KategorijaService;

/**
 *
 * @author Asus
 */
@Controller
public class ArtikalController {
    @Autowired
    ArtikalService artikalService;
    
    @Autowired
    KategorijaService kategorijaService;
    
    @RequestMapping(value = "/artikal/all")
    public String all(Model model){
        model.addAttribute("nazivStrane", "Svi artikli iz naseg asortimana");
        model.addAttribute("artikli", artikalService.getAll());
        return "artikal/all";
    }
    
    @RequestMapping(value = "/artikal/pretrazi", method = RequestMethod.GET)
    public String pretraga(Model model, @RequestParam(value = "deoNaziva", required = false) String deoNaziva){
        model.addAttribute("nazivStrane", "Svi artikli iz naseg asortimana po kriterijumu: " + deoNaziva);
        model.addAttribute("artikli", artikalService.pretraziPoDeluNazivu(deoNaziva));
        return "artikal/all";
    }
    
    @RequestMapping(value = "/artikal/all/{kategorijaId}")
    public String allByKategorija(@PathVariable int kategorijaId, Model model){
        Kategorija k = kategorijaService.getById(kategorijaId);
        
        model.addAttribute("nazivStrane",   ("Svi artikli iz kategorije "+k.getNaziv()) );
        
        model.addAttribute("artikli", k.getArtikli());
        
        return "artikal/all";
    }
    @RequestMapping(value = "/artikal/{artikalId}")
    public String viewArtikal(@PathVariable int artikalId, Model model){
        Artikal artikal = artikalService.getById(artikalId);
        model.addAttribute("artikal", artikal);
        return "artikal/detail";
    }
}
