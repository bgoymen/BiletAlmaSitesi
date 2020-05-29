/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Tren_Firmalari;
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
            
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Hata(OtobusFirmalariDao(getById)): " + e.getMessage());
        }

        return f;
    }

    public void create(Tren_Firmalari f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into tren_firmalari(Name) values('" + f.getName() + "')");
            
            st.close();
            
        } catch (SQLException ex) {
            System.out.println("Hata(Tren_FirmalariDao(Create)):" + ex.getMessage());
        }
    }

    public List<Tren_Firmalari> read() {
        List<Tren_Firmalari> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from tren_firmalari order by id asc");

            while (rs.next()) {
                Tren_Firmalari tmp = new Tren_Firmalari(rs.getInt("id"), rs.getString("Name"));
                list.add(tmp);
            }
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println("Hata(Tren_FirmalariDao(read)):" + e.getMessage());
        }

        return list;
    }

    public void update(Tren_Firmalari f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update tren_firmalari set Name= '" + f.getName() + "'where id=" + f.getId());
            
            st.close();

        } catch (SQLException e) {
            System.out.println("Hata(Tren_FirmalariDao(Update)):" + e.getMessage());
        }
    }

    public void delete(int f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from tren_firmalari where id=" + f);
            
            st.close();
            
        } catch (SQLException e) {
            System.out.println("Hata(Tren_FirmalariDao(Delete)):" + e.getMessage());
        }
    }
}
