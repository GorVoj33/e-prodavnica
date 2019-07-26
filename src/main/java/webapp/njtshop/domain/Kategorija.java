/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Asus
 */
@Entity
public class Kategorija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kategorijaId;
    @NotBlank(message = "Morate uneti naziv kategorije!")
    private String naziv;
    private String opis;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "kategorija", cascade = CascadeType.ALL)
    private List<Artikal> artikli = new ArrayList<>();;

    public Kategorija() {
    }

    public Kategorija(int kategorijaId, String naziv, String opis, List<Artikal> artikli) {
        this.kategorijaId = kategorijaId;
        this.naziv = naziv;
        this.opis = opis;
        this.artikli = artikli;
    }

    public Kategorija(int kategorijaId, String naziv, String opis) {
        this.kategorijaId = kategorijaId;
        this.naziv = naziv;
        this.opis = opis;
    }
 
    
    public List<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(List<Artikal> artikli) {
        this.artikli = artikli;
    }

    public int getKategorijaId() {
        return kategorijaId;
    }

    public void setKategorijaId(int kategorijaId) {
        this.kategorijaId = kategorijaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
    
}
