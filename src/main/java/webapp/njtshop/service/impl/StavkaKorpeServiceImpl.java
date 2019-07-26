/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.njtshop.dao.KorpaDAO;
import webapp.njtshop.dao.StavkaKorpeDAO;
import webapp.njtshop.domain.StavkaKorpe;
import webapp.njtshop.service.StavkaKorpeService;

/**
 *
 * @author Asus
 */

@Service
public class StavkaKorpeServiceImpl implements StavkaKorpeService{
    @Autowired
    StavkaKorpeDAO stavkaKorpeDAO;
    
    
    @Override
    public List<StavkaKorpe> getStavke(int korpaId) {
        return stavkaKorpeDAO.getStavke(korpaId);
    }

    @Override
    public StavkaKorpe getStavkaByArtikalAndKorpa(int korpaId, int artikalId) {
        return stavkaKorpeDAO.getStavkaByArtikalAndKorpa(korpaId, artikalId);
    }

    @Override
    public void add(StavkaKorpe stavkaKorpe) {
        stavkaKorpeDAO.add(stavkaKorpe);
    }

    @Override
    public StavkaKorpe getByID(int stavkaId) {
        return stavkaKorpeDAO.getByID(stavkaId);
    }

    @Override
    public void deleteStavka(StavkaKorpe stavkaKorpe) {
        stavkaKorpeDAO.deleteStavka(stavkaKorpe);
    }
}
