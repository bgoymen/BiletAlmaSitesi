/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Ucak_SeferleriDao;
import entity.Ucak_Seferleri;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author bünyamin
 */
@Named
@SessionScoped
public class Ucak_SeferleriBean implements Serializable {

    private Ucak_SeferleriDao dao;
    private Ucak_Seferleri entity;

    public String create() {
        boolean c = this.getDao().create(entity);
        if (c == false) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kalkış Noktası İle Varış Noktası Aynı Olamaz!!"));
            entity = new Ucak_Seferleri();
            return "/Admin/Seferler/Uçak/Create";
        } else {
            entity = new Ucak_Seferleri();
            return "/Admin/Seferler/Uçak/Uçak Seferleri";
        }

    }

    public List<Ucak_Seferleri> getRead() {
        return this.getDao().read();
    }

    public String updateForm(Ucak_Seferleri s) {
        this.entity = s;
        return "/Admin/Seferler/Uçak/Update";
    }

    public String update() {
        boolean c = this.getDao().update(entity);
        if (c == false) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kalkış Noktası İle Varış Noktası Aynı Olamaz!!"));
            return "/Admin/Seferler/Uçak/Update";
        } else {
            entity = new Ucak_Seferleri();
            return "/Admin/Seferler/Uçak/Uçak Seferleri";
        }

    }

    public void delete(int c) {
        this.getDao().delete(c);

    }

    public int kalkis_noktasi(int id) {
        return this.getDao().kalkis_nok(id);
    }

    public int varis_noktasi(int id) {
        return this.getDao().varis_nok(id);
    }

    public int firma_id(int id) {
        return this.getDao().firma_id(id);
    }

    public Ucak_SeferleriBean() {
    }

    public Ucak_SeferleriBean(Ucak_SeferleriDao dao, Ucak_Seferleri entity) {
        this.dao = dao;
        this.entity = entity;
    }

    public Ucak_SeferleriDao getDao() {
        if (this.dao == null) {
            dao = new Ucak_SeferleriDao();
        }
        return dao;
    }

    public void setDao(Ucak_SeferleriDao dao) {
        this.dao = dao;
    }

    public Ucak_Seferleri getEntity() {
        if (this.entity == null) {
            entity = new Ucak_Seferleri();
        }
        return entity;
    }

    public void setEntity(Ucak_Seferleri entity) {
        this.entity = entity;
    }
}
