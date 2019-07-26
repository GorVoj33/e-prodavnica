/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.dao;

import java.util.List;
import webapp.njtshop.domain.Artikal;

/**
 *
 * @author Asus
 */
public interface ArtikalDAO {
    List<Artikal> getAll();
    Artikal getById(int id);
    void add(Artikal artikal);
    void deleteArtikal(Artikal artikal);
    List<Artikal> pretraziPoDeluNazivu(String deoNaziva);
}
