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

    public String create() {
        this.getDao().create(entity);
        return "/Admin/Other/Haberler/Haberler";
    }

    public List<Haberler> getRead() {
        return this.getDao().read();
    }

    public String updateForm(Haberler c) {
        this.entity = c;
        return "/Admin/Other/Haberler/Update";
    }

    public String update() {
        this.getDao().update(entity);
        return "/Admin/Other/Haberler/Haberler";
    }

    public void delete(int c) {
        this.getDao().delete(c);

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

}
