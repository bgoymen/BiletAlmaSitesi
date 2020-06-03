/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Otobus_Seferleri;
import entity.Satin_Alinan_Bilet;
import entity.Tren_Seferleri;
import entity.Ucak_Seferleri;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

/**
 *
 * @author Göymen
 */
public class Satin_Alinan_BiletDao extends DBConnection {

    public void create(Satin_Alinan_Bilet s) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into satin_alinan_bilet(user_id,seyehat_turu, otobus_seferleri_id,ucak_seferleri_id,tren_seferleri_id,koltuk_no) values(" + s.getUser_id() + "," + s.getSeyehat_turu() + "," + s.getOtobus_seferleri_id() + "," + s.getUcak_seferleri_id() + "," + s.getTren_seferleri_id() + "," + s.getKoltuk_no() + ")");

        } catch (SQLException ex) {
            System.out.println("Hata(Satin_Alinan_BiletDao(Create(1))):" + ex.getMessage());
        }

    }

    public List<Satin_Alinan_Bilet> read_Satin_alinanlari_goster(int id, int seyehat_turu) {
        List<Satin_Alinan_Bilet> list = new ArrayList<>();
        try {

            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from satin_alinan_bilet order by id asc");

            while (rs.next()) {
                if ((rs.getInt("user_id") == id) && (rs.getInt("seyehat_turu") == seyehat_turu)) {
                    Satin_Alinan_Bilet tmp = new Satin_Alinan_Bilet(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("seyehat_turu"), rs.getInt("otobus_seferleri_id"), rs.getInt("ucak_seferleri_id"), rs.getInt("tren_seferleri_id"), rs.getInt("koltuk_no"));
                    list.add(tmp);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Satin_Alinan_BiletDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Otobus_Seferleri> read_otbus_bileti(int kalkis_sehri, int varis_sehri) {

        boolean control = this.readConrol(kalkis_sehri, varis_sehri);
        if (control == false) {
            return null;
        } else {
            List<Otobus_Seferleri> list = new ArrayList<>();
            try {

                Statement st = this.connect().createStatement();
                ResultSet rs = st.executeQuery("select * from otobus_seferleri order by id asc");
                while (rs.next()) {
                    if ((rs.getInt("kalkis_nok") == kalkis_sehri) && (rs.getInt("varis_nok") == varis_sehri)) {
                        Otobus_Seferleri tmp = new Otobus_Seferleri(rs.getInt("id"), rs.getInt("firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("koltuk_sayisi"), rs.getInt("fiyat"));
                        list.add(tmp);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(Satin_Alinan_BiletDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }
    }

    public List<Tren_Seferleri> read_tren_bileti(int kalkis_sehri, int varis_sehri) {

        boolean control = this.readConrol(kalkis_sehri, varis_sehri);
        if (control == false) {
            return null;
        } else {
            List<Tren_Seferleri> list = new ArrayList<>();
            try {

                Statement st = this.connect().createStatement();
                ResultSet rs = st.executeQuery("select * from tren_seferleri order by id asc");
                while (rs.next()) {
                    if ((rs.getInt("kalkis_nok") == kalkis_sehri) && (rs.getInt("varis_nok") == varis_sehri)) {
                        Tren_Seferleri tmp = new Tren_Seferleri(rs.getInt("id"), rs.getInt("tren_firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("koltuk_sayisi"), rs.getInt("fiyat"));
                        list.add(tmp);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(Satin_Alinan_BiletDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }

    }

    public List<Ucak_Seferleri> read_ucak_bileti(int kalkis_sehri, int varis_sehri) {
        boolean control = this.readConrol(kalkis_sehri, varis_sehri);
        if (control == false) {
            return null;
        } else {
            List<Ucak_Seferleri> list = new ArrayList<>();
            try {

                Statement st = this.connect().createStatement();
                ResultSet rs = st.executeQuery("select * from ucak_seferleri order by id asc");
                while (rs.next()) {
                    if ((rs.getInt("kalkis_nok") == kalkis_sehri) && (rs.getInt("varis_nok") == varis_sehri)) {
                        Ucak_Seferleri tmp = new Ucak_Seferleri(rs.getInt("id"), rs.getInt("ucak_firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("koltuk_sayisi"), rs.getInt("fiyat"));
                        list.add(tmp);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(Satin_Alinan_BiletDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }
    }

    public boolean readConrol(int kalkis_nok, int varis_nok) {
        if (kalkis_nok == varis_nok) {
            return false;
        } else {
            return true;
        }
    }

    public void delete(int f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from satin_alinan_bilet where id=" + f);

        } catch (SQLException e) {
            System.out.println("Hata(Satin_Alinan_BiletDao(Delete)):" + e.getMessage());
        }
    }

    public List<Integer> satin_alirken_koltuklar(int koltuk_sayisi) {
        List<Integer> satin_alirken = new ArrayList<>();
        int sayac = 1;
        for (int i = 1; i <= koltuk_sayisi; i++) {
            satin_alirken.add(sayac);
            sayac++;
        }
        return satin_alirken;
    }

    public boolean koltuk_dolu_mu_otobus(int otobus_seferleri_id, int koltuk_no) {
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from satin_alinan_bilet order by id asc");
            while (rs.next()) {
                if ((rs.getInt("otobus_seferleri_id") == otobus_seferleri_id) && (rs.getInt("koltuk_no") == koltuk_no)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Satin_Alinan_BiletDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean koltuk_dolu_mu_tren(int tren_seferleri_id, int koltuk_no) {
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from satin_alinan_bilet order by id asc");
            while (rs.next()) {
                if ((rs.getInt("tren_seferleri_id") == tren_seferleri_id) && (rs.getInt("koltuk_no") == koltuk_no)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Satin_Alinan_BiletDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean koltuk_dolu_mu_ucak(int ucak_seferleri_id, int koltuk_no) {
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from satin_alinan_bilet order by id asc");
            while (rs.next()) {
                if ((rs.getInt("ucak_seferleri_id") == ucak_seferleri_id) && (rs.getInt("koltuk_no") == koltuk_no)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Satin_Alinan_BiletDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public int seyehat_turu(Satin_Alinan_Bilet s) {
        return s.getSeyehat_turu();
    }
}
