/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.njtshop.dao.ProfilDAO;
import webapp.njtshop.domain.Profil;
import webapp.njtshop.service.ProfilService;

/**
 *
 * @author Asus
 */
@Service
public class ProfilServiceImpl implements ProfilService{
    
    @Autowired 
    ProfilDAO profilDAO;
    
    @Override
    public void addProfil(Profil profil) {
        profilDAO.addProfil(profil);
    }

    @Override
    public Profil getProfilByID(int profilId) {
        return profilDAO.getProfilByID(profilId);
    }

    @Override
    public Profil getProfilByUsername(String username) {
        return profilDAO.getProfilByUsername(username);
    }

    @Override
    public List<Profil> getAll() {
        return profilDAO.getAll();
    }

    @Override
    public String getUloga(String username) {
        return profilDAO.getUloga(username);
    }
    
}
