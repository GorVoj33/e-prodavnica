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
import webapp.njtshop.dao.NarudzbenicaDAO;
import webapp.njtshop.domain.Narudzbenica;
import webapp.njtshop.domain.StavkaNarudzbenice;

/**
 *
 * @author Asus
 */
@Repository
@Transactional
public class NarudzbenicaDAOImpl implements NarudzbenicaDAO{
    @Autowired
    SessionFactory sessionFactory;
    
    
    @Override
    public void add(Narudzbenica narudzbenica) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(narudzbenica);
        session.flush();
    }

    @Override
    public void addStavka(StavkaNarudzbenice stavkaNarudzbenice) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(stavkaNarudzbenice);
        session.flush();
    }

    @Override
    public List<StavkaNarudzbenice> getStavkeByNarudzbenicaID(int narudzbenicaId) {
        Session session = sessionFactory.getCurrentSession();
        //Query query = session.createQuery("from StavkaNarudzbenice where narudzbenica_id = :narudzbenicaId");
        //query.setParameter("narudzbenicaId", narudzbenicaId);
        Query query = session.createQuery("from StavkaNarudzbenice where narudzbenica_id = ?");
        query.setInteger(0, narudzbenicaId);
        List<StavkaNarudzbenice> list = query.list();
        session.flush();
        return list;
    }

    @Override
    public List<Narudzbenica> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Narudzbenica");
        return query.list();

    }

    @Override
    public Narudzbenica getById(int narId) {
        Session session = sessionFactory.getCurrentSession();
        Narudzbenica n = (Narudzbenica) session.get(Narudzbenica.class, narId);
        List<StavkaNarudzbenice> stavke = getStavkeByNarudzbenicaID(narId);
        n.setStavke(stavke);
        return n;
    }

    @Override
    public List<Narudzbenica> getAllByProfileId(int profilId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Narudzbenica where profil_id=?");
        query.setInteger(0, profilId);
        List<Narudzbenica> list = query.list();
        for(Narudzbenica n : list){
            List<StavkaNarudzbenice> stavke = getStavkeByNarudzbenicaID(n.getNarudzbenicaId());
            n.setStavke(stavke);
        } 
        session.flush();
        return list;
    }
    
}
