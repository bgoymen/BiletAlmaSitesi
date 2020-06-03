/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author bünyamin
 */
public class Users {

    private int id;

    @Email(message = "Lütfen geçerli bir email giriniz!")
    private String user_mail;

    @NotEmpty(message = "Kullanıcı Adı Boş Bırakılamaz")
    private String user_name;

    private String user_password;
    private int type;

    public Users() {
    }

    public Users(int id, String user_mail, String user_name, String user_password, int type) {
        this.id = id;
        this.user_mail = user_mail;
        this.user_name = user_name;
        this.user_password = user_password;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
