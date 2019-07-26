/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.service;

import java.util.List;
import webapp.njtshop.domain.PoreskaStopa;

/**
 *
 * @author Asus
 */
public interface PoreskaStopaService {
    List<PoreskaStopa> getAll();
    PoreskaStopa getById(int id);
    void add(PoreskaStopa poreskaStopa);
}
