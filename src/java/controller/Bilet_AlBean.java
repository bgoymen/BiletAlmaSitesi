/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Otobus_SeferleriDao;
import dao.Satin_Alinan_BiletDao;
import entity.Otobus_Seferleri;
import entity.Satin_Alinan_Bilet;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Göymen
 */
@Named
@SessionScoped
public class Bilet_AlBean implements Serializable {

    private Satin_Alinan_BiletDao dao;
    private Satin_Alinan_Bilet entity;

    private int kalkis_sehri;

    private int varis_sehri;

    private Otobus_Seferleri o_sefer;

    public List<Otobus_Seferleri> getList_otobus_sefer() {
        return this.getDao().read_otbus_bileti(kalkis_sehri, varis_sehri);
    }

    public String bos_koltuk_goz_at(Otobus_Seferleri s) {
        this.o_sefer = s;
        return "/Standart/Bilet Al/Otobüs/Satın Al";
    }

    public List<Integer> getSatin_Alirken_Koltuklar() {
        return this.getDao().satin_alirken_koltuklar(o_sefer.getKoltuk_Sayisi());
    }

    public boolean koltuk_dolu_mu(int koltuk_no){
        boolean a = this.getDao().koltuk_dolu_mu(this.getO_sefer().getId(), koltuk_no);
        return a;
    }
    
    public String create(int koltuk_no){        
        UserBean u = new UserBean();
        entity = new Satin_Alinan_Bilet(u.user_id(), 1, o_sefer.getId(), 0, 0, koltuk_no);
//        entity = new Satin_Alinan_Bilet(1, u.user_id(), 1, o_sefer.getId(), 0, 0, o_sefer.getKalkis_nok(),o_sefer.getVaris_nok(), o_sefer.getFiyat(),koltuk_no);
        this.getDao().create(entity);
        return "/Satın Adığım Biletler/Satın Aldığım Biletler";
    }
   

    public Bilet_AlBean() {
    }

    public Bilet_AlBean(Satin_Alinan_BiletDao dao, Satin_Alinan_Bilet entity, int kalkis_sehri, int varis_sehri, Otobus_Seferleri o_sefer) {
        this.dao = dao;
        this.entity = entity;
        this.kalkis_sehri = kalkis_sehri;
        this.varis_sehri = varis_sehri;
        this.o_sefer = o_sefer;
    }

    public Satin_Alinan_BiletDao getDao() {
        if (this.dao == null) {
            dao = new Satin_Alinan_BiletDao();
        }
        return dao;
    }

    public void setDao(Satin_Alinan_BiletDao dao) {
        this.dao = dao;
    }

    public Satin_Alinan_Bilet getEntity() {
        if (this.entity == null) {
            entity = new Satin_Alinan_Bilet();
        }
        return entity;
    }

    public void setEntity(Satin_Alinan_Bilet entity) {
        this.entity = entity;
    }

    public int getKalkis_sehri() {
        return kalkis_sehri;
    }

    public void setKalkis_sehri(int kalkis_sehri) {
        this.kalkis_sehri = kalkis_sehri;
    }

    public int getVaris_sehri() {
        return varis_sehri;
    }

    public void setVaris_sehri(int varis_sehri) {
        this.varis_sehri = varis_sehri;
    }

    public Otobus_Seferleri getO_sefer() {
        if (o_sefer == null) {
            o_sefer = new Otobus_Seferleri();
        }
        return o_sefer;
    }

    public void setO_sefer(Otobus_Seferleri o_sefer) {
        this.o_sefer = o_sefer;
    }

}
