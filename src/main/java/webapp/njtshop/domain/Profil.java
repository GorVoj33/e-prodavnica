/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Asus
 */
@Entity
public class Profil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profilId;
    @NotBlank(message = "Morate uneti ime")
    private String ime;
    @NotBlank(message = "Morate uneti prezime")
    private String prezime;
    @NotBlank(message = "Morate uneti kontakt telefon")
    private String kontakt;
    @NotBlank(message = "Morate uneti username, moze biti i vas email")
    private String username;
    @NotBlank(message = "Morate uneti password")
    private String password;
    private boolean enabled;
    @OneToOne
    @JoinColumn(name = "adresa_id")
    private AdresaIsporuke adresaIsporuke;
    @OneToOne
    @JoinColumn(name = "korpa_id")
    @JsonIgnore
    private Korpa korpa;

    public Profil() {
    }

    public int getProfilId() {
        return profilId;
    }

    public void setProfilId(int profilId) {
        this.profilId = profilId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public AdresaIsporuke getAdresaIsporuke() {
        return adresaIsporuke;
    }

    public void setAdresaIsporuke(AdresaIsporuke adresaIsporuke) {
        this.adresaIsporuke = adresaIsporuke;
    }

    public Korpa getKorpa() {
        return korpa;
    }

    public void setKorpa(Korpa korpa) {
        this.korpa = korpa;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    
    
    
}
