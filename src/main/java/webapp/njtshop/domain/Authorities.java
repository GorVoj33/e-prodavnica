/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp.njtshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Asus
 */

@Entity
public class Authorities {

    @Id
    @GeneratedValue
    private int autoritiesId;

    private String username;
    private String authority;

    public int getAutoritiesId() {
        return autoritiesId;
    }

    public void setAutoritiesId(int autoritiesId) {
        this.autoritiesId = autoritiesId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAutority() {
        return authority;
    }

    public void setAutority(String autority) {
        this.authority = autority;
    }
}