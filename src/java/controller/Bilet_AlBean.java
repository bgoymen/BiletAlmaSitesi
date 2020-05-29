/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Satin_Alinan_BiletDao;
import entity.Otobus_Seferleri;
import entity.Satin_Alinan_Bilet;
import entity.Tren_Seferleri;
import entity.Ucak_Seferleri;
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

    private Tren_Seferleri t_Sefer;

    private Ucak_Seferleri u_sefer;

    public List<Otobus_Seferleri> getList_otobus_sefer() {
        return this.getDao().read_otbus_bileti(kalkis_sehri, varis_sehri);
    }

    public List<Tren_Seferleri> getList_tren_sefer() {
        return this.getDao().read_tren_bileti(kalkis_sehri, varis_sehri);
    }

    public List<Ucak_Seferleri> getList_ucak_sefer() {
        return this.getDao().read_ucak_bileti(kalkis_sehri, varis_sehri);
    }

    public String bos_koltuk_goz_at_otobus(Otobus_Seferleri s) {
        this.o_sefer = s;
        return "/Standart/Bilet Al/Otobüs/Satın Al";
    }

    public String bos_koltuk_goz_at_tren(Tren_Seferleri s) {
        this.t_Sefer = s;
        return "/Standart/Bilet Al/Tren/Satın Al";
    }

    public String bos_koltuk_goz_at_ucak(Ucak_Seferleri s) {
        this.u_sefer = s;
        return "/Standart/Bilet Al/Uçak/Satın Al";
    }

    public List<Integer> getSatin_Alirken_Koltuklar_otobus() {
        return this.getDao().satin_alirken_koltuklar(o_sefer.getKoltuk_Sayisi());
    }

    public List<Integer> getSatin_Alirken_Koltuklar_tren() {
        return this.getDao().satin_alirken_koltuklar(t_Sefer.getKoltuk_sayisi());
    }

    public List<Integer> getSatin_Alirken_Koltuklar_ucak() {
        return this.getDao().satin_alirken_koltuklar(u_sefer.getKoltuk_sayisi());
    }

    public boolean koltuk_dolu_mu_otobus(int koltuk_no) {
        boolean a = this.getDao().koltuk_dolu_mu_otobus(this.getO_sefer().getId(), koltuk_no);
        return a;
    }

    public boolean koltuk_dolu_mu_tren(int koltuk_no) {
        boolean a = this.getDao().koltuk_dolu_mu_tren(this.getT_Sefer().getId(), koltuk_no);
        return a;
    }

    public boolean koltuk_dolu_mu_ucak(int koltuk_no) {
        boolean a = this.getDao().koltuk_dolu_mu_ucak(this.getU_sefer().getId(), koltuk_no);
        return a;
    }

    public String create_otobus(int koltuk_no) {
        UserBean u = new UserBean();
        entity = new Satin_Alinan_Bilet(u.user_id(), 1, o_sefer.getId(), 0, 0, koltuk_no);
        this.getDao().create(entity);
        return "/Satın Adığım Biletler/Satın Aldığım Biletler";
    }

    public String create_tren(int koltuk_no) {
        UserBean u = new UserBean();
        entity = new Satin_Alinan_Bilet(u.user_id(), 3, 0, 0, t_Sefer.getId(), koltuk_no);
        this.getDao().create(entity);
        return "/Satın Adığım Biletler/Satın Aldığım Biletler";
    }
    
        public String create_ucak(int koltuk_no) {
        UserBean u = new UserBean();
        entity = new Satin_Alinan_Bilet(u.user_id(), 2, 0, u_sefer.getId(), 0, koltuk_no);
        this.getDao().create(entity);
        return "/Satın Adığım Biletler/Satın Aldığım Biletler";
    }

    public Bilet_AlBean() {
    }

    public Bilet_AlBean(Satin_Alinan_BiletDao dao, Satin_Alinan_Bilet entity, int kalkis_sehri, int varis_sehri, Otobus_Seferleri o_sefer, Tren_Seferleri t_Sefer, Ucak_Seferleri u_sefer) {
        this.dao = dao;
        this.entity = entity;
        this.kalkis_sehri = kalkis_sehri;
        this.varis_sehri = varis_sehri;
        this.o_sefer = o_sefer;
        this.t_Sefer = t_Sefer;
        this.u_sefer = u_sefer;
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

    public Tren_Seferleri getT_Sefer() {
        if (this.t_Sefer == null) {
            this.t_Sefer = new Tren_Seferleri();
        }
        return t_Sefer;
    }

    public void setT_Sefer(Tren_Seferleri t_Sefer) {
        this.t_Sefer = t_Sefer;
    }

    public Ucak_Seferleri getU_sefer() {
        if (this.u_sefer == null) {
            u_sefer = new Ucak_Seferleri();
        }
        return u_sefer;
    }

    public void setU_sefer(Ucak_Seferleri u_sefer) {
        this.u_sefer = u_sefer;
    }

}
