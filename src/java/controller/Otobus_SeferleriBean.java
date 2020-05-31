/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Otobus_SeferleriDao;
import entity.Otobus_Seferleri;
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
public class Otobus_SeferleriBean implements Serializable {

    private Otobus_SeferleriDao dao;
    private Otobus_Seferleri entity;

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
        boolean c = this.getDao().create(entity);
        if (c == false) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kalkış Noktası İle Varış Noktası Aynı Olamaz!!"));
        } else {
            entity = new Otobus_Seferleri();
        }

    }

    public List<Otobus_Seferleri> getRead() {
        return this.getDao().read(page, pageSize);
    }

    public void updateForm(Otobus_Seferleri s) {
        this.entity = s;
    }

    public void update() {
        boolean c = this.getDao().update(entity);
        if (c == false) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kalkış Noktası İle Varış Noktası Aynı Olamaz!!"));
        } else {
            this.entity = new Otobus_Seferleri();
            entity = new Otobus_Seferleri();
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

    public Otobus_SeferleriBean() {
    }

    public Otobus_SeferleriBean(Otobus_SeferleriDao dao, Otobus_Seferleri entity) {
        this.dao = dao;
        this.entity = entity;
    }

    public Otobus_SeferleriDao getDao() {
        if (this.dao == null) {
            dao = new Otobus_SeferleriDao();
        }
        return dao;
    }

    public void setDao(Otobus_SeferleriDao dao) {
        this.dao = dao;
    }

    public Otobus_Seferleri getEntity() {
        if (this.entity == null) {
            entity = new Otobus_Seferleri();
        }
        return entity;
    }

    public void setEntity(Otobus_Seferleri entity) {
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
