/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.service;

import java.util.List;
import webapp.njtshop.domain.Profil;

/**
 *
 * @author Asus
 */
public interface ProfilService {
    void addProfil(Profil profil);
    Profil getProfilByID(int profilId);
    Profil getProfilByUsername(String username);
    List<Profil> getAll();
    String getUloga(String username);
    
}
