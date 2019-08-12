/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.dao;

import java.util.List;
import webapp.njtshop.domain.Narudzbenica;
import webapp.njtshop.domain.StavkaNarudzbenice;

/**
 *
 * @author Asus
 */
public interface NarudzbenicaDAO {
    void add(Narudzbenica narudzbenica);
    void addStavka(StavkaNarudzbenice stavkaNarudzbenice);
    List<StavkaNarudzbenice> getStavkeByNarudzbenicaID(int narudzbenicaId);
    List<Narudzbenica> getAll();
    Narudzbenica getById(int narId);
    List<Narudzbenica> getAllByProfileId(int profilId);
}
