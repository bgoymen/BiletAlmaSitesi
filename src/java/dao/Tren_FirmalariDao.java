/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Tren_Firmalari;
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
public class Tren_FirmalariDao extends DBConnection {

    public Tren_Firmalari getById(int id) {
        Tren_Firmalari f = null;

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from tren_firmalari where id=" + id);
            rs.next();

            f = new Tren_Firmalari(rs.getInt("id"), rs.getString("Name"));

        } catch (SQLException e) {
            System.out.println("Hata(TrenFirmalariDao(getById)): " + e.getMessage());
        }

        return f;
    }

    public void create(Tren_Firmalari f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into tren_firmalari(Name) values('" + f.getName() + "')");

        } catch (SQLException ex) {
            System.out.println("Hata(Tren_FirmalariDao(Create)):" + ex.getMessage());
        }
    }

    public List<Tren_Firmalari> read() {
        List<Tren_Firmalari> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from tren_firmalari order by id asc");
            rs.next();
            while (rs.next()) {
                Tren_Firmalari tmp = new Tren_Firmalari(rs.getInt("id"), rs.getString("Name"));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Hata(Tren_FirmalariDao(read)):" + e.getMessage());
        }

        return list;
    }

    public List<Tren_Firmalari> read(int page, int pageSize) {
        List<Tren_Firmalari> list = new ArrayList<>();

        int start1 = (page - 1) * pageSize;

        try {
            PreparedStatement pst = this.connect().prepareStatement("select * from tren_firmalari order by id asc limit " + start1 + "," + pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Tren_Firmalari tmp = new Tren_Firmalari(rs.getInt("id"), rs.getString("Name"));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Hata(Tren_FirmalariDao(read(int page, int pageSize))):" + e.getMessage());
        }

        return list;
    }

    public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.connect().prepareStatement("select count(id) as tren_firmalari_count from tren_firmalari");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("tren_firmalari_count");

        } catch (SQLException e) {
            System.out.println("Hata(Tren_FirmalariDao(count)):" + e.getMessage());
        }

        return count;
    }

    public void update(Tren_Firmalari f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update tren_firmalari set Name= '" + f.getName() + "'where id=" + f.getId());

        } catch (SQLException e) {
            System.out.println("Hata(Tren_FirmalariDao(Update)):" + e.getMessage());
        }
    }

    public void delete(int f) {
        try {
            Statement st = this.connect().createStatement();
            Tren_SeferleriDao t = new Tren_SeferleriDao();
            ResultSet rs = t.read2(f);
            while (rs.next()) {
                st.executeUpdate("delete from satin_alinan_bilet where tren_seferleri_id=" + rs.getInt("id"));
            }
            st.executeUpdate("delete from tren_seferleri where tren_firma_id=" + f);
            st.executeUpdate("delete from tren_firmalari where id=" + f);

        } catch (SQLException e) {
            System.out.println("Hata(Tren_FirmalariDao(Delete)):" + e.getMessage());
        }
    }
}
