/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import webapp.njtshop.dao.PoreskaStopaDAO;
import webapp.njtshop.domain.PoreskaStopa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Asus
 */
@Repository
@Transactional
public class PoreskaStopaDAOImpl implements PoreskaStopaDAO{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public List<PoreskaStopa> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from PoreskaStopa").list();
    }
    
    @Override
    public PoreskaStopa getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (PoreskaStopa) session.get(PoreskaStopa.class, id);
    }

    @Override
    public void add(PoreskaStopa poreskaStopa) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(poreskaStopa);
        session.flush();
    }
    
}
