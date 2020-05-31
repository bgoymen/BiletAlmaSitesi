/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Ucak_Firmalari;
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
public class Ucak_FirmalariDao extends DBConnection {

    public Ucak_Firmalari getById(int id) {
        Ucak_Firmalari f = null;

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ucak_firmalari where id=" + id);
            rs.next();

            f = new Ucak_Firmalari(rs.getInt("id"), rs.getString("Name"));

        } catch (SQLException e) {
            System.out.println("Hata(UcakFirmalariDao(getById)): " + e.getMessage());
        }

        return f;
    }

    public void create(Ucak_Firmalari f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into ucak_firmalari(Name) values('" + f.getName() + "')");

        } catch (SQLException ex) {
            System.out.println("Hata(Ucak_FirmalariDao(Create)):" + ex.getMessage());
        }
    }

    public List<Ucak_Firmalari> read() {
        List<Ucak_Firmalari> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ucak_firmalari order by id asc");
            rs.next();
            while (rs.next()) {
                Ucak_Firmalari tmp = new Ucak_Firmalari(rs.getInt("id"), rs.getString("Name"));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_FirmalariDao(read)):" + e.getMessage());
        }

        return list;
    }
    
        public List<Ucak_Firmalari> read(int page, int pageSize) {
        List<Ucak_Firmalari> list = new ArrayList<>();

        int start1 = (page - 1) * pageSize;

        try {
            PreparedStatement pst = this.connect().prepareStatement("select * from ucak_firmalari order by id asc limit " + start1 + "," + pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Ucak_Firmalari tmp = new Ucak_Firmalari(rs.getInt("id"), rs.getString("Name"));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_FirmalariDao(read(int page, int pageSize))):" + e.getMessage());
        }

        return list;
    }

    public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.connect().prepareStatement("select count(id) as ucak_firmalari_count from ucak_firmalari");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("ucak_firmalari_count");

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_FirmalariDao(count)):" + e.getMessage());
        }

        return count;
    }

    public void update(Ucak_Firmalari f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update ucak_firmalari set Name= '" + f.getName() + "'where id=" + f.getId());

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_FirmalariDao(Update)):" + e.getMessage());
        }
    }

    public void delete(int f) {
        try {
            Statement st = this.connect().createStatement();
            Ucak_SeferleriDao u = new Ucak_SeferleriDao();
            ResultSet rs = u.read2(f);
            while (rs.next()) {
                st.executeUpdate("delete from satin_alinan_bilet where ucak_seferleri_id=" + rs.getInt("id"));
            }
            st.executeUpdate("delete from ucak_seferleri where ucak_firma_id=" + f);
            st.executeUpdate("delete from ucak_firmalari where id=" + f);

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_FirmalariDao(Delete)):" + e.getMessage());
        }
    }
}
