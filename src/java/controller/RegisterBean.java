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
import java.sql.SQLException;
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
public class RegisterBean implements Serializable{

    private UsersDao dao;

    private Users entity;

    public String control() throws SQLException {
        ResultSet rs = getRead2();
        if (rs == null) {
            return "Login";
        } else {
            while (rs.next()) {
                if (rs.getString("user_mail").equals(entity.getUser_mail())) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bu E-mail Alınamaz"));
                    return "Register";
                }
            }
            create();
            return "Login";
        }
    }

    public void create() {
        this.getDao().create(entity);
    }

    public ResultSet getRead2() {
        return this.getDao().read2();
    }

    public List<Users> getRead() {
        return this.getDao().read();
    }

    public String updateForm(Users c) {
        this.entity = c;
        return "Update";
    }

    public String update() {
        this.getDao().update(entity);
        return "index";
    }

    public void delete(int c) {
        this.getDao().delete(c);

    }

    public RegisterBean() {
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
