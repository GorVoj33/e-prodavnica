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
import webapp.njtshop.domain.Korpa;
import webapp.njtshop.domain.StavkaKorpe;
import webapp.njtshop.service.KorpaService;

/**
 *
 * @author Asus
 */
@Service
public class KorpaServiceImpl implements KorpaService{
    
    @Autowired
    KorpaDAO korpaDAO;
    
    @Override
    public Korpa getByID(int korpaId) {
        return korpaDAO.getByID(korpaId);
    }

    @Override
    public void addOrUpdate(Korpa korpa) {
        korpaDAO.saveOrUpdate(korpa);
    }

    
    
}
