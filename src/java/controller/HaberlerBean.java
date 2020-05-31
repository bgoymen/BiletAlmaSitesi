/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.HaberlerDao;
import entity.Haberler;
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
public class HaberlerBean implements Serializable {

    private HaberlerDao dao;

    private Haberler entity;

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
        if (entity.getHaber().length() == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lütfen Gerekli Yerleri Doldurunuz"));
        } else {
            this.getDao().create(entity);
            entity = new Haberler();
        }
    }

    public void clearForm() {
        this.entity = new Haberler();
    }

    public List<Haberler> getRead() {
        return this.getDao().read();
    }

    public void updateForm(Haberler c) {
        this.entity = c;
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Haberler();
    }

    public void delete(int c) {
        this.getDao().delete(c);

    }

    public String haberler() {
        this.entity = new Haberler();
        return "/Admin/Other/Haberler/Haberler?faces-redirect=true";
    }

    public HaberlerBean() {
    }

    public HaberlerBean(HaberlerDao dao, Haberler entity) {
        this.dao = dao;
        this.entity = entity;
    }

    public HaberlerDao getDao() {
        if (this.dao == null) {
            dao = new HaberlerDao();
        }
        return dao;
    }

    public void setDao(HaberlerDao dao) {
        this.dao = dao;
    }

    public Haberler getEntity() {
        if (this.entity == null) {
            this.entity = new Haberler();
        }
        return entity;
    }

    public void setEntity(Haberler entity) {
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
