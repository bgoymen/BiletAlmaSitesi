/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Sehirler;
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

    public List<Sehirler> read(int page, int pageSize) {
        List<Sehirler> list = new ArrayList<>();

        int start1 = (page - 1) * pageSize;

        try {
            PreparedStatement pst = this.connect().prepareStatement("select * from sehirler order by id asc limit " + start1 + "," + pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt("id") != 0) {
                    Sehirler tmp = new Sehirler(rs.getInt("id"), rs.getString("Name"));
                    list.add(tmp);
                }
            }

        } catch (SQLException e) {
            System.out.println("Hata(SehirlerDao(read(int page, int pageSize))):" + e.getMessage());
        }

        return list;
    }

    public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.connect().prepareStatement("select count(id) as sehirler_count from sehirler");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("sehirler_count");

        } catch (SQLException e) {
            System.out.println("Hata(SehirlerDao(count)):" + e.getMessage());
        }

        return count;
    }

    public Sehirler getById(int id) {
        Sehirler s = null;

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from sehirler where id=" + id);
            rs.next();

            s = new Sehirler(rs.getInt("id"), rs.getString("Name"));

        } catch (SQLException e) {
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
            Otobus_SeferleriDao o = new Otobus_SeferleriDao();
            ResultSet rs_kalkis_o = o.read3_kalkis(s);
            ResultSet rs_varis_o = o.read3_varis(s);
            while (rs_kalkis_o.next()) {
                st.executeUpdate("delete from satin_alinan_bilet where otobus_seferleri_id=" + rs_kalkis_o.getInt("id"));
            }

            while (rs_varis_o.next()) {
                st.executeUpdate("delete from satin_alinan_bilet where otobus_seferleri_id=" + rs_varis_o.getInt("id"));
            }
            st.executeUpdate("delete from otobus_seferleri where kalkis_nok=" + s);
            st.executeUpdate("delete from otobus_seferleri where varis_nok=" + s);
//
            Ucak_SeferleriDao u = new Ucak_SeferleriDao();
            ResultSet rs_kalkis_u = u.read3_kalkis(s);
            ResultSet rs_varis_u = u.read3_varis(s);
            while (rs_kalkis_u.next()) {
                st.executeUpdate("delete from satin_alinan_bilet where ucak_seferleri_id=" + rs_kalkis_u.getInt("id"));
            }

            while (rs_varis_u.next()) {
                st.executeUpdate("delete from satin_alinan_bilet where ucak_seferleri_id=" + rs_varis_u.getInt("id"));
            }
            st.executeUpdate("delete from ucak_seferleri where kalkis_nok=" + s);
            st.executeUpdate("delete from ucak_seferleri where varis_nok=" + s);

            Tren_SeferleriDao t = new Tren_SeferleriDao();
            ResultSet rs_kalkis_t = t.read3_kalkis(s);
            ResultSet rs_varis_t = t.read3_varis(s);
            while (rs_kalkis_t.next()) {
                st.executeUpdate("delete from satin_alinan_bilet where tren_seferleri_id=" + rs_kalkis_t.getInt("id"));
            }

            while (rs_varis_t.next()) {
                st.executeUpdate("delete from satin_alinan_bilet where tren_seferleri_id=" + rs_varis_t.getInt("id"));
            }
            st.executeUpdate("delete from tren_seferleri where kalkis_nok=" + s);
            st.executeUpdate("delete from tren_seferleri where varis_nok=" + s);

            st.executeUpdate("delete from sehirler where id=" + s);

        } catch (SQLException e) {
            System.out.println("Hata(SehirlerDao(Delete)):" + e.getMessage());
        }
    }
}
