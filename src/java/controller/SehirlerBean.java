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

    public String create() {
        this.getDao().create(entity);
        return "/Admin/Other/Şehirler/Şehirler";
    }

    public List<Sehirler> getRead() {
        return this.getDao().read();
    }

    public String updateForm(Sehirler s) {
        this.entity = s;
        return "/Admin/Other/Şehirler/Update";
    }

    public String update() {
        this.getDao().update(entity);
        return "/Admin/Other/Şehirler/Şehirler";
    }

    public void delete(int c) {
        this.getDao().delete(c);

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

}
