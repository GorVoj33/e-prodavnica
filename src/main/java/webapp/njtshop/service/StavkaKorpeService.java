/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.service;

import java.util.List;
import webapp.njtshop.domain.StavkaKorpe;

/**
 *
 * @author Asus
 */
public interface StavkaKorpeService {
    List<StavkaKorpe> getStavke(int korpaId);
    StavkaKorpe getStavkaByArtikalAndKorpa(int korpaId, int artikalId);
    void add(StavkaKorpe stavkaKorpe);
    StavkaKorpe getByID(int stavkaId);
    void deleteStavka(StavkaKorpe stavkaKorpe);
}
