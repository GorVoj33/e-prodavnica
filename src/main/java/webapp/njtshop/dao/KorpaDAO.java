/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import webapp.njtshop.domain.Korpa;
import webapp.njtshop.domain.StavkaKorpe;

/**
 *
 * @author Asus
 */
public interface KorpaDAO {
    Korpa getByID(int korpaId);
    void saveOrUpdate(Korpa korpa);
}
