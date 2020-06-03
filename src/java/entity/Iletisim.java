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
public class Iletisim {

    private int id;
    private String mail;
    private String baslik;
    private String Konu;

    public Iletisim(int id, String mail, String baslik, String Konu) {
        this.id = id;
        this.mail = mail;
        this.baslik = baslik;
        this.Konu = Konu;
    }

    public Iletisim() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getKonu() {
        return Konu;
    }

    public void setKonu(String Konu) {
        this.Konu = Konu;
    }

}
