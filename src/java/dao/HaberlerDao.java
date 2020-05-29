/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Haberler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Göymen
 */
public class HaberlerDao extends DBConnection {

    public void create(Haberler h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into haberler(Haber) values('" + h.getHaber() + "')");
            st.close();
        } catch (SQLException e) {
            System.out.println("Hata(HaberlerDao(Create)): " + e.getMessage());
        }
    }

    public List<Haberler> read() {
        List<Haberler> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from haberler order by haber_id asc");

            while (rs.next()) {
                Haberler tmp = new Haberler(rs.getInt("haber_id"), rs.getString("Haber"));
                list.add(tmp);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public void update(Haberler c) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update haberler set Haber= '" + c.getHaber()+ "'where haber_id="+c.getHaber_id());
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int c) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from haberler where haber_id="+c);
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
