/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Asus
 */
@Entity
public class Korpa {
    @Id
    @GeneratedValue
    private int korpaId;

    @OneToMany(mappedBy = "korpa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<StavkaKorpe> stavke=new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "profil_id")
    @JsonIgnore
    private Profil profil;

    private double ukupnaCenaKorpe;

    public Korpa() {
    }

    public Korpa(int korpaId, List<StavkaKorpe> stavke, Profil profil, double ukupnaCenaKorpe) {
        this.korpaId = korpaId;
        this.stavke = stavke;
        this.profil = profil;
        this.ukupnaCenaKorpe = ukupnaCenaKorpe;
    }

    public int getKorpaId() {
        return korpaId;
    }

    public void setKorpaId(int korpaId) {
        this.korpaId = korpaId;
    }

    public List<StavkaKorpe> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaKorpe> stavke) {
        this.stavke = stavke;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public double getUkupnaCenaKorpe() {
        return ukupnaCenaKorpe;
    }

    public void setUkupnaCenaKorpe(double ukupnaCenaKorpe) {
        this.ukupnaCenaKorpe = ukupnaCenaKorpe;
    }
    
    public void izracunajUkupnuCenu(){
        int suma = 0;
        for (StavkaKorpe sk: stavke){
            suma += sk.getUkupnaCenaStavke();
        }
        ukupnaCenaKorpe = suma;
    }
    
    
}
