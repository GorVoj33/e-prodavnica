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
import webapp.njtshop.dao.ProfilDAO;
import webapp.njtshop.domain.Authorities;
import webapp.njtshop.domain.Korpa;
import webapp.njtshop.domain.Profil;


/**
 *
 * @author Asus
 */
@Repository
@Transactional
public class ProfilDAOImpl implements ProfilDAO{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public void addProfil(Profil profil) {
        Session session = sessionFactory.getCurrentSession(); 
        
        profil.setEnabled(true);
        session.saveOrUpdate(profil); 
        // kako bi atribut adresaIsporuke imala refenrcu na profil kome je prethodno dodeljen ID
        profil.getAdresaIsporuke().setProfil(profil);
        session.saveOrUpdate(profil.getAdresaIsporuke());
        
//        RegisteredUsers user = new RegisteredUsers();
//        user.setProfilId(profil.getProfilId());
//        user.setUsername(profil.getUsername());
//        user.setEnabled(true);
//        user.setPassword(profil.getPassword());
        
        
        Authorities uloga = new Authorities();
        uloga.setUsername(profil.getUsername());
        uloga.setAutority("ROLE_USER");
        
//        session.saveOrUpdate(user);
        session.saveOrUpdate(uloga);

        Korpa korpa = new Korpa();
        korpa.setProfil(profil); 
        session.saveOrUpdate(korpa);
        
        profil.setKorpa(korpa); 
        session.saveOrUpdate(profil); 

        session.flush();
    }

    @Override
    public Profil getProfilByID(int profilId) {
        Session session = sessionFactory.getCurrentSession();
        return (Profil) session.get(Profil.class, profilId);
    }

    @Override
    public Profil getProfilByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Profil where username = ?");
        query.setString(0, username);
        return (Profil) query.uniqueResult();
        
    }

    @Override
    public List<Profil> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Profil");
        return query.list();
    }

    @Override
    public String getUloga(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Authorities a where a.username=?");
        query.setString(0, username);
        return (String) query.uniqueResult();
    }
    
}
