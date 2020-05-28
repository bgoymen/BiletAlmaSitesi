/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Tren_SeferleriDao;
import entity.Tren_Seferleri;
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
public class Tren_SeferleriBean implements Serializable {

    private Tren_SeferleriDao dao;
    private Tren_Seferleri entity;

    public String create() {
        this.getDao().create(entity);
        return "/Admin/Seferler/Tren/Tren Seferleri";
    }

    public List<Tren_Seferleri> getRead() {
        return this.getDao().read();
    }

    public String updateForm(Tren_Seferleri s) {
        this.entity = s;
        return "/Admin/Seferler/Tren/Update";
    }

    public String update() {
        this.getDao().update(entity);
        return "/Admin/Seferler/Tren/Tren Seferleri";
    }

    public void delete(int c) {
        this.getDao().delete(c);

    }

    public Tren_SeferleriBean() {
    }

    public Tren_SeferleriBean(Tren_SeferleriDao dao, Tren_Seferleri entity) {
        this.dao = dao;
        this.entity = entity;
    }

    public Tren_SeferleriDao getDao() {
        if (this.dao == null) {
            dao = new Tren_SeferleriDao();
        }
        return dao;
    }

    public void setDao(Tren_SeferleriDao dao) {
        this.dao = dao;
    }

    public Tren_Seferleri getEntity() {
        if (this.entity == null) {
            entity = new Tren_Seferleri();
        }
        return entity;
    }

    public void setEntity(Tren_Seferleri entity) {
        this.entity = entity;
    }

}
