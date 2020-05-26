/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IletisimDao;
import entity.Iletisim;
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
public class IletisimBean implements Serializable{

    private IletisimDao dao;

    private Iletisim entity;
    
        public String control(){
        if((entity.getMail() == null) || (entity.getBaslik() == null) || (entity.getKonu() == null)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bir hata Meyadan Geldi"));
            System.out.println(entity.getMail());
            System.out.println(entity.getBaslik());
            System.out.println(entity.getKonu());
            return null;
        }
        else{
            create();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("İşlem Başarılı Bir Şekilde Gerçekleşti"));
            return null;
        }
        
    }

    public String create() {
        this.getDao().create(entity);
        return "index";
    }
    
    public List<Iletisim> getRead(){
        return this.getDao().read();
    }

    public IletisimDao getDao() {
        if (dao == null) {
            dao = new IletisimDao();
        }
        return dao;
    }

    public void setDao(IletisimDao dao) {
        this.dao = dao;
    }

    public Iletisim getEntity() {
        if (entity == null) {
            entity = new Iletisim();
        }
        return entity;
    }

    public void setEntity(Iletisim entity) {
        this.entity = entity;
    }

    public IletisimBean() {
    }

    public IletisimBean(IletisimDao dao, Iletisim entity) {
        this.dao = dao;
        this.entity = entity;
    }
    

}
