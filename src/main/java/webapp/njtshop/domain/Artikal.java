/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Asus
 */
@Entity
public class Artikal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artikalId;
    
    @NotBlank(message = "Morate uneti naziv")
    private String naziv;
    
    @NotBlank(message = "Morate uneti naziv")
    private String opis;
    
    @Min(value = 1, message = "Cena mora biti veca od 0")
    private double cenaBezPDV;
    
    @Min(value = 0, message = "Kolicina za prodaju ne sme biti negativan broj")
    private int kolicinaZaProdaju;
    
    @OneToMany(mappedBy = "artikal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<StavkaKorpe> listaStaviKorpe;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "poreska_stopa_id", nullable = false)
    private PoreskaStopa poreskaStopa;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kategorija_id", nullable = false)
    private Kategorija kategorija;

    private double cenaSaPDV;
    
    @Transient
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public void izracunajCenuSaPDV(){
        if(poreskaStopa!=null){
            cenaSaPDV = cenaBezPDV + (poreskaStopa.getVrednost()/100)*cenaBezPDV; 
        }
    }
    
    public Artikal() {
    }

    public int getArtikalId() {
        return artikalId;
    }

    public void setArtikalId(int artikalId) {
        this.artikalId = artikalId;
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

    public double getCenaBezPDV() {
        return cenaBezPDV;
    }

    public void setCenaBezPDV(double cenaBezPDV) {
        this.cenaBezPDV = cenaBezPDV;
    }

    public int getKolicinaZaProdaju() {
        return kolicinaZaProdaju;
    }

    public void setKolicinaZaProdaju(int kolicinaZaProdaju) {
        this.kolicinaZaProdaju = kolicinaZaProdaju;
    }

    public List<StavkaKorpe> getListaStaviKorpe() {
        return listaStaviKorpe;
    }

    public void setListaStaviKorpe(List<StavkaKorpe> listaStaviKorpe) {
        this.listaStaviKorpe = listaStaviKorpe;
    }

    public PoreskaStopa getPoreskaStopa() {
        return poreskaStopa;
    }

    public void setPoreskaStopa(PoreskaStopa poreskaStopa) {
        this.poreskaStopa = poreskaStopa;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public double getCenaSaPDV() {
        return cenaSaPDV;
    }

    public void setCenaSaPDV(double cenaSaPDV) {
        this.cenaSaPDV = cenaSaPDV;
    }
    
    
    
}
