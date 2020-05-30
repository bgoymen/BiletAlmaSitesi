/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Ucak_FirmalariDao;
import entity.Ucak_Firmalari;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Göymen
 */
@Named
@SessionScoped
public class Ucak_FirmalariBean implements Serializable {

    private Ucak_FirmalariDao dao;
    private Ucak_Firmalari entity;

    public void create() {
        if (entity.getName().length() == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lütfen Gerekli Yerleri Doldurunuz"));
        } else {
            this.getDao().create(entity);
            entity = new Ucak_Firmalari();
        }
    }

    public void clearForm() {
        this.entity = new Ucak_Firmalari();
    }

    public List<Ucak_Firmalari> getRead() {
        return this.getDao().read();
    }

    public Ucak_Firmalari getById(int id) {
        return this.getDao().getById(id);
    }

    public void updateForm(Ucak_Firmalari f) {
        this.entity = f;
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Ucak_Firmalari();
    }

    public void delete(int c) {
        this.getDao().delete(c);

    }

    public Ucak_FirmalariBean() {
    }

    public Ucak_FirmalariBean(Ucak_FirmalariDao dao, Ucak_Firmalari entity) {
        this.dao = dao;
        this.entity = entity;
    }

    public Ucak_FirmalariDao getDao() {
        if (this.dao == null) {
            dao = new Ucak_FirmalariDao();
        }
        return dao;
    }

    public void setDao(Ucak_FirmalariDao dao) {
        this.dao = dao;
    }

    public Ucak_Firmalari getEntity() {
        if (this.entity == null) {
            entity = new Ucak_Firmalari();
        }
        return entity;
    }

    public void setEntity(Ucak_Firmalari entity) {
        this.entity = entity;
    }

}
