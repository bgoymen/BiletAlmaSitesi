/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Otobus_Firmalari;
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
            
            
            
        }
        catch(SQLException e){
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
            st.executeUpdate("delete from otobus_firmalari where id=" + f);
            
        } catch (SQLException e) {
            System.out.println("Hata(Otobus_FirmalariDao(Delete)):" + e.getMessage());
        }
    }
}
