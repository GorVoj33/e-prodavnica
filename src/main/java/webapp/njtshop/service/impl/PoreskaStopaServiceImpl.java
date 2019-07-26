/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.service.impl;

import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.njtshop.dao.PoreskaStopaDAO;
import webapp.njtshop.domain.PoreskaStopa;
import webapp.njtshop.service.PoreskaStopaService;


/**
 *
 * @author Asus
 */
@Service
public class PoreskaStopaServiceImpl implements PoreskaStopaService{

    @Autowired
    PoreskaStopaDAO poreskaStopaDAO;
    
    @Override
    public List<PoreskaStopa> getAll() {
        return poreskaStopaDAO.getAll();
    }

    @Override
    public PoreskaStopa getById(int id) {
        return poreskaStopaDAO.getById(id);
    }

    @Override
    public void add(PoreskaStopa poreskaStopa) {
        poreskaStopaDAO.add(poreskaStopa);
    }
    
}
