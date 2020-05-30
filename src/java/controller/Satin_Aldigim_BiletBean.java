/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Satin_Alinan_BiletDao;
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
public class Satin_Aldigim_BiletBean implements Serializable {

    private Satin_Alinan_BiletDao dao;

    private Satin_Alinan_Bilet entity;

    public List<Satin_Alinan_Bilet> getRead_otobus_biletleri() {

        return this.getDao().read_Satin_alinanlari_goster(LoginBean.getUser_id(), 1);
    }

    public List<Satin_Alinan_Bilet> getRead_ucak_biletleri() {

        return this.getDao().read_Satin_alinanlari_goster(LoginBean.getUser_id(), 2);
    }

    public List<Satin_Alinan_Bilet> getRead_tren_biletleri() {

        return this.getDao().read_Satin_alinanlari_goster(LoginBean.getUser_id(), 3);
    }

    public int seyehat_turu_ogren(Satin_Alinan_Bilet s) {
        return this.getDao().seyehat_turu(s);
    }

    public void delete(int id) {
        this.getDao().delete(id);
    }

    public Satin_Aldigim_BiletBean() {
    }

    public Satin_Aldigim_BiletBean(Satin_Alinan_BiletDao dao, Satin_Alinan_Bilet entity) {
        this.dao = dao;
        this.entity = entity;
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

}
