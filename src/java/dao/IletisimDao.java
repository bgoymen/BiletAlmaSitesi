/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Iletisim;
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
public class IletisimDao extends DBConnection {

    public void create(Iletisim i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into iletisim(mail,Baslik,Konu) values('" + i.getMail() + "','" + i.getBaslik() + "','" + i.getKonu() + "')");
        } catch (SQLException e) {
            System.out.println("Hata(IletisimDao(Create)): " + e.getMessage());
        }
    }

    public List<Iletisim> read() {
        List<Iletisim> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from iletisim order by id asc");

            while (rs.next()) {
                Iletisim tmp = new Iletisim(rs.getInt("id"), rs.getString("mail"), rs.getString("Baslik"), rs.getString("Konu"));
                list.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println("Hata(IletisimDao(read)): " + e.getMessage());
        }
        return list;
    }

    public void delete(int f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from iletisim where id=" + f);
        } catch (SQLException e) {
            System.out.println("Hata(İletişimDao(Delete)):" + e.getMessage());
        }
    }

}
