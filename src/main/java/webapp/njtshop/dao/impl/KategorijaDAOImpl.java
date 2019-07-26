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
import webapp.njtshop.dao.KategorijaDAO;
import webapp.njtshop.domain.Kategorija;

/**
 *
 * @author Asus
 */
@Repository
@Transactional
public class KategorijaDAOImpl implements KategorijaDAO{
    @Autowired
    SessionFactory sessionFactory;
    
    
    @Override
    public List<Kategorija> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Kategorija");
        List<Kategorija> list = query.list();
        session.flush();
        return list;
    }

    @Override
    public void add(Kategorija kategorija) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(kategorija);
        session.flush();
    }

    @Override
    public Kategorija getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Kategorija) session.get(Kategorija.class, id);
    }

    @Override
    public Kategorija getByNaziv(String naziv) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Kategorija where naziv = ?");
        query.setString(0, naziv);
        return (Kategorija) query.uniqueResult();
    }

    @Override
    public void delete(Kategorija kategorija) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(kategorija);
        session.flush();
    }

}
