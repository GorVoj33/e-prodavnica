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
import webapp.njtshop.dao.StavkaKorpeDAO;
import webapp.njtshop.domain.StavkaKorpe;

/**
 *
 * @author Asus
 */
@Repository
@Transactional
public class StavkaKorpeDAOImpl implements StavkaKorpeDAO{
    @Autowired
    SessionFactory sessionFactory;
    
    
    @Override
    public List<StavkaKorpe> getStavke(int korpaId) {
        Session session = sessionFactory.getCurrentSession();
        String q = "from StavkaKorpe where korpa_id = :korpa_id";
        Query query = session.createQuery(q);   
        query.setParameter("korpa_id", korpaId);
        List<StavkaKorpe> stavke = query.list();
        session.flush();
        return stavke;
    }

    @Override
    public StavkaKorpe getStavkaByArtikalAndKorpa(int korpaId, int artikalId) {
        Session session = sessionFactory.getCurrentSession();
        String q = "from StavkaKorpe where korpa_id = :korpa_id and artikal_id = :art_id";
        Query query = session.createQuery(q);   
        query.setParameter("korpa_id", korpaId);
        query.setParameter("art_id", artikalId);
        StavkaKorpe sk = (StavkaKorpe)query.uniqueResult();
        session.flush();
        return sk;
    }

    @Override
    public void add(StavkaKorpe stavkaKorpe) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(stavkaKorpe);
        session.flush();
    }

    @Override
    public StavkaKorpe getByID(int stavkaId) {
        Session session = sessionFactory.getCurrentSession();
        StavkaKorpe sk = (StavkaKorpe) session.get(StavkaKorpe.class, stavkaId);
        session.flush();
        return sk;
    }

    @Override
    public void deleteStavka(StavkaKorpe stavkaKorpe) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(stavkaKorpe);
        session.flush();
    }
}
