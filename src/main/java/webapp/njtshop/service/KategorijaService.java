/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.service;

import java.util.List;
import webapp.njtshop.domain.Kategorija;

/**
 *
 * @author Asus
 */
public interface KategorijaService {
    List<Kategorija> getAll();
    void add(Kategorija kategorija);
    Kategorija getById(int id);
    Kategorija getByNaziv(String naziv);
    void delete(Kategorija kategorija);
}
