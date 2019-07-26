/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Asus
 */
@Entity
public class StavkaKorpe {
    @Id
    @GeneratedValue
    private int stavkaKorpeId;

    @ManyToOne
    @JoinColumn(name = "korpa_id") 
    @JsonIgnore
    private Korpa korpa;

    @ManyToOne
    @JoinColumn(name = "artikal_id")
    private Artikal artikal;

    private int kolicina;
    
    private double ukupnaCenaStavke;

    public StavkaKorpe() {
    }

    public StavkaKorpe(int stavkaKorpeId, Korpa korpa, Artikal artikal, int kolicina, double ukupnaCenaStavke) {
        this.stavkaKorpeId = stavkaKorpeId;
        this.korpa = korpa;
        this.artikal = artikal;
        this.kolicina = kolicina;
        this.ukupnaCenaStavke = ukupnaCenaStavke;
    }

    public int getStavkaKorpeId() {
        return stavkaKorpeId;
    }

    public void setStavkaKorpeId(int stavkaKorpeId) {
        this.stavkaKorpeId = stavkaKorpeId;
    }

    public Korpa getKorpa() {
        return korpa;
    }

    public void setKorpa(Korpa korpa) {
        this.korpa = korpa;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getUkupnaCenaStavke() {
        return ukupnaCenaStavke;
    }

    public void setUkupnaCenaStavke(double ukupnaCenaStavke) {
        this.ukupnaCenaStavke = ukupnaCenaStavke;
    }

    @Override
    public boolean equals(Object o) {

        StavkaKorpe st = (StavkaKorpe) o;
        return this.getStavkaKorpeId() == st.getStavkaKorpeId() 
                && this.getKorpa().getKorpaId()== st.getKorpa().getKorpaId();
    }
    
    
}
