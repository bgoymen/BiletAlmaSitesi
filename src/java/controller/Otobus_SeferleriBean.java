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

    public String create() {
        this.getDao().create(entity);
        return "/Admin/Seferler/Otobüs/Otobüs Seferleri";
    }

    public List<Otobus_Seferleri> getRead() {
        return this.getDao().read();
    }
    
    

    public String updateForm(Otobus_Seferleri s) {
        this.entity = s;
        return "/Admin/Seferler/Otobüs/Update";
    }

    public String update() {
        this.getDao().update(entity);
        return "/Admin/Seferler/Otobüs/Otobüs Seferleri";
    }

    public void delete(int c) {
        this.getDao().delete(c);

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

}
