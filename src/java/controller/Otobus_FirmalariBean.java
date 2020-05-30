/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Otobus_FirmalariDao;
import entity.Otobus_Firmalari;
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
public class Otobus_FirmalariBean implements Serializable {

    private Otobus_FirmalariDao dao;
    private Otobus_Firmalari entity;

    public void create() {
        if (entity.getName().length() == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lütfen Gerekli Yerleri Doldurunuz"));
            
        } else {
            this.getDao().create(entity);
            entity = new Otobus_Firmalari();
           
        }

    }
    
    public void clearForm(){
        this.entity = new Otobus_Firmalari();
    }

    public List<Otobus_Firmalari> getRead() {
        return this.getDao().read();
    }

    public Otobus_Firmalari getById(int id) {
        return this.getDao().getById(id);
    }

    public void updateForm(Otobus_Firmalari f) {
        this.entity = f;
        
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Otobus_Firmalari();
    }

    public void delete(int c) {
        this.getDao().delete(c);

    }

    public Otobus_FirmalariBean() {
    }

    public Otobus_FirmalariBean(Otobus_FirmalariDao dao, Otobus_Firmalari entity) {
        this.dao = dao;
        this.entity = entity;
    }

    public Otobus_FirmalariDao getDao() {
        if (this.dao == null) {
            dao = new Otobus_FirmalariDao();
        }
        return dao;
    }

    public void setDao(Otobus_FirmalariDao dao) {
        this.dao = dao;
    }

    public Otobus_Firmalari getEntity() {
        if (this.entity == null) {
            entity = new Otobus_Firmalari();
        }
        return entity;
    }

    public void setEntity(Otobus_Firmalari entity) {
        this.entity = entity;
    }

}
