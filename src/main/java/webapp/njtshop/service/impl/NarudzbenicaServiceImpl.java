/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.njtshop.dao.NarudzbenicaDAO;
import webapp.njtshop.domain.Narudzbenica;
import webapp.njtshop.domain.StavkaNarudzbenice;
import webapp.njtshop.service.NarudzbenicaService;

/**
 *
 * @author Asus
 */
@Service
public class NarudzbenicaServiceImpl implements NarudzbenicaService{
    @Autowired
    NarudzbenicaDAO narudzbenicaDAO;
    
    
    @Override
    public void add(Narudzbenica narudzbenica) {
        narudzbenicaDAO.add(narudzbenica);
    }

    @Override
    public void addStavka(StavkaNarudzbenice stavkaNarudzbenice) {
        narudzbenicaDAO.addStavka(stavkaNarudzbenice);
    }

    @Override
    public List<StavkaNarudzbenice> getStavkeByNarudzbenicaID(int narudzbenicaId) {
        return narudzbenicaDAO.getStavkeByNarudzbenicaID(narudzbenicaId);
    }

    @Override
    public List<Narudzbenica> getAll() {
        return narudzbenicaDAO.getAll();
    }

    @Override
    public Narudzbenica getById(int narId) {
        return narudzbenicaDAO.getById(narId);
    }

    @Override
    public List<Narudzbenica> getAllByProfileId(int profilId) {
        return narudzbenicaDAO.getAllByProfileId(profilId);
    }
    
}
