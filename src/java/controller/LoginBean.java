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
public class LoginBean implements Serializable {

    private UsersDao dao;

    private Users entity;

    public String control() throws SQLException {
        ResultSet rs = getRead();
        if (rs == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanıcı Adı Veya Şifre Hatalı"));
            return null;
        } else {
            while (rs.next()) {
                if ((rs.getString("user_mail").equals(entity.getUser_mail())) && (rs.getString("user_password").equals(entity.getUser_password()))) {
                    if (rs.getString("type").equals("0")) {
                        entity.setId(rs.getInt("id"));
                        entity.setUser_name(rs.getString("user_name"));
                        return "Standart/Standart";
                    } else if (rs.getString("type").equals("1")) {
                        return "Admin/Admin";
                    }
                }
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanıcı Adı Veya Şifre Hatalı"));
            return null;
        }
    }

//    public String create() {
//        this.getDao().create(entity);
//        return "index";
//    }
    public ResultSet getRead() {
        return this.getDao().read2();
    }
    
        public String updateForm(Users c) {
        this.entity = c;
        return "/Standart/Ayarlar";
    }

    public String update() {
        this.getDao().update(entity);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bilgileriniz Güncellendi"));
        return "/Standart/Ayarlar";
    }

//    public List<Users> getRead() {
//        return this.getDao().read();
//    }

//    public String update() {
//        this.getDao().update(entity);
//        return "index";
//    }
//    public void delete(int c) {
//        this.getDao().delete(c);
//
//    }
    public LoginBean() {
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
