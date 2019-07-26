/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.service;

import java.util.List;
import webapp.njtshop.domain.Korpa;
import webapp.njtshop.domain.StavkaKorpe;

/**
 *
 * @author Asus
 */
public interface KorpaService {
    Korpa getByID(int korpaId);
    void addOrUpdate(Korpa korpa);
    
}
