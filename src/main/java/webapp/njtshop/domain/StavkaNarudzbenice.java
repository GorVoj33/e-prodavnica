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
import javax.persistence.Table;
import webapp.njtshop.domain.Artikal;
import webapp.njtshop.domain.Artikal;
import webapp.njtshop.domain.Narudzbenica;
import webapp.njtshop.domain.Narudzbenica;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "stavka_narudzbenice")
public class StavkaNarudzbenice {
    @Id
    @GeneratedValue
    private int stavkaNarudzbeniceId;

    @ManyToOne
    @JoinColumn(name = "narudzbenica_id") 
    @JsonIgnore
    private Narudzbenica narudzbenica;

    @ManyToOne
    @JoinColumn(name = "artikal_id")
    private Artikal artikal;

    private int kolicina;
    
    private double ukupnaCenaStavke;

    public StavkaNarudzbenice() {
    }

    public StavkaNarudzbenice(int stavkaNarudzbeniceId, Narudzbenica narudzbenica, Artikal artikal, int kolicina, double ukupnaCenaStavke) {
        this.stavkaNarudzbeniceId = stavkaNarudzbeniceId;
        this.narudzbenica = narudzbenica;
        this.artikal = artikal;
        this.kolicina = kolicina;
        this.ukupnaCenaStavke = ukupnaCenaStavke;
    }

    public int getStavkaNarudzbeniceId() {
        return stavkaNarudzbeniceId;
    }

    public void setStavkaNarudzbeniceId(int stavkaNarudzbeniceId) {
        this.stavkaNarudzbeniceId = stavkaNarudzbeniceId;
    }

    public Narudzbenica getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(Narudzbenica narudzbenica) {
        this.narudzbenica = narudzbenica;
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
    
    
}
