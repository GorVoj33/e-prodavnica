/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import utility.FileUpload;
import webapp.njtshop.domain.Artikal;
import webapp.njtshop.domain.Kategorija;
import webapp.njtshop.domain.Narudzbenica;
import webapp.njtshop.domain.PoreskaStopa;
import webapp.njtshop.domain.StavkaNarudzbenice;
import webapp.njtshop.service.ArtikalService;
import webapp.njtshop.service.KategorijaService;
import webapp.njtshop.service.NarudzbenicaService;
import webapp.njtshop.service.PoreskaStopaService;
import webapp.njtshop.service.ProfilService;


/**
 *
 * @author Asus
 */
@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {
    @Autowired
    KategorijaService kategorijaService;
    
    @Autowired
    PoreskaStopaService poreskaStopaService;
    
    @Autowired
    ArtikalService artikalService;
    
    @Autowired
    ProfilService profilService;
    
    @Autowired
    NarudzbenicaService narudzbenicaService;
    
    @RequestMapping(value = "/pocetna")
    public String getAdminIndex(Model model, HttpServletRequest request){
        
        if(!request.isUserInRole("ROLE_ADMIN")){
            model.addAttribute("errorMessage", "Pristup ovoj strani imaju samo admini");
            return "error";
        }
        model.addAttribute("naziv", "Stranica za administraciju sajta");
        model.addAttribute("sviArtikli", artikalService.getAll());
        model.addAttribute("sviProfili", profilService.getAll());
        model.addAttribute("sveKategorije", kategorijaService.getAll());
        List<Narudzbenica> list = narudzbenicaService.getAll();
        for (Narudzbenica n : list){
            List<StavkaNarudzbenice> stavke = narudzbenicaService.getStavkeByNarudzbenicaID(n.getNarudzbenicaId());
            n.setStavke(stavke);
        }
        model.addAttribute("sveNarudzbenice", list);
        
                
        return "admin/adminStrana";
        
    }
    
    
    @RequestMapping(value = "/artikal/add")
    public String kreirajArtikalGET(Model model){
        
        //${pageContext["request"].userPrincipal.principal}
        
            model.addAttribute("artikal", new Artikal());
            model.addAttribute("kategorija", new Kategorija());
            model.addAttribute("nazivStrane", "Unos novog artikla");
            model.addAttribute("kategorije", kategorijaService.getAll());
            model.addAttribute("poreskeStope", poreskaStopaService.getAll());
            model.addAttribute("create", true);
            model.addAttribute("edit", false);
            return "artikal/form";
        
    }
    
    
    @RequestMapping(value = "/artikal/add", method = RequestMethod.POST)
    public String kreirajArtikalPOST(@Valid @ModelAttribute("artikal") Artikal artikal,
                             BindingResult result,
                             HttpServletRequest request,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("artikal", new Artikal());
            model.addAttribute("nazivStrane", "Unos novog artikla");
            model.addAttribute("kategorije", kategorijaService.getAll());
            model.addAttribute("poreskeStope", poreskaStopaService.getAll());
            return "artikal/form";
        }
        
        Kategorija izabranaKategorija = kategorijaService.getById(artikal.getKategorija().getKategorijaId());
        artikal.setKategorija(izabranaKategorija);
        PoreskaStopa izabranaPoreskaStopa = poreskaStopaService.getById(artikal.getPoreskaStopa().getId());
        artikal.setPoreskaStopa(izabranaPoreskaStopa);
        
        artikal.izracunajCenuSaPDV();
        
        artikalService.add(artikal);
        
        if(!artikal.getImage().getOriginalFilename().equals("")){
            FileUpload.uploadImage(request, artikal.getImage(), artikal.getArtikalId());
        }
        
        return "redirect:/artikal/all";
    }
    
    @RequestMapping(value = "/artikal/edit/{artikalId}")
    public String izmeniArtikalGET(@PathVariable(name = "artikalId") int artId, Model model){
        
        //${pageContext["request"].userPrincipal.principal}
            Artikal a = artikalService.getById(artId);
            
            model.addAttribute("artikal", a);
            model.addAttribute("kategorija", new Kategorija());
            model.addAttribute("nazivStrane", "Izmena postojeceg artikla");
            model.addAttribute("kategorije", kategorijaService.getAll());
            model.addAttribute("poreskeStope", poreskaStopaService.getAll());
            model.addAttribute("create", false);
            model.addAttribute("edit", true);
            return "artikal/form";
        
    }
    
    @RequestMapping(value = "/artikal/edit/{artikalId}", method = RequestMethod.POST)
    public String izmeniArtikalPOST(@Valid @ModelAttribute("artikal") Artikal artikal,
                             BindingResult result,
                             HttpServletRequest request,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("artikal", new Artikal());
            model.addAttribute("nazivStrane", "Izmena postojeceg artikla");
            model.addAttribute("kategorije", kategorijaService.getAll());
            model.addAttribute("poreskeStope", poreskaStopaService.getAll());
            return "artikal/form";
        }
        
        Kategorija izabranaKategorija = kategorijaService.getById(artikal.getKategorija().getKategorijaId());
        artikal.setKategorija(izabranaKategorija);
        PoreskaStopa izabranaPoreskaStopa = poreskaStopaService.getById(artikal.getPoreskaStopa().getId());
        artikal.setPoreskaStopa(izabranaPoreskaStopa);
        
        artikal.izracunajCenuSaPDV();
        
        artikalService.add(artikal);
        
        if(!artikal.getImage().getOriginalFilename().equals("")){
            FileUpload.uploadImage(request, artikal.getImage(), artikal.getArtikalId());
        }
        
        return "redirect:/admin/pocetna";
    }
    
    @RequestMapping(value = "/artikal/delete/{artikalId}")
    public String obrisiArtikal(@PathVariable(name = "artikalId") int artId, HttpServletRequest request){
        Artikal artikal = artikalService.getById(artId);
        artikal.setKategorija(null);
        artikal.setPoreskaStopa(null);
        FileUpload.deleteImage(request, artikal.getImage(), artikal.getArtikalId());
  
        artikalService.deleteArtikal(artikal);
        
        return "redirect:/artikal/all";
    }
    
    public void obrisiArtikal(Artikal a){
        Kategorija k = a.getKategorija();
        k.getArtikli().remove(a);
        
        PoreskaStopa ps = a.getPoreskaStopa();
        ps.getArtikli().remove(k);
        
        poreskaStopaService.add(ps);
        kategorijaService.add(k);
    }
    
    
    @RequestMapping("/kategorija/add")
    public String kreirajKategorijuGET(Model model){
        model.addAttribute("kategorija", new Kategorija());
        model.addAttribute("nazivStrane", "Unos nove kategorije");
        model.addAttribute("ostaleKategorije", kategorijaService.getAll());
        return "kategorija/form";
    }
    @RequestMapping(value="/kategorija/add", method = RequestMethod.POST)
    public String kreirajKategorijuPOST(@Valid @ModelAttribute(name = "kategorija") Kategorija kategorija,
                BindingResult result,
                Model model){
        if(result.hasErrors()){
            model.addAttribute("kategorija", new Kategorija());
            model.addAttribute("nazivStrane", "Unos nove kategorije");
            model.addAttribute("ostaleKategorije", kategorijaService.getAll());
            return "kategorija/form";
        }
        kategorijaService.add(kategorija);
        return "redirect:/admin/artikal/add";
    }
    
    
    @RequestMapping("/kategorija/delete/{kategorijaId}")
    public String obrisiKategoriju(@PathVariable int kategorijaId, Model model) {
        Kategorija k = kategorijaService.getById(kategorijaId);
        kategorijaService.delete(k);
        return "redirect:/admin/pocetna";
    }
}
