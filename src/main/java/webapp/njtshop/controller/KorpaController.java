/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import webapp.njtshop.domain.Artikal;
import webapp.njtshop.domain.Korpa;
import webapp.njtshop.domain.Profil;
import webapp.njtshop.domain.StavkaKorpe;
import webapp.njtshop.service.ArtikalService;
import webapp.njtshop.service.KorpaService;
import webapp.njtshop.service.ProfilService;
import webapp.njtshop.service.StavkaKorpeService;

/**
 *
 * @author Asus
 */
@Controller
@RequestMapping(value = "/korpa/*")
public class KorpaController {
    @Autowired
    ProfilService profilService;
    @Autowired
    KorpaService korpaService;
    @Autowired
    StavkaKorpeService stavkaKorpeService;
    @Autowired
    ArtikalService artikalService;
    
    // korpa koja se odnosi na trenutno ulogavnog
    Profil ulogovaniProfil;
    Korpa korpa;

    public Profil getUlogovaniProfil() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        ulogovaniProfil = profilService.getProfilByUsername(currentPrincipalName);
        return ulogovaniProfil;
    }
    
    public Korpa getKorpaUlogovanogKorisnika(){
        int korpaId = getUlogovaniProfil().getKorpa().getKorpaId();
        korpa = korpaService.getByID(korpaId);
        return korpa;        
    }
    @RequestMapping("/")
    public String korpaPrikaz(Model model){
        String username = getUlogovaniProfil().getUsername();
        model.addAttribute("username", username);
        model.addAttribute("korpa",getKorpaUlogovanogKorisnika());
        
        model.addAttribute("stavke", stavkaKorpeService.getStavke(korpa.getKorpaId()));
        
        return "korpa/korpa";
    }
    
    @RequestMapping(value = "/artikal/add/{artikalId}")
    public String dodajArtikalUKorpu(@PathVariable int artikalId, Model model, RedirectAttributes redirectAttributes){ 
        
        StavkaKorpe sk = stavkaKorpeService.getStavkaByArtikalAndKorpa(getKorpaUlogovanogKorisnika().getKorpaId(), artikalId);
        Artikal a = artikalService.getById(artikalId);
        
        if(sk == null){
            sk = new StavkaKorpe();
            sk.setArtikal(a);
            sk.setKolicina(1);
            sk.setUkupnaCenaStavke(a.getCenaSaPDV());
            sk.setKorpa(korpa);
            stavkaKorpeService.add(sk);
            korpa.getStavke().add(sk);
            korpa.setUkupnaCenaKorpe(korpa.getUkupnaCenaKorpe()+sk.getUkupnaCenaStavke());
            korpaService.addOrUpdate(korpa);
            redirectAttributes.addFlashAttribute("message", "Artikal uspesno dodat u korpu!");
            
            //model.addAttribute("message", "Artikal uspesno dodat u korpu!");
            
        }else {
            model.addAttribute("errorMessage", "Ovaj proizvod je vec dodat, pogledajte korpu!");
            return "error";
        
        }
        return "redirect:/korpa/";
        //return "korpa/korpa";
        
    }
    
    @RequestMapping(value = "/artikal/{artikalId}/add")
    public String povecajKolicinuStavke(@PathVariable("artikalId") int artikalId,
                                              Model model,
                                              RedirectAttributes redirectAttributes){
        ulogovaniProfil = getUlogovaniProfil();
        korpa= getKorpaUlogovanogKorisnika();
        

        StavkaKorpe sk = stavkaKorpeService.getStavkaByArtikalAndKorpa(korpa.getKorpaId(), artikalId);
        int index = korpa.getStavke().indexOf(sk);
        sk.setKolicina(sk.getKolicina()+1);
        sk.setUkupnaCenaStavke(sk.getArtikal().getCenaSaPDV()*sk.getKolicina());
        stavkaKorpeService.add(sk);
        
        korpa.getStavke().remove(index);
        korpa.getStavke().add(sk);
        korpa.izracunajUkupnuCenu();
        korpaService.addOrUpdate(korpa);
        redirectAttributes.addFlashAttribute("message", "Kolicina stavke uspesno povecana!");
        return "redirect:/korpa/";
    
    }
    
    @RequestMapping(value = "/artikal/{artikalId}/remove")
    public String smanjiKolicinuStavke(@PathVariable("artikalId") int artikalId,
                                              Model model,
                                              RedirectAttributes redirectAttributes){
        ulogovaniProfil = getUlogovaniProfil();
        korpa= getKorpaUlogovanogKorisnika();
        
        Artikal a = artikalService.getById(artikalId);

        StavkaKorpe sk = stavkaKorpeService.getStavkaByArtikalAndKorpa(korpa.getKorpaId(), artikalId);
        int index = korpa.getStavke().indexOf(sk);
        sk.setKolicina(sk.getKolicina()-1);
        sk.setUkupnaCenaStavke(sk.getArtikal().getCenaSaPDV()*sk.getKolicina());
        stavkaKorpeService.add(sk);
        
        korpa.getStavke().remove(index);
        korpa.getStavke().add(sk);
        korpa.izracunajUkupnuCenu();
        korpaService.addOrUpdate(korpa);
        redirectAttributes.addFlashAttribute("message", "Kolicina stavke uspesno smanjena!");
        //return "redirect:/korpa/";
        return "redirect:/korpa/";
    
    }
    
    @RequestMapping(value = "delete/stavka/{stavkaKorpeId}")
    public String obrisiStavku(@PathVariable("stavkaKorpeId") int stavkaId, 
                                Model model,
                                RedirectAttributes redirectAttributes){
        ulogovaniProfil = getUlogovaniProfil();
        korpa= getKorpaUlogovanogKorisnika();
        
        StavkaKorpe sk = stavkaKorpeService.getByID(stavkaId);
        
        korpa.getStavke().remove(sk);
        korpa.izracunajUkupnuCenu();
        stavkaKorpeService.deleteStavka(sk);
        korpaService.addOrUpdate(korpa);
        redirectAttributes.addFlashAttribute("message", "Stavka uspesno obrisana!");
        return "redirect:/korpa/";
    }
    
}
