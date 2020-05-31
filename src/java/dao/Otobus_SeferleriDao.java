/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Otobus_Seferleri;
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
public class Otobus_SeferleriDao extends DBConnection {

    public boolean create(Otobus_Seferleri f) {
        if (f.getKalkis_nok() == f.getVaris_nok()) {
            return false;
        } else {
            try {
                Statement st = this.connect().createStatement();
                st.executeUpdate("insert into otobus_seferleri(firma_id,kalkis_nok, varis_nok,koltuk_sayisi,fiyat) values(" + f.getFirma_id() + "," + f.getKalkis_nok() + "," + f.getVaris_nok() + "," + f.getKoltuk_Sayisi() + "," + f.getFiyat() + ")");

            } catch (SQLException ex) {
                System.out.println("Hata(Otobus_SeferleriDao(Create)):" + ex.getMessage());
            }
            return true;
        }
    }

    public List<Otobus_Seferleri> read() {
        List<Otobus_Seferleri> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from otobus_seferleri order by id asc");
            rs.next();
            while (rs.next()) {
                Otobus_Seferleri tmp = new Otobus_Seferleri(rs.getInt("id"), rs.getInt("firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("koltuk_sayisi"), rs.getInt("fiyat"));

                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_SeferleriDao(read)):" + e.getMessage());
        }

        return list;
    }

    public ResultSet read2(int firma_id) {

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from otobus_seferleri where firma_id=" + firma_id);

            return rs;

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_SeferleriDao(read2)):" + e.getMessage());
        }

        return null;
    }

    public ResultSet read3_kalkis(int sehir_id) {

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from otobus_seferleri where kalkis_nok=" + sehir_id);

            return rs;

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_SeferleriDao(read3_kalkis)):" + e.getMessage());
        }

        return null;
    }

    public ResultSet read3_varis(int sehir_id) {

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from otobus_seferleri where varis_nok=" + sehir_id);

            return rs;

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_SeferleriDao(read3_varis)):" + e.getMessage());
        }

        return null;
    }
    
    public List<Otobus_Seferleri> read(int page, int pageSize) {
        List<Otobus_Seferleri> list = new ArrayList<>();

        int start1 = (page - 1) * pageSize;

        try {
            PreparedStatement pst = this.connect().prepareStatement("select * from otobus_seferleri order by id asc limit " + start1 + "," + pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Otobus_Seferleri tmp = new Otobus_Seferleri(rs.getInt("id"), rs.getInt("firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("koltuk_sayisi"), rs.getInt("fiyat"));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_SeferleriDao(read(int page, int pageSize))):" + e.getMessage());
        }

        return list;
    }

    public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.connect().prepareStatement("select count(id) as otobus_seferleri_count from otobus_seferleri");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("otobus_seferleri_count");

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_SeferleriDao(count)):" + e.getMessage());
        }

        return count;
    }

    public boolean update(Otobus_Seferleri f) {
        if (f.getKalkis_nok() == f.getVaris_nok()) {
            return false;
        } else {
            try {
                Statement st = this.connect().createStatement();
                st.executeUpdate("update otobus_seferleri set firma_id= '" + f.getFirma_id() + "', kalkis_nok= '" + f.getKalkis_nok() + "', varis_nok= '" + f.getVaris_nok() + "',koltuk_sayisi= '" + f.getKoltuk_Sayisi() + "', fiyat='" + f.getFiyat() + "' where id=" + f.getId());

            } catch (SQLException e) {
                System.out.println("Hata(Otobus_SeferleriDao(Update)):" + e.getMessage());
            }
            return true;
        }
    }

    public void delete(int f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from satin_alinan_bilet where otobus_seferleri_id=" + f);
            st.executeUpdate("delete from otobus_seferleri where id=" + f);

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_SeferleriDao(Delete)):" + e.getMessage());
        }
    }

    public int kalkis_nok(int id) {

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from otobus_seferleri order by id asc");
            rs.next();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    return rs.getInt("kalkis_nok");
                }
            }

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_SeferleriDao(kalkis_nok)):" + e.getMessage());
        }
        return -1;
    }

    public int varis_nok(int id) {

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from otobus_seferleri order by id asc");
            rs.next();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    return rs.getInt("varis_nok");
                }
            }

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_SeferleriDao(varis)):" + e.getMessage());
        }
        return -1;
    }

    public int firma_id(int id) {
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from otobus_seferleri order by id asc");
            rs.next();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    return rs.getInt("firma_id");
                }
            }

        } catch (SQLException e) {
            System.out.println("Hata(Otobus_SeferleriDao(firma_id)):" + e.getMessage());
        }
        return -1;
    }
}
