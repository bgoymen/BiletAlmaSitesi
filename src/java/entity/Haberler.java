/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Göymen
 */
public class Haberler {
    private int haber_id;
    private String haber;

    public Haberler() {
    }

    public Haberler(int haber_id, String haber) {
        this.haber_id = haber_id;
        this.haber = haber;
    }

    public int getHaber_id() {
        return haber_id;
    }

    public void setHaber_id(int haber_id) {
        this.haber_id = haber_id;
    }

    public String getHaber() {
        return haber;
    }

    public void setHaber(String haber) {
        this.haber = haber;
    }
    
    
}
