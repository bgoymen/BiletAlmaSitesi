/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SeferlerDao;
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
public class SeferlerBean implements Serializable{
    private SeferlerDao dao;
    
    public List<Integer> getKoltuk_sayisi(){
        return this.getDao().koltuk_sayisi();
    }
    
    public List<Integer> getFiyat(){
        return this.getDao().fiyat();
    }

    public SeferlerDao getDao() {
        if(dao == null) dao = new SeferlerDao();
        return dao;
    }

    public void setDao(SeferlerDao dao) {
        this.dao = dao;
    }
    
    
}
