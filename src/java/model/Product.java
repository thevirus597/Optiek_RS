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
public class Product {
    private int id;
    private String type;
private String merk;
    private int qty;
    private String naam;
    
    public Product(){
        
    }
    public  Product(String type, String merk, int qty, String naam){
        this.type= type;
        this.merk= merk;
        this.qty = qty;
        this.naam = naam;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
    

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getMerk() {
        return merk;
    }

    public int getQty() {
        return qty;
    }

    public String getNaam() {
        return naam;
    }

    
    
    
    

 
}
