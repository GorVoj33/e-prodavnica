/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Asus
 */
@Entity
public class AdresaIsporuke {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Unesite neku adresu, pri kreiranju narudzbenice ju je moguce zameniti.")
    private String adresa;
    @NotBlank(message = "Unesite naziv grada")
    private String grad;
    private int postanskiKod;
    @OneToOne
    private Profil profil;
    public AdresaIsporuke() {
    }

    public AdresaIsporuke(int id, String adresa, String grad, int postanskiKod) {
        this.id = id;
        this.adresa = adresa;
        this.grad = grad;
        this.postanskiKod = postanskiKod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getPostanskiKod() {
        return postanskiKod;
    }

    public void setPostanskiKod(int postanskiKod) {
        this.postanskiKod = postanskiKod;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }


    
    
    
}
