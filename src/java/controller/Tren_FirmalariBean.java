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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public void next() {
        if (page == pageCount) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = pageCount;
        } else {
            this.page--;
        }

    }

    public void create() {
        if (entity.getName().length() == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lütfen Gerekli Yerleri Doldurunuz"));
        } else {
            this.getDao().create(entity);
            entity = new Tren_Firmalari();
        }

    }

    public void clearForm() {
        this.entity = new Tren_Firmalari();
    }

    public List<Tren_Firmalari> getRead() {
        return this.getDao().read(page, pageSize);
    }

    public void updateForm(Tren_Firmalari f) {
        this.entity = f;
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Tren_Firmalari();
    }

    public void delete(int c) {
        this.getDao().delete(c);

    }

    public Tren_Firmalari getById(int id) {
        return this.getDao().getById(id);
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
