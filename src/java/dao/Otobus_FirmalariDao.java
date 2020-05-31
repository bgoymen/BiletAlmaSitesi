/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Otobus_Firmalari;
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
public class Otobus_FirmalariDao extends DBConnection {

    public Otobus_Firmalari getById(int id) {
        Otobus_Firmalari f = null;

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from otobus_firmalari where id=" + id);
            rs.next();

            f = new Otobus_Firmalari(rs.getInt("id"), rs.getString("Name"));

        } catch (SQLException e) {
            System.out.println("Hata(OtobusFirmalariDao(getById)): " + e.getMessage());
        }

        return f;
    }

    public void create(Otobus_Firmalari f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into otobus_firmalari(Name) values('" + f.getName() + "')");

        } catch (SQLException ex) {
            System.out.println("Hata(Otobus_FirmalariDao(Create)):" + ex.getMessage());
        }
    }

    public List<Otobus_Firmalari> read() {
        List<Otobus_Firmalari> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from otobus_firmalari order by id asc");
            rs.next();
            while (rs.next()) {
                Otobus_Firmalari tmp = new Otobus_Firmalari(rs.getInt("id"), rs.getString("Name"));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_FirmalariDao(read)):" + e.getMessage());
        }

        return list;
    }

    public List<Otobus_Firmalari> read(int page, int pageSize) {
        List<Otobus_Firmalari> list = new ArrayList<>();
        
        int start1 = (page-1)*pageSize;
        
        try {
            PreparedStatement pst = this.connect().prepareStatement("select * from otobus_firmalari order by id asc limit "+start1+","+pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Otobus_Firmalari tmp = new Otobus_Firmalari(rs.getInt("id"), rs.getString("Name"));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_FirmalariDao(read(int page, int pageSize))):" + e.getMessage());
        }

        return list;
    }
    
        public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.connect().prepareStatement("select count(id) as otobus_firmalari_count from otobus_firmalari");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("otobus_firmalari_count");

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_FirmalariDao(count)):" + e.getMessage());
        }

        return count;
    }

    public void update(Otobus_Firmalari f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update otobus_firmalari set Name= '" + f.getName() + "'where id=" + f.getId());

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_FirmalariDao(Update)):" + e.getMessage());
        }
    }

    public void delete(int f) {
        try {
            Statement st = this.connect().createStatement();
            Otobus_SeferleriDao o = new Otobus_SeferleriDao();
            ResultSet rs = o.read2(f);
            while (rs.next()) {
                st.executeUpdate("delete from satin_alinan_bilet where otobus_seferleri_id=" + rs.getInt("id"));
            }
            st.executeUpdate("delete from otobus_seferleri where firma_id=" + f);
            st.executeUpdate("delete from otobus_firmalari where id=" + f);

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_FirmalariDao(Delete)):" + e.getMessage());
        }
    }
}
