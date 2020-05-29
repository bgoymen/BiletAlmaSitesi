    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Sehirler;
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
public class SehirlerDao extends DBConnection {

    public void create(Sehirler s) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into sehirler(Name) values('" + s.getName() + "')");
            
            
            
        } catch (SQLException ex) {
            System.out.println("Hata(SehirlerDao(Create)):" + ex.getMessage());
        }
    }

    public List<Sehirler> read() {
        List<Sehirler> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from sehirler order by id asc");
            rs.next();
            while (rs.next()) {
                Sehirler tmp = new Sehirler(rs.getInt("id"), rs.getString("Name"));
                list.add(tmp);
            }
            
            
            
            
        } catch (SQLException e) {
            System.out.println("Hata(SehirlerDao(read)):" + e.getMessage());
        }

        return list;
    }
    
    public Sehirler getById(int id) {
        Sehirler s = null;

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from sehirler where id=" + id);
            rs.next();
            
            s = new Sehirler(rs.getInt("id"), rs.getString("Name"));
            
            
            
            
        }
        catch(SQLException e){
            System.out.println("Hata(OtobusFirmalariDao(getById)): " + e.getMessage());
    }
        
        return s;
    }

    public void update(Sehirler s) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update sehirler set Name= '" + s.getName() + "'where id=" + s.getId());
            
            

        } catch (SQLException e) {
            System.out.println("Hata(SehirlerDao(Update)):" + e.getMessage());
        }
    }

    public void delete(int s) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from sehirler where id=" + s);
            
            
            
        } catch (SQLException e) {
            System.out.println("Hata(SehirlerDao(Delete)):" + e.getMessage());
        }
    }
}
