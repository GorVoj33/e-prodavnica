/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.controller;

import webapp.njtshop.domain.StavkaNarudzbenice;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import webapp.njtshop.domain.AdresaIsporuke;
import webapp.njtshop.domain.Artikal;
import webapp.njtshop.domain.Korpa;
import webapp.njtshop.domain.Narudzbenica;
import webapp.njtshop.domain.Profil;
import webapp.njtshop.domain.StavkaKorpe;
import webapp.njtshop.service.ArtikalService;
import webapp.njtshop.service.KorpaService;
import webapp.njtshop.service.NarudzbenicaService;
import webapp.njtshop.service.ProfilService;
import webapp.njtshop.service.StavkaKorpeService;
/**
 *
 * @author Asus
 */
@Controller
@RequestMapping(value = "/narudzbenica/*")
public class NarudzbenicaController {
    @Autowired
    KorpaService korpaService;
    
    @Autowired 
    ProfilService profilService;
    
    @Autowired
    NarudzbenicaService narudzbenicaService;
    
    @Autowired
    StavkaKorpeService stavkaKorpeService;
    
    @Autowired
    ArtikalService artikalService;
    
    @RequestMapping(value= "kreiraj/{korpaId}")
    public String kreirajNarudzbenicu(@PathVariable("korpaId") int korpaId, Model model){
        Korpa korpa = korpaService.getByID(korpaId);
        Profil profil = korpa.getProfil();
        AdresaIsporuke adresaIsporuke = profil.getAdresaIsporuke();
        AdresaIsporuke adresa = new AdresaIsporuke();
        Narudzbenica narudzbenica = new Narudzbenica();
        narudzbenica.setAdresaIsporuke(adresaIsporuke);
        narudzbenica.setProfil(profil);
        narudzbenica.setKorpa(korpa);
         
        narudzbenica.setDatum(new Date());
        String datum = formatDate(narudzbenica.getDatum());
        model.addAttribute("narudzbenica", narudzbenica);
        model.addAttribute("adresaFORM", adresaIsporuke);
        model.addAttribute("datum", datum);
        
        return "narudzbenica";
    }
    
    @RequestMapping(value= "kreiraj/{korpaId}", method = RequestMethod.POST)
    public String potvrdiAdresuNarudzbenice(@PathVariable("korpaId") int korpaId,
                                    @Valid @ModelAttribute("adresaFORM") AdresaIsporuke adresaFORM,
                                    BindingResult result,
                                    Model model){
        
        Korpa korpa = korpaService.getByID(korpaId);
        Profil profil = korpa.getProfil();
        AdresaIsporuke adresaIsporuke = profil.getAdresaIsporuke();
        Narudzbenica narudzbenica = new Narudzbenica();
        narudzbenica.setAdresaIsporuke(adresaIsporuke);
        narudzbenica.setProfil(profil);
        narudzbenica.setKorpa(korpa);
        narudzbenica.setDatum(new Date());
        String datum = formatDate(narudzbenica.getDatum());
        model.addAttribute("narudzbenica", narudzbenica);
        model.addAttribute("adresaFORM", adresaIsporuke);
        model.addAttribute("datum", datum);
        if(result.hasErrors()){
            return "narudzbenica";
        }
        adresaFORM.setProfil(profil);
        
        profil.setAdresaIsporuke(adresaFORM);
        profilService.addProfil(profil);

        
        model.addAttribute("narudzbenica", narudzbenica);
        model.addAttribute("adresaFORM", adresaFORM);

        return "redirect:/narudzbenica/kreiraj/" + korpa.getKorpaId();
    }

    @RequestMapping(value = "new/{korpaId}/potvrdi")
    public String zavrsiKupovinu(@PathVariable("korpaId") int korpaId,
                        Model model){
        Korpa korpa = korpaService.getByID(korpaId);
        Profil profil = korpa.getProfil();
        AdresaIsporuke adresaIsporuke = profil.getAdresaIsporuke();
        Narudzbenica narudzbenica = new Narudzbenica();
        narudzbenica.setAdresaIsporuke(adresaIsporuke);
        narudzbenica.setProfil(profil);
        narudzbenica.setKorpa(korpa);
        narudzbenica.setDatum(new Date());
        narudzbenica.setUkupno(korpa.getUkupnaCenaKorpe());
        narudzbenicaService.add(narudzbenica);
        sacuvajStavkeNarudzbenice(narudzbenica, korpa);
//        narudzbenicaService.add(narudzbenica);
        List<StavkaNarudzbenice> stavke = narudzbenicaService.getStavkeByNarudzbenicaID(narudzbenica.getNarudzbenicaId());
        narudzbenica.setStavke(stavke);
        model.addAttribute("narudzbenica", narudzbenica);
        
        smanjiKolicinuProdatihArtikala(korpa);
        
        
        korpa.setUkupnaCenaKorpe(0);
        korpaService.addOrUpdate(korpa);
        ocistiKorpu(korpa);

        return "uspesnoPoruceno";
    }
    
    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(date);
    }

    private void sacuvajStavkeNarudzbenice(Narudzbenica narudzbenica, Korpa korpa) {
        for (StavkaKorpe sk : korpa.getStavke()){
//            StavkaNarudzbenice sn = new Sta
            StavkaNarudzbenice stavka = new StavkaNarudzbenice();
            stavka.setNarudzbenica(narudzbenica);
            stavka.setArtikal(sk.getArtikal());
            stavka.setKolicina(sk.getKolicina());
            stavka.setUkupnaCenaStavke(sk.getUkupnaCenaStavke());
            narudzbenicaService.addStavka(stavka);
//            narudzbenica.getStavke().add(stavka);
            
        }
    }

    private void ocistiKorpu(Korpa korpa) {
        // brisemo sve stavke iz korpe posto su ti artikli uspesno uneti u naruceni
        for (int i =0; i < korpa.getStavke().size(); i++){
            StavkaKorpe sk = korpa.getStavke().get(i);
            stavkaKorpeService.deleteStavka(sk);
        }
  
    }

    private void smanjiKolicinuProdatihArtikala(Korpa korpa) {
        // prolazimo kroz artikle koju su poruceni i smanjujemo preostalu kolicinu koja je dostupna
        for (StavkaKorpe sk : korpa.getStavke()){
            Artikal a = artikalService.getById(sk.getArtikal().getArtikalId());
            a.setKolicinaZaProdaju(a.getKolicinaZaProdaju() - sk.getKolicina());
            artikalService.add(a);
        }
    }
    
    
}
