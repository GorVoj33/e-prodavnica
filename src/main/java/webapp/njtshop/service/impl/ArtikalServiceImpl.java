/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.njtshop.dao.ArtikalDAO;
import webapp.njtshop.domain.Artikal;
import webapp.njtshop.service.ArtikalService;

/**
 *
 * @author Asus
 */
@Service
public class ArtikalServiceImpl implements ArtikalService{
    
    @Autowired
    ArtikalDAO artikalDAO;

    @Override
    public List<Artikal> getAll() {
        return artikalDAO.getAll();
    }

    @Override
    public Artikal getById(int id) {
        return artikalDAO.getById(id);
    }

    @Override
    public void add(Artikal artikal) {
        artikalDAO.add(artikal);
    }

    @Override
    public void deleteArtikal(Artikal artikal) {
        artikalDAO.deleteArtikal(artikal);
    }

    @Override
    public List<Artikal> pretraziPoDeluNazivu(String deoNaziva) {
        return artikalDAO.pretraziPoDeluNazivu(deoNaziva);

    }
    
}
