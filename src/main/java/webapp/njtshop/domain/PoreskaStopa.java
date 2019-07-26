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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Asus
 */
@Entity
public class PoreskaStopa {
    @Id
    @GeneratedValue
    private int id;
    private String naziv;
    @Min(value = 1, message = "Vrednost poreske stope mora biti makara 1 %")
    private double vrednost;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "poreskaStopa", cascade = CascadeType.ALL)
    private List<Artikal> artikli = new ArrayList<>();
    
    public PoreskaStopa() {
    }

    public PoreskaStopa(int id, String naziv, double vrednost) {
        this.id = id;
        this.naziv = naziv;
        this.vrednost = vrednost;
    }
    

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv + "(vrednost: " + vrednost + " %)";
    }

    public List<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(List<Artikal> artikli) {
        this.artikli = artikli;
    }
    
    
}
