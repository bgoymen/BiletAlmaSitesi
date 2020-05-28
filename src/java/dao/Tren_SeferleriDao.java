/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Tren_Seferleri;
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
public class Tren_SeferleriDao extends DBConnection{
    public void create(Tren_Seferleri s) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into tren_seferleri(tren_firma_id, kalkis_nok, varis_nok, koltuk_sayisi) values(" + s.getTren_firma_id() + "," +s.getKalkis_nok() + "," + s.getVaris_nok() +"," + s.getKoltuk_sayisi()+")");
        } catch (SQLException ex) {
            System.out.println("Hata(Tren_SeferleriDao(Create)):" + ex.getMessage());
        }
    }

    public List<Tren_Seferleri> read() {
        List<Tren_Seferleri> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from tren_seferleri order by id asc");

            while (rs.next()) {
                Tren_Seferleri tmp = new Tren_Seferleri(rs.getInt("id"), rs.getInt("tren_firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("koltuk_sayisi"));
                list.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println("Hata(Tren_SeanslariDao(read)):" + e.getMessage());
        }

        return list;
    }

    public void update(Tren_Seferleri s) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update tren_seferleri set tren_firma_id= '" + s.getTren_firma_id() + "', kalkis_nok= '" + s.getKalkis_nok() + "', varis_nok= '" +s.getVaris_nok()+"',koltuk_sayisi= '"+s.getKoltuk_sayisi()+"' where id=" + s.getId());

        } catch (SQLException e) {
            System.out.println("Hata(Tren_SeferleriDao(Update)):" + e.getMessage());
        }
    }

    public void delete(int s) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from tren_seferleri where id=" + s);
        } catch (SQLException e) {
            System.out.println("Hata(Tren_SeferleriDao(Delete)):" + e.getMessage());
        }
    }
}
