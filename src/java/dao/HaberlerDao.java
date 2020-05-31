/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Haberler;
import java.sql.PreparedStatement;
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

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<Haberler> read(int page, int pageSize) {
        List<Haberler> list = new ArrayList<>();

        int start1 = (page - 1) * pageSize;

        try {
            PreparedStatement pst = this.connect().prepareStatement("select * from haberler order by haber_id asc limit " + start1 + "," + pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Haberler tmp = new Haberler(rs.getInt("haber_id"), rs.getString("Haber"));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Hata(HaberlerDao(read(int page, int pageSize))):" + e.getMessage());
        }

        return list;
    }

    public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.connect().prepareStatement("select count(haber_id) as haberler_count from haberler");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("haberler_count");

        } catch (SQLException e) {
            System.out.println("Hata(HaberlerDao(count)):" + e.getMessage());
        }

        return count;
    }

    public void update(Haberler c) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update haberler set Haber= '" + c.getHaber() + "'where haber_id=" + c.getHaber_id());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int c) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from haberler where haber_id=" + c);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
