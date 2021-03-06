/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SehirlerDao;
import entity.Sehirler;
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
public class SehirlerBean implements Serializable {

    private SehirlerDao dao;
    private Sehirler entity;

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
            entity = new Sehirler();
        }

    }

    public void clearForm() {
        this.entity = new Sehirler();
    }

    public List<Sehirler> getRead() {
        return this.getDao().read(page, pageSize);
    }

    public void updateForm(Sehirler s) {
        this.entity = s;
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Sehirler();
    }

    public void delete(int c) {
        this.getDao().delete(c);

    }

    public Sehirler getById(int id) {
        return this.getDao().getById(id);
    }

    public String sehirler() {
        this.entity = new Sehirler();
        return "/Admin/Other/Sehirler/Sehirler?faces-redirect=true";
    }

    public SehirlerBean() {
    }

    public SehirlerBean(SehirlerDao dao, Sehirler entity) {
        this.dao = dao;
        this.entity = entity;
    }

    public SehirlerDao getDao() {
        if (this.dao == null) {
            dao = new SehirlerDao();
        }
        return dao;
    }

    public void setDao(SehirlerDao dao) {
        this.dao = dao;
    }

    public Sehirler getEntity() {
        if (this.entity == null) {
            entity = new Sehirler();
        }
        return entity;
    }

    public void setEntity(Sehirler entity) {
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
