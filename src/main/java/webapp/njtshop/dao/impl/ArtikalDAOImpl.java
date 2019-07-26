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
import webapp.njtshop.dao.ArtikalDAO;
import webapp.njtshop.domain.Artikal;

/**
 *
 * @author Asus
 */
@Repository
@Transactional
public class ArtikalDAOImpl implements ArtikalDAO{
    
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public List<Artikal> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Artikal> list = session.createQuery("from Artikal order by cenaSaPDV").list();
        session.flush();
        return list;
    }

    @Override
    public Artikal getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Artikal a = (Artikal) session.get(Artikal.class, id);
        session.flush();
        return a;
    }

    @Override
    public void add(Artikal artikal) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(artikal);   
        session.flush();
    }

    @Override
    public void deleteArtikal(Artikal artikal) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(artikal);
        session.flush();
    }

    @Override
    public List<Artikal> pretraziPoDeluNazivu(String deoNaziva) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Artikal as a where a.naziv like ? order by a.cenaSaPDV");
        query.setString(0, "%"+deoNaziva+"%");
        List<Artikal> list = query.list();
        session.flush();
        return list;
    }
    
}
