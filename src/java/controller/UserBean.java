/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsersDao;
import entity.Users;
import java.io.Serializable;
import java.sql.ResultSet;
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
public class UserBean implements Serializable {

    private UsersDao dao;

    private Users entity;

    public String create() {
        if ((entity.getUser_mail().length() == 0) || (entity.getUser_name().length() == 0) || (entity.getUser_password().length() == 0)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lütfen Gerekli Yerleri Doldurunuz"));
            return null;
        } else {
            this.getDao().create(entity);
            return "/Admin/Other/Kullanıcılar/Kullanıcılar";
        }
    }

    public String clearForm() {
        this.entity = new Users();
        return "/Admin/Other/Kullanıcılar/Kullanıcılar";
    }

    public ResultSet getRead2() {
        return this.getDao().read2();
    }

    public List<Users> getRead() {
        return this.getDao().read();
    }

    public String updateForm(Users c) {
        this.entity = c;
        return "/Admin/Other/Kullanıcılar/Kullanıcılar";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Users();
        return "/Admin/Other/Kullanıcılar/Kullanıcılar";
    }

    public void delete(int c) {
        this.getDao().delete(c);

    }

    public String kullanıcılar() {
        this.entity = new Users();
        return "/Admin/Other/Kullanıcılar/Kullanıcılar";
    }

    public UserBean() {
    }

    public UserBean(UsersDao dao, Users entity) {
        this.dao = dao;
        this.entity = entity;
    }

    public UsersDao getDao() {
        if (this.dao == null) {
            dao = new UsersDao();
        }
        return dao;
    }

    public void setDao(UsersDao dao) {
        this.dao = dao;
    }

    public Users getEntity() {
        if (this.entity == null) {
            entity = new Users();
        }
        return entity;
    }

    public void setEntity(Users entity) {
        this.entity = entity;
    }

}
