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
public class Satin_Alinan_Bilet {

    private int id;
    private int user_id;
    private int seyehat_turu;
    private int otobus_firma_id;
    private int ucak_firma_id;
    private int tren_firma_id;
    private int kalkis_nok;
    private int varis_nok;
    private int fiyat;

    public Satin_Alinan_Bilet() {
    }

    public Satin_Alinan_Bilet(int id, int user_id, int seyehat_turu, int otobus_firma_id, int ucak_firma_id, int tren_firma_id, int kalkis_nok, int varis_nok, int fiyat) {
        this.id = id;
        this.user_id = user_id;
        this.seyehat_turu = seyehat_turu;
        this.otobus_firma_id = otobus_firma_id;
        this.ucak_firma_id = ucak_firma_id;
        this.tren_firma_id = tren_firma_id;
        this.kalkis_nok = kalkis_nok;
        this.varis_nok = varis_nok;
        this.fiyat = fiyat;
    }

    public Satin_Alinan_Bilet(int id, int firma_id, int kalkis_nok, int varis_nok, int fiyat, int seyehat_turu) {
        this.id = id;
        this.kalkis_nok = kalkis_nok;
        this.varis_nok = varis_nok;
        this.fiyat = fiyat;
        this.seyehat_turu = seyehat_turu;
        
        switch (seyehat_turu) {
            case 1:
                this.otobus_firma_id = firma_id;
                break;
            case 2:
                this.ucak_firma_id = firma_id;
                break;
            case 3:
                this.tren_firma_id = firma_id;
                break;
            default:
                System.out.println("Hatat(Satin_Alinan_Bilet(2. Yapıladırıcı))");
                break;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSeyehat_turu() {
        return seyehat_turu;
    }

    public void setSeyehat_turu(int seyehat_turu) {
        this.seyehat_turu = seyehat_turu;
    }

    public int getOtobus_firma_id() {
        return otobus_firma_id;
    }

    public void setOtobus_firma_id(int otobus_firma_id) {
        this.otobus_firma_id = otobus_firma_id;
    }

    public int getUcak_firma_id() {
        return ucak_firma_id;
    }

    public void setUcak_firma_id(int ucak_firma_id) {
        this.ucak_firma_id = ucak_firma_id;
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

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

}
