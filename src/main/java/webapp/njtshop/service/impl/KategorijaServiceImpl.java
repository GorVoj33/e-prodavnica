/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.njtshop.dao.KategorijaDAO;
import webapp.njtshop.domain.Kategorija;
import webapp.njtshop.service.KategorijaService;

/**
 *
 * @author Asus
 */
@Service
public class KategorijaServiceImpl implements KategorijaService{

    @Autowired
    KategorijaDAO kategorijaDAO;
    
    @Override
    public List<Kategorija> getAll() {
        return kategorijaDAO.getAll();
    }

    @Override
    public void add(Kategorija kategorija) {
        kategorijaDAO.add(kategorija);
    }

    @Override
    public Kategorija getById(int id) {
        return kategorijaDAO.getById(id);
    }

    @Override
    public Kategorija getByNaziv(String naziv) {
        return kategorijaDAO.getByNaziv(naziv);
    }

    @Override
    public void delete(Kategorija kategorija) {
        kategorijaDAO.delete(kategorija);
    }
    
}
