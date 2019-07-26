package webapp.njtshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import webapp.njtshop.domain.AdresaIsporuke;
import webapp.njtshop.domain.Profil;
import webapp.njtshop.service.ProfilService;

/**
 * @author Asus
 */
@Controller
public class RegisterController {

    @Autowired
    private ProfilService profilService;

    @RequestMapping("/register")
    public String registracijaGET(Model model) {
        Profil profil = new Profil();
        
        AdresaIsporuke adresaIsporuke = new AdresaIsporuke();

        profil.setAdresaIsporuke(adresaIsporuke);

        model.addAttribute("profil", profil);

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registracijaPOST(@Valid @ModelAttribute("profil") Profil profil,
                                       BindingResult result,
                                       Model model,
                                       Integer offset, Integer maxResults) {

        if (result.hasErrors()) {
            return "register";
        }

        List<Profil> profils = profilService.getAll();
        for (int i=0; i< profils.size(); i++) {

            if (profil.getUsername().equals(profils.get(i).getUsername())) {
                model.addAttribute("usernameMsg", "Username: "+profil.getUsername()+ " je zauzet.");
                return "register";
            }
        }

        profil.setEnabled(true);
        
        profil.getAdresaIsporuke().setProfil(profil);

        profilService.addProfil(profil);

        model.addAttribute("userRegistered", "Registracija uspesna, ulogujte se.");
        return "login";
    }
}
