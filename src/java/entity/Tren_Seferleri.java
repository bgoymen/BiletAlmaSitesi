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
public class Tren_Seferleri {

    private int id;
    private int tren_firma_id;
    private int kalkis_nok;
    private int varis_nok;
    private int koltuk_sayisi;

    public Tren_Seferleri() {
    }

    public Tren_Seferleri(int id, int tren_firma_id, int kalkis_nok, int varis_nok, int koltuk_sayisi) {
        this.id = id;
        this.tren_firma_id = tren_firma_id;
        this.kalkis_nok = kalkis_nok;
        this.varis_nok = varis_nok;
        this.koltuk_sayisi = koltuk_sayisi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTren_firma_id() {
        return tren_firma_id;
    }

    public void setTren_firma_id(int tren_firma_id) {
        this.tren_firma_id = tren_firma_id;
    }

    public int getKalkis_nok() {
        return kalkis_nok;
    }

    public void setKalkis_nok(int kalkis_nok) {
        this.kalkis_nok = kalkis_nok;
    }

    public int getVaris_nok() {
        return varis_nok;
    }

    public void setVaris_nok(int varis_nok) {
        this.varis_nok = varis_nok;
    }

    public int getKoltuk_sayisi() {
        return koltuk_sayisi;
    }

    public void setKoltuk_sayisi(int koltuk_sayisi) {
        this.koltuk_sayisi = koltuk_sayisi;
    }

}
