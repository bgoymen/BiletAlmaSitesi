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
        if ((entity.getUser_mail().length() == 0) || (entity.getUser_name().length() == 0) || (entity.getUser_password().length() == 0)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lütfen Gerekli Yerleri Doldurunuz"));
        } else {
            this.getDao().create(entity);
        }
    }

    public void clearForm() {
        this.entity = new Users();
    }

    public ResultSet getRead2() {
        return this.getDao().read2();
    }

    public List<Users> getRead() {
        return this.getDao().read(page, pageSize);
    }

    public void updateForm(Users c) {
        this.entity = c;
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Users();
    }

    public void delete(int c) {
        this.getDao().delete(c);

    }

    public String kullanıcılar() {
        this.entity = new Users();
        return "/Admin/Other/Kullanicilar/Kullanicilar?faces-redirect=true";
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
