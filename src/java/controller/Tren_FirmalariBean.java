/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Tren_FirmalariDao;
import entity.Tren_Firmalari;
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
public class Tren_FirmalariBean implements Serializable {

    private Tren_FirmalariDao dao;
    private Tren_Firmalari entity;

    public String create() {
        this.getDao().create(entity);
        return "/Admin/Firmalar/Tren/Tren Firmaları";
    }

    public List<Tren_Firmalari> getRead() {
        return this.getDao().read();
    }

    public String updateForm(Tren_Firmalari f) {
        this.entity = f;
        return "/Admin/Firmalar/Tren/Update";
    }

    public String update() {
        this.getDao().update(entity);
        return "/Admin/Firmalar/Tren/Tren Firmaları";
    }

    public void delete(int c) {
        this.getDao().delete(c);

    }

    public Tren_FirmalariBean() {
    }

    public Tren_FirmalariBean(Tren_FirmalariDao dao, Tren_Firmalari entity) {
        this.dao = dao;
        this.entity = entity;
    }

    public Tren_FirmalariDao getDao() {
        if (this.dao == null) {
            dao = new Tren_FirmalariDao();
        }
        return dao;
    }

    public void setDao(Tren_FirmalariDao dao) {
        this.dao = dao;
    }

    public Tren_Firmalari getEntity() {
        if (this.entity == null) {
            entity = new Tren_Firmalari();
        }
        return entity;
    }

    public void setEntity(Tren_Firmalari entity) {
        this.entity = entity;
    }

}