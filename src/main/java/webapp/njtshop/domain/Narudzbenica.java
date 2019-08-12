/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Asus
 */
@Entity
public class Narudzbenica {
    @Id
    @GeneratedValue
    private int narudzbenicaId;

    @OneToOne
    @JoinColumn(name = "korpa_id")
    private Korpa korpa;

    @OneToOne
    @JoinColumn(name = "profil_id")
    private Profil profil;

    @OneToOne
    @JoinColumn(name = "adresa_id")
    private AdresaIsporuke adresaIsporuke;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "datum_kreiranja")
    private Date datum;

    @OneToMany(mappedBy = "narudzbenica", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StavkaNarudzbenice> stavke=new ArrayList<>();
      
    private double ukupno;
    
    public Narudzbenica() {
    }

    public Narudzbenica(int narudzbenicaId, Korpa korpa, Profil profil, AdresaIsporuke adresaIsporuke, Date datum) {
        this.narudzbenicaId = narudzbenicaId;
        this.korpa = korpa;
        this.profil = profil;
        this.adresaIsporuke = adresaIsporuke;
        this.datum = datum;
    }

    public int getNarudzbenicaId() {
        return narudzbenicaId;
    }

    public void setNarudzbenicaId(int narudzbenicaId) {
        this.narudzbenicaId = narudzbenicaId;
    }

    public Korpa getKorpa() {
        return korpa;
    }

    public void setKorpa(Korpa korpa) {
        this.korpa = korpa;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public AdresaIsporuke getAdresaIsporuke() {
        return adresaIsporuke;
    }

    public void setAdresaIsporuke(AdresaIsporuke adresaIsporuke) {
        this.adresaIsporuke = adresaIsporuke;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public List<StavkaNarudzbenice> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaNarudzbenice> stavke) {
        this.stavke = stavke;
    }

    public double getUkupno() {
        return ukupno;
    }

    public void setUkupno(double ukupno) {
        this.ukupno = ukupno;
    }

    
    
    

}
