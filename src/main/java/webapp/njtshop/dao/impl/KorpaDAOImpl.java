/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webapp.njtshop.dao.KorpaDAO;
import webapp.njtshop.domain.Korpa;
import webapp.njtshop.domain.StavkaKorpe;

/**
 *
 * @author Asus
 */
@Repository
@Transactional
public class KorpaDAOImpl implements KorpaDAO{
    
    @Autowired
    SessionFactory sessionFactory;
   
    @Override
    public Korpa getByID(int korpaId) {
        Session session = sessionFactory.getCurrentSession();
        Korpa k = (Korpa)session.get(Korpa.class, korpaId);
        session.flush();
        return k;
    }

    @Override
    public void saveOrUpdate(Korpa korpa) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(korpa);
        session.flush();
    }

    
}
