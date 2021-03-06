/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Ucak_Seferleri;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author bünyamin
 */
public class Ucak_SeferleriDao extends DBConnection {

    public boolean create(Ucak_Seferleri s) {
        if (s.getKalkis_nok() == s.getVaris_nok()) {
            return false;
        } else {
            try {
                Statement st = this.connect().createStatement();
                st.executeUpdate("insert into ucak_seferleri(ucak_firma_id, kalkis_nok, varis_nok, koltuk_sayisi,fiyat) values(" + s.getUcak_firma_id() + "," + s.getKalkis_nok() + "," + s.getVaris_nok() + "," + s.getKoltuk_sayisi() + "," + s.getFiyat() + ")");

            } catch (SQLException ex) {
                System.out.println("Hata(Ucak_SeferleriDao(Create)):" + ex.getMessage());
            }
            return true;
        }
    }

    public List<Ucak_Seferleri> read() {
        List<Ucak_Seferleri> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ucak_seferleri order by id asc");
            rs.next();
            while (rs.next()) {
                Ucak_Seferleri tmp = new Ucak_Seferleri(rs.getInt("id"), rs.getInt("ucak_firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("koltuk_sayisi"), rs.getInt("fiyat"));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_SeferleriDao(read)):" + e.getMessage());
        }

        return list;
    }

    public ResultSet read2(int firma_id) {

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ucak_seferleri where ucak_firma_id=" + firma_id);

            return rs;

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_SeferleriDao(read2)):" + e.getMessage());
        }

        return null;
    }

    public ResultSet read3_kalkis(int sehir_id) {

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ucak_seferleri where kalkis_nok=" + sehir_id);

            return rs;

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_SeferleriDao(read3_kalkis)):" + e.getMessage());
        }

        return null;
    }

    public ResultSet read3_varis(int sehir_id) {

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ucak_seferleri where varis_nok=" + sehir_id);

            return rs;

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_SeferleriDao(read3_varis)):" + e.getMessage());
        }

        return null;
    }

    public List<Ucak_Seferleri> read(int page, int pageSize) {
        List<Ucak_Seferleri> list = new ArrayList<>();

        int start1 = (page - 1) * pageSize;

        try {
            PreparedStatement pst = this.connect().prepareStatement("select * from ucak_seferleri order by id asc limit " + start1 + "," + pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt("id") != 0) {
                    Ucak_Seferleri tmp = new Ucak_Seferleri(rs.getInt("id"), rs.getInt("ucak_firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("koltuk_sayisi"), rs.getInt("fiyat"));
                    list.add(tmp);
                }
            }

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_SeferleriDao(read(int page, int pageSize))):" + e.getMessage());
        }

        return list;
    }

    public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.connect().prepareStatement("select count(id) as ucak_seferleri_count from ucak_seferleri");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("ucak_seferleri_count");

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_SeferleriDao(count)):" + e.getMessage());
        }

        return count;
    }

    public boolean update(Ucak_Seferleri s) {
        if (s.getKalkis_nok() == s.getVaris_nok()) {
            System.out.println("if");
            return false;
        } else {
            System.out.println("else");
            try {
                Statement st = this.connect().createStatement();
                st.executeUpdate("update ucak_seferleri set ucak_firma_id= '" + s.getUcak_firma_id() + "', kalkis_nok= '" + s.getKalkis_nok() + "', varis_nok= '" + s.getVaris_nok() + "',koltuk_sayisi= '" + s.getKoltuk_sayisi() + "',fiyat='" + s.getFiyat() + "' where id=" + s.getId());

            } catch (SQLException e) {
                System.out.println("Hata(Ucak_SeferleriDao(Update)):" + e.getMessage());
            }
            return true;
        }
    }

    public void delete(int s) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from satin_alinan_bilet where ucak_seferleri_id=" + s);
            st.executeUpdate("delete from ucak_seferleri where id=" + s);

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_SeferleriDao(Delete)):" + e.getMessage());
        }
    }

    public int kalkis_nok(int id) {

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ucak_seferleri order by id asc");
            rs.next();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    return rs.getInt("kalkis_nok");
                }
            }

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_SeferleriDao(kalkis_nok)):" + e.getMessage());
        }
        return -1;
    }

    public int varis_nok(int id) {

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ucak_seferleri order by id asc");
            rs.next();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    return rs.getInt("varis_nok");
                }
            }

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_SeferleriDao(varis_nok)):" + e.getMessage());
        }
        return -1;
    }

    public int firma_id(int id) {
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ucak_seferleri order by id asc");
            rs.next();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    return rs.getInt("ucak_firma_id");
                }
            }

        } catch (SQLException e) {
            System.out.println("Hata(Ucak_SeferleriDao(firma_id)):" + e.getMessage());
        }
        return -1;
    }
}
