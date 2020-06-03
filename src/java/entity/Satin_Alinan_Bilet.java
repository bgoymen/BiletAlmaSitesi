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
    private int otobus_seferleri_id;
    private int ucak_seferleri_id;
    private int tren_seferleri_id;
    private int koltuk_no;

    public Satin_Alinan_Bilet() {
    }

    public Satin_Alinan_Bilet(int id, int user_id, int seyehat_turu, int otobus_seferleri_id, int ucak_seferleri_id, int tren_seferleri_id, int koltuk_no) {
        this.id = id;
        this.user_id = user_id;
        this.seyehat_turu = seyehat_turu;
        this.otobus_seferleri_id = otobus_seferleri_id;
        this.ucak_seferleri_id = ucak_seferleri_id;
        this.tren_seferleri_id = tren_seferleri_id;
        this.koltuk_no = koltuk_no;
    }

    public Satin_Alinan_Bilet(int user_id, int seyehat_turu, int otobus_seferleri_id, int ucak_seferleri_id, int tren_seferleri_id, int koltuk_no) {
        this.user_id = user_id;
        this.seyehat_turu = seyehat_turu;
        this.otobus_seferleri_id = otobus_seferleri_id;
        this.ucak_seferleri_id = ucak_seferleri_id;
        this.tren_seferleri_id = tren_seferleri_id;
        this.koltuk_no = koltuk_no;
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

    public int getOtobus_seferleri_id() {
        return otobus_seferleri_id;
    }

    public void setOtobus_seferleri_id(int otobus_seferleri_id) {
        this.otobus_seferleri_id = otobus_seferleri_id;
    }

    public int getUcak_seferleri_id() {
        return ucak_seferleri_id;
    }

    public void setUcak_seferleri_id(int ucak_seferleri_id) {
        this.ucak_seferleri_id = ucak_seferleri_id;
    }

    public int getTren_seferleri_id() {
        return tren_seferleri_id;
    }

    public void setTren_seferleri_id(int tren_seferleri_id) {
        this.tren_seferleri_id = tren_seferleri_id;
    }

    public int getKoltuk_no() {
        return koltuk_no;
    }

    public void setKoltuk_no(int koltuk_no) {
        this.koltuk_no = koltuk_no;
    }

}
