/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author viresh
 */
public class Oogmeting {
    private int id;
    private int klant_id;
    private String breekkracht ;
    private String brekingshoek;
    private String sterkte;
        private String voornaam;
    private String achternaam;
    
        public Oogmeting(){
        
    }
    
    public Oogmeting( int klant_id, String breekkracht, String brekingshoek, String sterkte) {
        this.klant_id = klant_id;
        this.breekkracht = breekkracht;
        this.brekingshoek = brekingshoek;
        this.sterkte = sterkte;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKlant_id() {
        return klant_id;
    }

    public void setKlant_id(int klant_id) {
        this.klant_id = klant_id;
    }

    public String getBreekkracht() {
        return breekkracht;
    }

    public void setBreekkracht(String breekkracht) {
        this.breekkracht = breekkracht;
    }

    public String getBrekingshoek() {
        return brekingshoek;
    }

    public void setBrekingshoek(String brekingshoek) {
        this.brekingshoek = brekingshoek;
    }

    public String getSterkte() {
        return sterkte;
    }

    public void setSterkte(String sterkte) {
        this.sterkte = sterkte;
    }

    
    
}
