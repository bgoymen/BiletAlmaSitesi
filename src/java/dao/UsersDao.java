/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Satin_Alinan_Bilet;
import entity.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import util.DBConnection;

/**
 *
 * @author bünyamin
 */
public class UsersDao extends DBConnection {

    public void create(Users c) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into users(user_mail,user_name,user_password) values('" + c.getUser_mail() + "','" + c.getUser_name() + "','" + c.getUser_password() + "')");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Users> read() {
        List<Users> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from users order by id asc");
            rs.next();
            while (rs.next()) {
                Users tmp = new Users(rs.getInt("id"), rs.getString("user_mail"), rs.getString("user_name"), rs.getString("user_password"), rs.getInt("type"));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
        public List<Users> read(int page, int pageSize) {
        List<Users> list = new ArrayList<>();

        int start1 = (page - 1) * pageSize;

        try {
            PreparedStatement pst = this.connect().prepareStatement("select * from users order by id asc limit " + start1 + "," + pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Users tmp = new Users(rs.getInt("id"), rs.getString("user_mail"), rs.getString("user_name"), rs.getString("user_password"), rs.getInt("type"));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Hata(UsersDao(read(int page, int pageSize))):" + e.getMessage());
        }

        return list;
    }

    public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.connect().prepareStatement("select count(id) as users_count from users");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("users_count");

        } catch (SQLException e) {
            System.out.println("Hata(UsersDao(count)):" + e.getMessage());
        }

        return count;
    }
    
    public Users control(String user_mail, String user_password) throws SQLException {
        ResultSet rs = this.read2();
        Users u = new Users();
        if (rs == null) {
            return null;
        } else {
            while (rs.next()) {
                if ((rs.getString("user_mail").equals(user_mail)) && (rs.getString("user_password").equals(user_password))) {
                    
                    u = new Users(rs.getInt("id"), rs.getString("user_mail"), rs.getString("user_name"), rs.getString("user_password"), rs.getInt("type"));
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", u);    
                    return u;
                }
            }

            return null;
        }
    }

    public boolean control(String user_mail) throws SQLException {
        ResultSet rs = this.read2();
        if (rs == null) {
            return true;
        } else {
            while (rs.next()) {
                if (rs.getString("user_mail").equals(user_mail)) {
                    return false;
                }
            }

            return true;
        }
    }

    public ResultSet read2() {
        List<Users> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            Statement st = this.connect().createStatement();
            rs = st.executeQuery("select * from users order by id asc");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public void update(Users c) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update users set user_mail= '" + c.getUser_mail() + "', user_name= '" + c.getUser_name() + "', user_password= '" + c.getUser_password() + "'where id=" + c.getId());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int c) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from users where id=" + c);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
